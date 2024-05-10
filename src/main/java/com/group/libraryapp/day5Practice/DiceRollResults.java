package com.group.libraryapp.day5Practice;

import java.util.LinkedHashMap;
import java.util.SequencedMap;


public class DiceRollResults {
    private final SequencedMap<Integer, Integer> map = new LinkedHashMap<>();

    public DiceRollResults(int maxDiceNumber) {
        for (int i = 1; i <= maxDiceNumber; i++) {
            map.put(i, 0);
        }
    }

    public void count(int rollResult) {
        int updated = map.get(rollResult) + 1;
        map.replace(rollResult, updated);
    }

    public SequencedMap<Integer, Integer> getMap() {
        return map;
    }
}
