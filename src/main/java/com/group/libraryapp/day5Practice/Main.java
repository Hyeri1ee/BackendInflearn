package com.group.libraryapp.day5Practice;

import java.util.Scanner;

public class Main {
    /*
     * 리팩토링 할 때 주의할 점
     * 1) 테스트 코드를 준비해야 합니다.
     *  -> 코드를 1만줄 정도 혼자 작성 해봐요! -> 코드를 개선해봐요 -> 수동으로 테스트를 해보세요!
     *  -> 2~3시간 정도 지나면 화가 납니다. -> 테스트 코드의 중요성을 깨닫게 됩니다.
     * 2) 테스트 코드를 작성할 수가 없는 구조라면
     *          테스트 코드를 작성할 수 있도록 준비부터 해야 합니다.
     *  -> 테스트를 작성하려고 노력하면, 좋은 코드가 나올 확률 높아짐
     *      랜덤?!?! : (힌트 - 스프링 컨테이너를 왜 사용 했었죠?)
     *
     */

    private static final int MAX_DICE_NUM = 6;

    public static void main(String[] args) {
        OutputView.insertNumber();
        Scanner scanner = new Scanner(System.in);
        int tryCount = scanner.nextInt();

        Dice dice = new Dice(MAX_DICE_NUM);
        DiceRollResults results = dice.roll(tryCount, new RandomNumberGenerator());

        results.getMap().sequencedEntrySet()
                .forEach(entry -> OutputView.printResult(entry.getKey(), entry.getValue()));
    }



}
