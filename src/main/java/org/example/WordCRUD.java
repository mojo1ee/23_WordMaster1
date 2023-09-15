package org.example;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class WordCRUD implements ICRUD{
    Scanner s;
    ArrayList<Word> list;
    final String file = "dictionary.txt";
    public WordCRUD(Scanner s) {
        this.s = s;
        list = new ArrayList<>();
    }

    public void loadFile(){

        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while(true){
                line = br.readLine();
                if(line == null) break;
                String [] data = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                list.add(new Word(0, level, word, meaning));
                count++;
            }
            br.close();
            System.out.println("=> "+ count +" 개 단어 로딩 완료!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력: ");
        int level = s.nextInt();
        String word = s.nextLine();
        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();
        //meaning.trim();

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

    public ArrayList showAll(String keyword){

        ArrayList<Integer> searchList = new ArrayList<>();

        for(int i = 0; i < 32; i++){System.out.print("-");}
        System.out.println();

        int count = 0;
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).toString().contains(keyword)) {
                System.out.println(count + 1 + " " + list.get(i).toString());
                searchList.add(i);
                count++;
            }
        }

        if(list.size() == 0) System.out.println("등록된 단어가 없습니다");
        if(count == 0) System.out.println("검색된 단어가 없습니다");
        //else System.out.println(list.size());

        for(int i = 0; i < 32; i++){System.out.print("-");}
        System.out.println("\n");

        return searchList;
    }

    public void updateItem() {
        System.out.print("수정할 단어 검색 : ");
        String keyword = s.next(); // accept keywords w/o spaces in between
        ArrayList<Integer> updateList = showAll(keyword);
        System.out.print("수정할 번호 선택 : ");
        int ans = s.nextInt();
        Word word = list.get((int)updateList.get(ans - 1)); // need to do ans -1 b.c of index starts from 0
        s.nextLine(); // get rid of linefeed in buffer

        System.out.print("뜻 입력 : ");
        String meaning  =  s.nextLine();
        word.setMeaning(meaning);
        System.out.println("단어가 수정되었습니다.");
    }

    public void deleteItem() {
        System.out.print("삭제할 단어 검색 : ");
        String keyword = s.next(); // accept keywords w/o spaces in between
        ArrayList<Integer> deleteList = showAll(keyword);
        System.out.print("삭제할 번호 선택 : ");
        int ans = s.nextInt();
        Word word = list.get((int)deleteList.get(ans - 1)); // need to do ans -1 b.c of index starts from 0
        s.nextLine(); // get rid of linefeed in buffer

        System.out.print("정말로 삭제하실래요?(Y/n): ");
        String yesOrNo  =  s.next();
        if(yesOrNo.equalsIgnoreCase("y")){
            list.remove((int)deleteList.get(ans - 1));
            System.out.println("단어가 삭제되었습니다.");
            return;
        }
        System.out.println("삭제가 취소되었습니다.");
    }

    public void saveFile() {
        PrintWriter pr = null;
        try {
            pr = new PrintWriter(new FileWriter("test.txt"));
            for(Word one: list){
                pr.write(one.toFileString()+ "\n");
            }
            pr.close();
            System.out.println("==> 데이터 저장 완료 !!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
