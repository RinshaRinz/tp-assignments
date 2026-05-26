package com.example.results;

import com.example.model.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductResults {
    List<Product> products = new ArrayList<>();

    public ProductResults() {
        products = Arrays.asList(
                new Product("11", "Mouse",null, 100, true, 10),
                new Product("22", "Keyboard","test", 200, false, 15),
                new Product("33", "Charger",null, 100, true, 5),
                new Product("44", "Laptop", "test",300, true, 20),
                new Product("55", "Headphones", null,1000, false, 25)
        );
    }


    public void getResults(){

        //        1.	Remove out-of-stock products
        System.out.println("-------------------1.\tRemove out-of-stock products ----------------");
        products.stream().filter(p -> !p.isInStock()).
                forEach(p -> System.out.println(p.getName()));

        System.out.println();
        System.out.println();
        System.out.println();

//        2.	Apply discount on products
        System.out.println("-------------------2.\tApply discount on products----------------");
        System.out.println(products.stream().map(this::getFinalPrice).toList());
        System.out.println();
        System.out.println();
        System.out.println();

//        3.	Calculate total cart amount
        System.out.println("-------------------3.\tCalculate total cart amount----------------");
        System.out.println(products.stream().mapToDouble(Product::getPrice).sum());
        System.out.println();
        System.out.println();
        System.out.println();

//        4.	Find most expensive product
        System.out.println("-------------------4.\tFind most expensive product----------------");
        products.stream().sorted((p1,p2) -> Double.compare(p2.getPrice(), p1.getPrice())).
                limit(1).forEach(p -> System.out.println(p.getName()));


//        5.	Sort products by price
        System.out.println("-------------------5.\tSort products by price----------------");
        products.stream().sorted(Comparator.comparing(Product::getPrice)).forEach(p -> System.out.println(p.getName()));

//        6.	Display products with final discounted price
        System.out.println("-------------------5.\tDisplay products with final discounted price----------------");
        products.stream().forEach( p -> System.out.println( p.getName() + " : " + getFinalPrice(p)));

//        7.	Handle null product description using Optional
        System.out.println("-------------------6.\tHandle null product description using Optional----------------");

        products.forEach(p -> {
            System.out.println( p.getDescription().orElse("No Description"));
        });

    }


    public double getFinalPrice(Product p) {
        return p.getPrice() - (p.getPrice() * p.getDiscountPercentage() / 100);
    }


}
