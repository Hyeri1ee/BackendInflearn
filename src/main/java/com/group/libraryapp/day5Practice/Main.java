package com.group.libraryapp.day5Practice;

import java.util.Scanner;

class Dice{

    private int diceNum;
    private int rollNum;
    private int[] list;

    public Dice(int diceNum,int rollNum) {

        //초기화
        this.list = new int[diceNum];
        this.diceNum = diceNum;
        this.rollNum = rollNum;
        for (int i = 0 ; i < diceNum; i++)
            list[i] = 0;

        for (int i = 0 ; i < rollNum; i++){
            int randomNum = (int) (Math.random() * diceNum);
            list[randomNum]++;
        }
    }

    public int getDiceNum() {
        return diceNum;
    }

    public int getRollNum() {
        return rollNum;
    }

    public int[] getList() {
        return list;
    }
}

public class Main {
    private static int diceNumber,rollDiceNumber;

    public static void main(String[] args) throws Exception {

        printFrist();

        Dice dice =  new Dice(diceNumber,rollDiceNumber);

        printResult(dice.getList());
    }

    private static void printResult(int[] diceList) {
        for (int i = 0; i < diceNumber; i++) {
            System.out.printf("%d는 %d번 나왔습니다.\n", i + 1, diceList[i]);
        }
    }

    private static void printFrist(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("던지는 횟수를 입력하세요 : ");
        rollDiceNumber = scanner.nextInt();
        System.out.print("주사위 눈 수를 입력하세요 : ");
        diceNumber = scanner.nextInt();
    }


}
