package baseball.domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Computer extends Player {
    private List<Integer> balls = new ArrayList<>();
    private final static int LIMIT_NUMBER = 3;
    private final static int START_NUMBER = 1;
    private final static int END_NUMBER = 9;

    public Computer(List<Integer> balls) {
        this.balls = balls;
    }

    public Computer() {
        this(init());
    }

    private static List<Integer> init() {
        try {
            return makeBalls();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static List<Integer> makeBalls() {
        return setToList(makeSetTypeBalls());
    }

    private static Set<Integer> makeSetTypeBalls() {
        Set<Integer> balls = new LinkedHashSet<>();
        while (balls.size() < LIMIT_NUMBER) {
            balls.add(RandomUtils.nextInt(START_NUMBER, END_NUMBER));
        }
        return balls;
    }

    private static List<Integer> setToList(Set<Integer> set) {
        return set.stream().collect(Collectors.toList());
    }

}
