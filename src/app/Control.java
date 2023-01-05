package app;

import java.util.Scanner;

public class Control {

    private int guessNumber;

    private int intputNumber;

    Database database;

    public Control(Database database) {
        this.database = database;
    }



    public void playgame() {

        //1. 10~99까지의 숫자를 생성
        database.generateGuessNumber();
        guessNumber = database.getRandom();

        //2. 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);

        while (true) {
            while (true) {
                System.out.println("10~99사이의 숫자를 입력해 주세요");

                try {

                    intputNumber = Integer.parseInt(scanner.nextLine()); //nextInt는 버그가 많다.

                } catch (Exception E) {
                    System.out.println("숫자를 입력해주세요.");
                    continue;
                }
                break;
            }

            int diff = guessNumber - intputNumber;
            database.addToinputList(intputNumber);
            database.addToDiffList(Math.abs(intputNumber - guessNumber));
            //TODO

            //3. 입력한 수가 guessNumber보다 크면  up 작으면 down출력

            if (diff > 0) {
                System.out.println("제가 입력한 값이 입력값보다 큽니다.");
            } else if (diff < 0) {
                System.out.println("제가 입력한 값이 입력값보다 작습니다.");
            } else {
                System.out.println("맞췄습니다.");
                break;
            }
        }
        //4. 정답을 입력 할때까지 2.3번 반복
        //5. 정답 출력


        //6. 지금까지 입력한 숫자를 정답과의 오차와 함께 순서대로 출력
        System.out.println(database.getTrysave());
        System.out.println(database.getDiff());
    }
}




//2. 사용자 입력 받기


//7. 종료 및 메세지 출력
//랜덤 생성 메소드
//반복문
//스캔이프로 입력받기
