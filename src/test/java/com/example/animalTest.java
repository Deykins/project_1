package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class animalTest {

    private final String checkedAnimalKindFood; // текст, который передаётся в метод
    private final List<String> expected; // ожидаемый результат


    public animalTest(String checkedAnimalKindFood, List<String> expected) {
        this.checkedAnimalKindFood = checkedAnimalKindFood;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Unknown", List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник")}

        };
    }

    @Test
    public void shouldShowFood() {
        try {
            Animal animal = new Animal();
            List<String> actual = animal.getFood(checkedAnimalKindFood);
            assertEquals(expected, actual);
        }
        catch (Exception e) {
            assertEquals(expected, List.of(e.getMessage()));
        }
    }

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String actual = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", actual);
    }


}
