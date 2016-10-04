package com.msg.springtraining.myproject;

import com.msg.springtraining.myproject.service.ProductService;
import com.msg.springtraining.myproject.service.StoreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

    public static void main(String[] args) {

        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final ProductService productService = applicationContext.getBean(ProductService.class);
        final StoreService storeService = applicationContext.getBean(StoreService.class);

        storeService.getStores().forEach(System.out::println);
    }
}
