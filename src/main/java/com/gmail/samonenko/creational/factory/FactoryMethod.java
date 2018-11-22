package com.gmail.samonenko.creational.factory;

/**
 * Motivation: to use for overloading of constructor, when the type and amount of parameters is the same.
 */

class Person {
    public int id;
    public String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class PersonFactory {
    private int id = 0;

    public Person createPerson(String name) {
        return new Person(id++, name);
    }
}

public class FactoryMethod {

    public static void main(String[] args) {

    }

}
