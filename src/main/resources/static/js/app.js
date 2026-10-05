// AURA AI Clothing Store - Client Application Logic

let products = [];
let cart = [];
let activeCategory = 'ALL';

document.addEventListener('DOMContentLoaded', () => {
  fetchProducts();
  setupEventListeners();
});

// Fetch all products from Spring Boot REST API
async function fetchProducts(category = '', search = '') {
  let url = '/api/products';
  const params = new URLSearchParams();
  
  if (category && category !== 'ALL') {
    params.append('category', category);
  }
  if (search) {
    params.append('search', search);
  }
  if ([...params].length > 0) {
    url += '?' + params.toString();
  }

  try {
    const res = await fetch(url);
    if (!res.ok) throw new Error('Failed to fetch catalog');
    products = await res.json();
    renderProducts(products, 'productGrid');
  } catch (err) {
    console.error('API connection error:', err);
  }
}

// Render product cards into grid
function renderProducts(items, targetId) {
  const container = document.getElementById(targetId);
  if (!container) return;

  if (items.length === 0) {
    container.innerHTML = `
      <div style="grid-column: 1/-1; text-align:center; padding: 40px; color: var(--text-muted);">
        <p style="font-size: 1.2rem;">No clothing items found matching your filter.</p>
      </div>`;
    return;
  }

  container.innerHTML = items.map(product => `
    <div class="product-card">
      <div class="product-image-wrap">
        <img src="${product.imageUrl || 'https://images.unsplash.com/photo-1515886657613-9f3515b0c78f?auto=format&fit=crop&w=800&q=80'}" 
             alt="${product.name}" class="product-image" loading="lazy">
        ${product.featured ? `<span class="badge-featured">🌟 Featured</span>` : ''}
      </div>
      <div class="product-details">
        <div class="product-cat">${product.category || 'Apparel'} &bull; ${product.style || 'Modern'}</div>
        <h3 class="product-title">${product.name}</h3>
        <p class="product-desc">${product.description || ''}</p>
        <div class="product-meta">
          <span class="product-price">$${parseFloat(product.price).toFixed(2)}</span>
          <button class="btn-add-cart" onclick="addToCart(${product.id})">
            + Add to Bag
          </button>
        </div>
      </div>
    </div>
  `).join('');
}

// Event Listeners setup
function setupEventListeners() {
  // Category Pills
  const catPills = document.querySelectorAll('.cat-pill');
  catPills.forEach(pill => {
    pill.addEventListener('click', (e) => {
      catPills.forEach(p => p.classList.remove('active'));
      e.target.classList.add('active');
      activeCategory = e.target.dataset.category;
      const searchVal = document.getElementById('searchInput').value;
      fetchProducts(activeCategory, searchVal);
    });
  });

  // Search input debounce
  const searchInput = document.getElementById('searchInput');
  let timeout = null;
  searchInput.addEventListener('input', (e) => {
    clearTimeout(timeout);
    timeout = setTimeout(() => {
      fetchProducts(activeCategory, e.target.value);
    }, 300);
  });

  // AI Form Submit
  const aiForm = document.getElementById('aiForm');
  aiForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    await generateAiRecommendation();
  });

  // Cart Modal Toggle
  const cartToggleBtn = document.getElementById('cartToggleBtn');
  const cartCloseBtn = document.getElementById('cartCloseBtn');
  const cartModal = document.getElementById('cartModal');

  cartToggleBtn.addEventListener('click', () => cartModal.classList.add('active'));
  cartCloseBtn.addEventListener('click', () => cartModal.classList.remove('active'));
  
  // Checkout Action
  const checkoutBtn = document.getElementById('checkoutBtn');
  checkoutBtn.addEventListener('click', handleCheckout);
}

