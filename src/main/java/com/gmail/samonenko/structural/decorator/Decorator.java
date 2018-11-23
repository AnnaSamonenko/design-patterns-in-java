package com.gmail.samonenko.structural.decorator;

class Bird {
    public int age;

    public String fly() {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard {
    public int age;

    public String crawl() {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon {
    private int age;
    private Lizard lizard;
    private Bird bird;

    public Dragon() {
        lizard = new Lizard();
        bird = new Bird();
    }

    public String fly() {
        return bird.fly();
    }

    public String crawl() {
        return lizard.crawl();
    }

    public void setAge(int age) {
        this.age = age;
        lizard.age = age;
        bird.age = age;
    }
}

/**
 * Motivation: Adding behavior without changing the class.(In cases when the class is final).
 */
public class Decorator {

    public static void main(String[] args) {
        Dragon dragon = new Dragon();
        System.out.println(dragon.fly());
        System.out.print(dragon.crawl());
    }

}
