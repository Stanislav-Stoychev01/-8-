package com.PISZaverka.demo.Repository;

import com.PISZaverka.demo.Entity.Order_AvailableShoes;
import com.PISZaverka.demo.Keys.OrderAvailableShoesCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderAvailableShoesRepo extends JpaRepository<Order_AvailableShoes, OrderAvailableShoesCompositeKey> {
}
