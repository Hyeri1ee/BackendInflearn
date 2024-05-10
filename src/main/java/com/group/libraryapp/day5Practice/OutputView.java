package com.group.libraryapp.day5Practice;

public class OutputView {
    public static void insertNumber() {
        System.out.print("숫자를 입력하세요 : ");
    }

    public static void printResult(Integer key, Integer value) {
        System.out.println("%d 는 %d 번 나왔습니다.".formatted(key,value));
    }
}
