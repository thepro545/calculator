package pro.sky.calculator;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import pro.sky.calculator.Exceptions.ZeroDivideException;
import pro.sky.calculator.Service.CalculatorServiceImp;
import static pro.sky.calculator.CalculatorTestData.*;

public class CalculatorTest {

    private final CalculatorServiceImp out = new CalculatorServiceImp();

    @Test
    public void checkPlusWith1and2(){
        assertEquals(THREE, out.plus(ONE, TWO));
    }
    @Test
    public void checkPlusWithZeroAnd2(){
        assertEquals(TWO, out.plus(ZERO, TWO));
    }
    @Test
    public void checkMinusWith3and2(){
        assertEquals(ONE, out.minus(THREE, TWO));
    }
    @Test
    public void checkMinusWith3And1(){
        assertEquals(TWO, out.minus(THREE, ONE));
    }
    @Test
    public void checkMultiplyWith1and2(){
        assertEquals(TWO, out.multiply(ONE, TWO));
    }
    @Test
    public void checkMultiplyWithZeroAnd1(){
        assertEquals(ZERO, out.multiply(ZERO, ONE));
    }
    @Test
    public void checkDivideWith3and1(){
        assertEquals(THREE, out.divide(THREE, ONE));
    }
    @Test
    public void checkDivideWith2And2(){
        assertEquals(ONE, out.divide(TWO, TWO));
    }
    @Test
    public void throwZeroDivideExceptionWithSecondNumZero(){
        assertThrows(ZeroDivideException.class, () -> out.divide(ONE, ZERO));
    }
}
