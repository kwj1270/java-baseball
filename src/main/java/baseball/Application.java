package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author :    김우재
 * @version :   1.0 2020년 11월 25일
 * @apiNote :   야구게임 진행을 위한 메인 클래스로, 인스턴스 생성 및 메서드 호출로 이루어져 있습니다.
 */
public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행


        do {
            // 컴퓨터 숫자 구현
            Set<Integer> computerBalls = new LinkedHashSet<>();
            while (computerBalls.size() != 3) {
                computerBalls.add(RandomUtils.nextInt(1, 9));
            }
            computerBalls.stream().forEach(System.out::println);

            // 사용자 숫자 구현
            Set<Integer> userBalls = new LinkedHashSet<>();
            String numbers_string = scanner.nextLine();
            if(numbers_string.length() != 3) throw
                    new IllegalArgumentException("알맞은 값을 입력하지 않았습니다.");

            for(int i=0 ; i < 3; i++) {
                char number_char = numbers_string.charAt(i);
                if(!Character.isDigit(number_char)) throw
                        new IllegalArgumentException("알맞은 값을 입력하지 않았습니다.");
            }

            for(int i=0 ; i < 3; i++) {
                int number_int = Character.getNumericValue(numbers_string.charAt(i));
                if(number_int == 0) throw
                        new IllegalArgumentException("알맞은 값을 입력하지 않았습니다.");
            }

            for(int i=0 ; i < 3; i++) {
                int number_int = Character.getNumericValue(numbers_string.charAt(i));
                userBalls.add(number_int);
            }
            userBalls.stream().forEach(System.out::println);

        } while (false);

    }
}
