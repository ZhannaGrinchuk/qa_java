package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;



@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean expected;


    public LionTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void shouldBeHasManOrNot() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Mock
    Feline feline;


    @Test
    public void returnKittensLion() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(lion.getKittens()).thenReturn(1);
        int expected = 1;
        assertEquals(expected, lion.getKittens());
    }

    @Test
    public void shouldHaveFoodOrNot() throws Exception {
        Lion lion = new Lion(sex, feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

}


