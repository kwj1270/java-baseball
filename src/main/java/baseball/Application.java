package baseball;

import utils.RandomUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author :    김우재
 * @version :   1.0 2020년 11월 25일
 * @apiNote :   야구게임 진행을 위한 메인 클래스로, 인스턴스 생성 및 메서드 호출로 이루어져 있습니다.
 */
public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        while (true){
            boolean flag = true;
            do {
                // 컴퓨터 숫자 구현
                Set<Integer> computerBalls = new LinkedHashSet<>();
                while (computerBalls.size() != 3) {
                    computerBalls.add(RandomUtils.nextInt(1, 9));
                }
                computerBalls.stream().forEach(System.out::println);

                // 사용자 숫자 구현
                Set<Integer> userBalls = new LinkedHashSet<>();
                String numbers_string = scanner.next();
                if (numbers_string.length() != 3) throw
                        new IllegalArgumentException("알맞은 값을 입력하지 않았습니다.");

                for (int i = 0; i < 3; i++) {
                    char number_char = numbers_string.charAt(i);
                    if (!Character.isDigit(number_char)) throw
                            new IllegalArgumentException("알맞은 값을 입력하지 않았습니다.");
                }

                for (int i = 0; i < 3; i++) {
                    int number_int = Character.getNumericValue(numbers_string.charAt(i));
                    if (number_int == 0) throw
                            new IllegalArgumentException("알맞은 값을 입력하지 않았습니다.");
                }

                for (int i = 0; i < 3; i++) {
                    int number_int = Character.getNumericValue(numbers_string.charAt(i));
                    userBalls.add(number_int);
                }
                userBalls.stream().forEach(System.out::println);

                List<Integer> computerArray = computerBalls.stream().collect(Collectors.toList());
                List<Integer> userArray = userBalls.stream().collect(Collectors.toList());

                computerArray.stream().forEach(System.out::println);
                userArray.stream().forEach(System.out::println);

                int strikeCount = 0;
                int ballCount = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (computerArray.get(i) == userArray.get(j)) {
                            if (i == j) strikeCount++;
                            else ballCount++;
                        }
                    }
                }
                if (ballCount > 0) {
                    System.out.println(ballCount + "볼 ");
                }
                if (strikeCount > 0) {
                    System.out.println(strikeCount + "스트라이크 ");
                }
                if (ballCount == 0 && strikeCount == 0) {
                    System.out.println("낫싱");
                }
                if (strikeCount == 3) {
                    System.out.println(strikeCount+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    flag = false;
                }
            } while (flag);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            int command = scanner.nextInt();
            if(command == 1) continue;
            if(command == 2) break;
            throw new IllegalArgumentException("알맞은 값을 입력하지 않았습니다.");
        }
    }
}
