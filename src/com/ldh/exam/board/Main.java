package com.ldh.exam.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static void makeTestData(List<Article> articles){
        articles.add(new Article(1,"제목1","내용1"));
        articles.add(new Article(2,"제목2","내용2"));
        articles.add(new Article(3,"제목3","내용3"));

    }
    public static void main(String[] args) {
        int articleLastId =0;

        List<Article>articles = new ArrayList<>();


        makeTestData(articles);
        if(articles.size() > 0){
            articleLastId = articles.get(articles.size()-1).id;
        }

        System.out.println("== 게시판 v 0.1 ==");
        System.out.println("== 프로그램 시작 ==");
        while (true){
            System.out.print("명령)");
            Scanner input = new Scanner(System.in);
            String cmd = input.nextLine().trim();
            System.out.println("입력받은 명령어 : "+ cmd);
            if(cmd.equals("exit")){
                System.out.println("== 프로그램 종료 ==");
                break;
            }
            else if (cmd.equals("/usr/article/list")){

                System.out.println(" == 게시물 리스트 ==");
                System.out.println("-------------------");
                System.out.println("번호 / 제목 / 내용");

                for(int i= articles.size()-1;i>=0;i--){
                    Article article = articles.get(i);
                    System.out.printf("%d / %s / %s\n",article.id,article.title,article.body);
                }
                System.out.println("----------------");

            }
            else if (cmd.equals("/usr/article/write")){

                    System.out.println("== 게시물 등록 ==");
                    System.out.print("제목 : ");
                    String title = input.nextLine().trim();
                    System.out.print("내용 : ");
                    String body = input.nextLine().trim();
                    int id = articleLastId + 1;
                articleLastId = id;
                    Article article = new Article(articleLastId, title, body);


                    articles.add(article);

                    System.out.println("생성된 게시물 객체 :"+article);
                    System.out.printf("%d번 게시물이 등록되었습니다.\n", articleLastId);
                }

                else if(cmd.equals("/usr/article/detail")){
                    if(articles.isEmpty()){
                        System.out.println("게시물이 존재하지 않습니다.");
                        continue;}

                    Article article = articles.get(articles.size()-1);

                    System.out.println("-게시물 상세보기-  \n"+ article);
                    System.out.printf("%d 번째 게시물이 입력 되었습니다.\n",article.id);




                }
            }
        }
    }


class Article{
    int id;
    String title;
    String body;

    public Article(int lastId, String title, String body) {
        this.id =lastId;
        this.title = title;
        this.body = body;

    }
    @Override
    public String toString(){
        return String.format(" 번호 : %d\n 제목 : %s\n 내용 : %s\n",id,title,body);
    }

}