package com.gmail.samonenko;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

enum Color {
    RED,
    GREEN,
    BLUE
}

enum Size {
    SMALL,
    MEDIUM,
    LARGE
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Product {
    public String name;
    public Color color;
    public Size size;
}

interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}

@AllArgsConstructor
class ColorSpecification implements Specification<Product> {

    private Color color;

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}

class FilterImpl implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(i -> spec.isSatisfied(i));
    }
}

@AllArgsConstructor
class SizeSpecification implements Specification<Product> {

    private Size size;

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}

public class SpecificationPattern {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Tree", Color.GREEN, Size.MEDIUM));
        products.add(new Product("Apple", Color.RED, Size.SMALL));
        products.add(new Product("Toy", Color.BLUE, Size.SMALL));

        FilterImpl filter = new FilterImpl();
        filter.filter(products, new ColorSpecification(Color.GREEN)).forEach(p -> System.out.print(p));
    }
}
