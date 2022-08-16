package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionTest {



    private final String checkSex;
    private final boolean expected;

    public LionTest(String checkSex, boolean expected) {
        this.checkSex = checkSex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"unknown", false}



        };
    }

    @Test
    public void sexTest() {
        try {
            Lion lion = new Lion(checkSex);
            boolean actual = lion.hasMane;
            assertEquals(expected, actual);
        }
        catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

    @Mock
    Feline feline = new Feline();

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец");
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }



    @Test
    public void getFoodTest() throws Exception {

        Lion lion = new Lion("Самец");
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);

     }
}