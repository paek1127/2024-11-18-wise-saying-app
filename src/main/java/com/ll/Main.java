package com.ll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {
    public void run() {
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);

        int lastId = 0;

        WiseSaying[] wiseSayings = new WiseSaying[3];
        int wiseSayingsSize = 0;

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                int id = ++lastId;

                WiseSaying wiseSaying = new WiseSaying(id, content, author);

                wiseSayings[wiseSayingsSize] = wiseSaying;
                wiseSayingsSize++;

//                System.out.println(Arrays.toString(wiseSayings));

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

//                try {
//                    System.out.println("%d / %s / %s".formatted(lastWiseSaying.id, lastWiseSaying.author, lastWiseSaying.content));
//                } catch (NullPointerException e) {
//                    System.out.println("등록된 명언이 없습니다.");
//                }

//                if (lastWiseSaying != null) {
//                    System.out.println("%d / %s / %s".formatted(lastWiseSaying.id, lastWiseSaying.author, lastWiseSaying.content));
//                } else {
//                    System.out.println("등록된 명언이 없습니다.");
//                }

//                for (int i = 0; i < wiseSayingsSize; i++) {
//                    WiseSaying wiseSaying = wiseSayings[i];
//                    System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
//                }
                for (WiseSaying wiseSaying : wiseSayings) {
                    if (wiseSaying == null) break;
                    System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
                }
            }
        }
        scanner.close();
    }
}

class WiseSaying {
    int id;
    String content;
    String author;

    WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "WiseSaying (id=%d, content=\"%s\", author=\"%s\")".formatted(id, content, author);
    }
}