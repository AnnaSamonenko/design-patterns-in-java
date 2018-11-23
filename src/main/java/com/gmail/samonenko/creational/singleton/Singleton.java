package com.gmail.samonenko.creational.singleton;

class SingletonPattern {

    private static SingletonPattern singleton;

    private SingletonPattern() {
    }

    public synchronized static SingletonPattern getInstance() {
        if (singleton == null) {
            singleton = new SingletonPattern();
        }
        return singleton;
    }

}

/**
 * Motivation: to create only one instance of a object.
 */
public class Singleton {

    public static void main(String[] args) {
        SingletonPattern singletonPattern1 = SingletonPattern.getInstance();
        SingletonPattern singletonPattern2 = SingletonPattern.getInstance();

        if (singletonPattern1 == singletonPattern2)
            System.out.println("Singleton");
    }

}
