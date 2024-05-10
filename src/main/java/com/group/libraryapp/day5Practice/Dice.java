package com.group.libraryapp.day5Practice;

public class Dice {

    private final int maxDiceNumber;
    private final DiceRollResults results;

    public Dice(int maxDiceNumber) {
        this.maxDiceNumber = maxDiceNumber;
        this.results = new DiceRollResults(maxDiceNumber);
    }

    public DiceRollResults roll(int tryCount, NumberGenerator generator) {
        for (int i = 0; i < tryCount; i++) {
            int rollResult = generator.generate(maxDiceNumber);
            results.count(rollResult);
        }
        return results;
    }

}
