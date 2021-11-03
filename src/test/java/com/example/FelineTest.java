package com.example;


import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class FelineTest {

    @Test
    public void shouldBeFamilyOrNot() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();

        assertEquals(expectedFamily, actualFamily);

    }

    @Test(expected = Exception.class)
    public void returnFelinessKittens() {
        Feline feline = new Feline();
        when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        assertEquals(expected, feline.getKittens());
    }


   @Test
    public void returnFoodForPredatorOrNot() throws Exception {

        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }


}



