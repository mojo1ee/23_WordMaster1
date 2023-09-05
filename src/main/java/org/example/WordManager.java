package org.example;
import java.util.Scanner;


public class WordManager {

    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;


    public WordManager() {
        wordCRUD = new WordCRUD(s);
    }

    public void start(){
        selectMenu();
    }

    public void showMenu(){
        System.out.println("*** 영단어 마스터 ***\n");
        System.out.println("********************");
        System.out.print("1. 모든 단어 보기\n" +
                "2. 수준별 단어 보기\n" +
                "3. 단어 검색\n" +
                "4. 단어 추가\n" +
                "5. 단어 수정\n" +
                "6. 단어 삭제\n" +
                "7. 파일 저장\n" +
                "0. 나가기\n");
        System.out.println("********************");
        System.out.print("=> 원하는 메뉴는? ");
    }
    public void selectMenu(){
        while(true) {
            showMenu();
            int menu = s.nextInt();
            if (menu == 0) {
                break;
            }
            else if (menu == 1) { // show all words
                //System.out.println("#1");
                wordCRUD.showAll();
            }
            else if (menu == 4) { // add
                //System.out.println("#4");
                wordCRUD.addWordToList();
            }
        }
    }
}
