package org.example;

public class Word {
    private int id;
    private int level;
    private String word;
    private String meaning;

    @Override
    public String toString() {
        String returnStr = "";
        String stars = "";
        for(int i = 0; i < this.level; i++){stars += "*";}

        returnStr = String.format("%-3s", stars) + String.format("%15s", this.word) + "  " + this.meaning;

        return returnStr;
    }

    Word(){}

    public Word(int id, int level, String word, String meaning) {
        this.id = id;
        this.level = level;
        this.word = word;
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
