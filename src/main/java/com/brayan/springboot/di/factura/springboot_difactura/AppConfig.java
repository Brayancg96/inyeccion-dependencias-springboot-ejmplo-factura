package com.brayan.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.brayan.springboot.di.factura.springboot_difactura.models.Item;
import com.brayan.springboot.di.factura.springboot_difactura.models.Product;


@Configuration
@PropertySource(value = "classpath:text.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean      
    List<Item> itemsInvoice() {
        Product p1 = new Product("Camara sony", 800);
        Product p2 = new Product("Bicicleta bianchi", 1500);
        List<Item> items = Arrays.asList(new Item(p1, 2), new Item(p2, 4));

        return items;
    }

    @Bean
    @Primary      
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Monitor asus", 9500);
        Product p2 = new Product("Notebook Raze", 6300);
        Product p3 = new Product("Impresora Epson", 6300);
        Product p4 = new Product("Escritorio oficina", 6300);
        List<Item> items = Arrays.asList(new Item(p1, 2), new Item(p2, 4), new Item(p3, 4), new Item(p4, 6));

        return items;
    }


}
