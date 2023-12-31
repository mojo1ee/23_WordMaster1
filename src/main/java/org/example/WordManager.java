package org.example;
import java.util.Scanner;


public class WordManager {

    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;

    public WordManager() {
        wordCRUD = new WordCRUD(s);
    }

    public void start(){
        wordCRUD.loadFile();
        welcome();
        selectMenu();
    }

    public void welcome(){
        System.out.println("*** 영단어 마스터 ***\n");
    }

    public void goodBye(){
        System.out.println("Program Shutting Down! See you again!\n");
    }

    public void showMenu(){

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
                goodBye();
                break;
            }
            else if (menu == 1) { // show all words
                wordCRUD.showAll();
            }
            else if (menu == 2) { // search words by level
                wordCRUD.searchLevel();
            }
            else if (menu == 3) { // search word
                wordCRUD.searchWord();
            }
            else if (menu == 4) { // add
                //System.out.println("#4");
                wordCRUD.addWordToList();
            }
            else if (menu == 5) { // update
                wordCRUD.updateItem();
            }
            else if (menu == 6) { // delete
                wordCRUD.deleteItem();
            }
            else if (menu == 7) { // save file
                wordCRUD.saveFile();
            }
        }
    }
}
