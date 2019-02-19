package com.aikam.test.ordertest.repositories;

import com.aikam.test.ordertest.entities.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderProducts, Integer> {

}
