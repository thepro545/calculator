package pro.sky.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator.Service.StringList;
import pro.sky.calculator.Service.StringListImp;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.calculator.StringListData.*;

public class StringListTest {

    StringList stringList = new StringListImp();

    @MethodSource("provideArgumentsForStringListTest")
    @ParameterizedTest
    public void testAdd(String item) {
        assertEquals(item, stringList.add(item));
        assertTrue(stringList.contains(item));
    }

    @Test
    public void testRemove() {
        setList();
        stringList.remove(ZERO);
        assertFalse(stringList.contains(ZERO));
    }

    @Test
    public void testSet() {
        setList();
        stringList.set(0, "Not Phone :D");
        assertTrue(stringList.contains("Not Phone :D"));
    }

    @Test
    public void testGet() {
        setList();
        assertEquals(2, stringList.indexOf(TWO));
    }

    @Test
    public void testIndexOf() {
        setList();
        assertEquals(3, stringList.indexOf(THREE));
    }

    @Test
    public void testSize() {
        setList();
        assertEquals(5, stringList.size());
    }

    @Test
    public void testIsEmpty() {
        stringList = new StringListImp();
        assertEquals(0, stringList.size());
    }

    @Test
    public void testClear() {
        setList();
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

    @MethodSource("provideArgumentsForStringListTest")
    @ParameterizedTest
    public void testToArray(String item, int index) {
        setList();
        String[] array = stringList.toArray();
        assertEquals(array[index], stringList.get(index));
    }


    private void setList() {
        stringList.add(ZERO);
        stringList.add(ONE);
        stringList.add(TWO);
        stringList.add(THREE);
        stringList.add(FOUR);
    }

    private static Stream<Arguments> provideArgumentsForStringListTest() {
        return Stream.of(
                Arguments.of(ZERO, 0),
                Arguments.of(ONE, 1),
                Arguments.of(TWO, 2),
                Arguments.of(THREE, 3),
                Arguments.of(FOUR, 4)
        );
    }
}
