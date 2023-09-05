package org.example;
import java.util.Scanner;
import java.util.ArrayList;

public class WordCRUD implements ICRUD{
    Scanner s;
    ArrayList<Word> list;

    public WordCRUD(Scanner s) {
        this.s = s;
        list = new ArrayList<>();
    }

    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력: ");
        int level = s.nextInt();
        String word = s.nextLine();
        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();

        return new Word(0, level, word, meaning); // take note of the new keyword
    }

    public void addWordToList(){
        Word word = (Word)add();
        list.add(word);
        System.out.println("새 단어가 단어장에 추가되었습니다\n");
    }

    public int update(Object obj) {
        return 0;
    }

    public int delete(Object obj) {
        return 0;
    }

    public void selectOne(int id) {

    }

    public void showAll(){
        for(int i = 0; i < 32; i++){System.out.print("-");}
        System.out.println();

        for(int i = 0; i < list.size(); i++){
            System.out.println(i+1 + " " + list.get(i).toString());
        }

        if(list.size() == 0) System.out.println("등록된 단어가 없습니다");
        //else System.out.println(list.size());

        for(int i = 0; i < 32; i++){System.out.print("-");}
        System.out.println("\n");

    }
}
