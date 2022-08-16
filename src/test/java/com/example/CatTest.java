package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {




    @Mock
    Predator predator;

    @Mock
    Feline feline;



    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals("Мяу", actual);

    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        List<String> actual = cat.getFood();
        List<String> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }



}
