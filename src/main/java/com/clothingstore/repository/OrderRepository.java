package com.clothingstore.repository;

import com.clothingstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerEmailIgnoreCase(String customerEmail);

    List<Order> findByStatusIgnoreCase(String status);
}
