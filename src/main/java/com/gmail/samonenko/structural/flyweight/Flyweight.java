package com.gmail.samonenko.structural.flyweight;

class Sentence {

    private String plainText;

    public Sentence(String plainText) {
        this.plainText = plainText;
    }

    public WordToken getWord(int index) {
        return null;
    }

    @Override
    public String toString() {
        // todo
        return null;
    }

    class WordToken {
        public boolean capitalize;
    }
}

/**
 * Motivation: Storing externally the data associated with several objects.(For saving storage space) TODO
 */
public class Flyweight {

    public static void main(String[] args) {

    }

}
