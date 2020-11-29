package baseball.domain;

import java.util.*;
import java.util.stream.Collectors;


public class User extends Player {
    private List<Integer> balls = new ArrayList<>();
    private final static int UNUSABLE_NUMBER = 0;
    private final static int ROOF_START_NUMBER = 0;
    private final static int START_NUMBER = 1;
    private final static int LIMIT_NUMBER = 3;
    private final static int END_NUMBER = 9;
    private final static Scanner scanner = new Scanner(System.in);

    public User() {
        this(init());
    }

    public User(List<Integer> balls) {
        this.balls = balls;
    }

    private static List<Integer> init() {
        try {
            return makeBalls();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static List<Integer> makeBalls() {
        return checkAndSetToList(stringToSet(checkStringSize(scanner.next())));
    }

    private static List<Integer> checkAndSetToList(Set<Integer> balls) {
        checkBallsSize(balls);
        checkBallsIncludeZero(balls);
        return setToList(balls);
    }

    private static void checkBallsSize(Set<Integer> balls) {
        if (balls.size() == LIMIT_NUMBER) return; // 중복값을 넣었으면 값이 줄어 들 것이다.
        throw new IllegalArgumentException("알맞은 값을 입력하지 않았습니다.");
    }

    private static void checkBallsIncludeZero(Set<Integer> balls) {
        if (!balls.contains(UNUSABLE_NUMBER)) return;
        throw new IllegalArgumentException("알맞은 값을 입력하지 않았습니다.");
    }

    private static Set<Integer> stringToSet(String numbers) {
        Set<Integer> balls = new LinkedHashSet<>();
        for (int i = ROOF_START_NUMBER; i < numbers.length(); i++) {
            balls.add(Character.getNumericValue(numbers.charAt(i)));
        }
        return balls;
    }

    private static String checkStringSize(String numbers) {
        if (numbers.length() == LIMIT_NUMBER) return numbers;
        throw new IllegalArgumentException("알맞은 값을 입력하지 않았습니다.");
    }

    private static List<Integer> setToList(Set<Integer> set) {
        return set.stream().collect(Collectors.toList());
    }

}
