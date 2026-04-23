package com.kusen.repository;

import com.kusen.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    List<Order> findBySessionId(String sessionId);
    
    Optional<Order> findFirstBySessionIdOrderByTanggalOrderDesc(String sessionId);
    
    List<Order> findByStatusOrderByTanggalOrderDesc(com.kusen.model.OrderStatus status);
}
