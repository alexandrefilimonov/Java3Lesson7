package ru.geekbrains.Lesson7;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Array1and4AddTest {
    public final int ARRAY_COUNT = 4 ;
    /*@Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList( new Object[][]{
                { {1,1,4,1} , 1 },
                { {1,4,4,4} , 1 },
                { {4,4,4,4} , 1 },
                { {1,1,1,1} , 1 },
        });
    }*/
    private Array1and4 array1and4;

    @Before
    public void init() {
        array1and4 = new Array1and4(ARRAY_COUNT);
    }

    @Test
    public void Test1 () {
        System.out.println(Arrays.toString(array1and4.a));
        Assert.assertEquals(true, array1and4.exist1and4(ARRAY_COUNT));
    }
    @Test
    public void Test2 () {
        System.out.println(Arrays.toString(array1and4.a));
        Assert.assertEquals(true, array1and4.exist1and4(ARRAY_COUNT));
    }
}
