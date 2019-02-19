package com.aikam.test.ordertest.controllers;

import com.aikam.test.ordertest.entities.OrderProducts;
import com.aikam.test.ordertest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public String main() {
        return "main";
    }

    @PostMapping
    public String getInfoAboutOrder(@RequestParam String orderId,
                                    Map<String, Object> model) {

        //ID не должен быть пустым и должен быть только числом
        if (orderId != null && orderId.matches("[-+]?\\d+")) {
            Optional<OrderProducts> orderProductsId = orderRepository.findById(Integer.parseInt(orderId));
            //Проверяем существует ли ID (Номер) заказа
            if (orderProductsId.isPresent()) {
                OrderProducts orderProducts =
                        orderRepository.findById(Integer.parseInt(orderId)).orElse(new OrderProducts());
                model.put("orders", orderProducts);
                return "main";
            } else {
                return "main";
            }
        } else {
            return "main";
        }
    }


}