// AI Recommendation Request Handler
async function generateAiRecommendation() {
  const submitBtn = document.getElementById('aiSubmitBtn');
  const prompt = document.getElementById('aiPrompt').value;
  const occasion = document.getElementById('aiOccasion').value;
  const preferredStyle = document.getElementById('aiStyle').value;
  const maxBudget = parseFloat(document.getElementById('aiBudget').value) || 300;

  submitBtn.disabled = true;
  submitBtn.innerHTML = `<span>Styling...</span> ⏳`;

  try {
    const res = await fetch('/api/ai/recommend', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ prompt, occasion, preferredStyle, maxBudget })
    });

    if (!res.ok) throw new Error('AI recommendation failed');
    const data = await res.json();

    displayAiResults(data);
  } catch (err) {
    console.error(err);
    alert('AI Stylist service is initializing. Please try again.');
  } finally {
    submitBtn.disabled = false;
    submitBtn.innerHTML = `<span>Generate Outfit</span> ✨`;
  }
}

// Display AI Results
function displayAiResults(data) {
  const container = document.getElementById('aiResults');
  const vibeBadge = document.getElementById('aiVibeBadge');
  const summaryText = document.getElementById('aiSummaryText');
  const tipsList = document.getElementById('aiTipsList');

  vibeBadge.textContent = `✨ Vibe: ${data.styleVibe || 'Curated Outfit'}`;
  summaryText.textContent = data.adviceSummary || 'Here is your custom curated ensemble.';

  tipsList.innerHTML = (data.stylingTips || []).map(tip => `
    <div class="ai-tip-pill">💡 ${tip}</div>
  `).join('');

  renderProducts(data.recommendedProducts || [], 'aiRecommendedGrid');
  container.style.display = 'block';
  container.scrollIntoView({ behavior: 'smooth' });
}

// Cart logic
function addToCart(productId) {
  const item = products.find(p => p.id === productId);
  if (!item) return;

  const existing = cart.find(c => c.productId === productId);
  if (existing) {
    existing.quantity += 1;
  } else {
    cart.push({
      productId: item.id,
      productName: item.name,
      price: item.price,
      quantity: 1,
      selectedSize: item.size || 'M',
      selectedColor: item.color || 'Standard',
      imageUrl: item.imageUrl
    });
  }

  updateCartUI();
  document.getElementById('cartModal').classList.add('active');
}

function updateCartUI() {
  const cartCount = document.getElementById('cartCount');
  const cartList = document.getElementById('cartItemsList');
  const cartTotal = document.getElementById('cartTotalPrice');

  const totalQty = cart.reduce((sum, item) => sum + item.quantity, 0);
  const totalPrice = cart.reduce((sum, item) => sum + (item.price * item.quantity), 0);

  cartCount.textContent = totalQty;
  cartTotal.textContent = `$${totalPrice.toFixed(2)}`;

  if (cart.length === 0) {
    cartList.innerHTML = `<p style="color:var(--text-muted); text-align:center; margin-top:40px;">Your cart is currently empty.</p>`;
    return;
  }

  cartList.innerHTML = cart.map(item => `
    <div class="cart-item">
      <img src="${item.imageUrl}" class="cart-item-img" alt="${item.productName}">
      <div class="cart-item-details">
        <div class="cart-item-title">${item.productName}</div>
        <div style="font-size:0.8rem; color:var(--text-secondary);">Qty: ${item.quantity} | Size: ${item.selectedSize}</div>
        <div class="cart-item-price">$${(item.price * item.quantity).toFixed(2)}</div>
      </div>
    </div>
  `).join('');
}

// Handle Order Checkout
async function handleCheckout() {
  if (cart.length === 0) {
    alert('Your bag is empty.');
    return;
  }

  const orderPayload = {
    customerName: 'Valued Customer',
    customerEmail: 'customer@aura.ai',
    shippingAddress: '742 Fashion Boulevard, New York, NY 10001',
    totalPrice: cart.reduce((sum, item) => sum + (item.price * item.quantity), 0),
    items: cart
  };

  try {
    const res = await fetch('/api/orders', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(orderPayload)
    });

    if (!res.ok) throw new Error('Checkout failed');
    const createdOrder = await res.json();

    alert(`Order #${createdOrder.id} successfully placed! Thank you for shopping with AURA.`);
    cart = [];
    updateCartUI();
    document.getElementById('cartModal').classList.remove('active');
  } catch (err) {
    alert('Unable to complete checkout. Please try again.');
  }
}
