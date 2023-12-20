package com.PISZaverka.demo.Repository;

import com.PISZaverka.demo.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    Optional<Orders> findOrderByUser(String name);
}

