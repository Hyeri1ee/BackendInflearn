package com.group.libraryapp.day5Practice;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private final Random random = new Random();
    @Override
    public int generate(int n){
        return random.nextInt(n); // 0~n-1
    }
}
