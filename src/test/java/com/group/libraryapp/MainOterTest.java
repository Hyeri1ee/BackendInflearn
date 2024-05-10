package com.group.libraryapp;

import com.group.libraryapp.day5Practice.Main;
import com.group.libraryapp.day5Practice.NumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainOterTest {
    static class MyNumberGenerator implements NumberGenerator{
        private int i = 0;
        private List<Integer> nums = List.of(0,1,2,3,4,5);
        @Override
        public int generate(){
            return nums.get(i);
        }
    }
    @Test
    public void subTest(){
        //given
        NumberGenerator generator = new MyNumberGenerator();
        //when
        String result = Main.rollDice(5,generator);

        //then
        assertThat(result).isEqualTo(
                ""
        );

    }
}
