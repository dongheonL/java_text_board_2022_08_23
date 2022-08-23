package com.ldh.exam.board;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
int articleLastid = 0;

        System.out.println(" == 게시판 v 0.1 ==");
        System.out.println(" == 프로그램 시작 ==");

        while(true){
            System.out.printf("명령)");
            String cmd =input.nextLine();


            if(cmd.equals("exit")){
                break;
            }
            else if(cmd.equals("usr/article/write")) {
                System.out.println("== 게시물 등록 ==");
                System.out.printf("제목 :");
                String title = input.nextLine().trim();
                System.out.printf("내용 :");
                String body = input.nextLine().trim();
                int id = articleLastid + 1;
                articleLastid = id;
                System.out.printf("%d번 게시물이 입력 되었습니다.\n",id);



            }
            else{
                System.out.printf("입력 된 명령어 : %s\n",cmd);
            }


        }
        System.out.println(" == 프로그램 종료 ==");
        input.close();



    }
}
