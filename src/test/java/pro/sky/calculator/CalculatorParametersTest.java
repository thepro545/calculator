package pro.sky.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator.Service.CalculatorServiceImp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import static pro.sky.calculator.CalculatorTestData.*;

public class CalculatorParametersTest {

    private final CalculatorServiceImp out = new CalculatorServiceImp();

    @MethodSource("provideArgumentsForCalcTest")
    @ParameterizedTest
    public void checkResultFromPlus(int num1, int num2) {
        assertEquals(num1 + num2, out.plus(num1, num2));
    }

    @MethodSource("provideArgumentsForCalcTest")
    @ParameterizedTest
    public void checkResultFromMinus(int num1, int num2) {
        assertEquals(num1 - num2, out.minus(num1, num2));
    }

    @MethodSource("provideArgumentsForCalcTest")
    @ParameterizedTest
    public void checkResultFromMultiply(int num1, int num2) {
        assertEquals(num1 * num2, out.multiply(num1, num2));
    }

    @MethodSource("provideArgumentsForCalcTest")
    @ParameterizedTest
    public void checkResultFromDivide(int num1, int num2) {
        assertEquals(num1 / num2, out.divide(num1, num2));
    }

    private static Stream<Arguments> provideArgumentsForCalcTest() {
        return Stream.of(
                Arguments.of(ZERO, ONE),
                Arguments.of(ZERO, TWO),
                Arguments.of(ONE, TWO),
                Arguments.of(ONE, THREE),
                Arguments.of(TWO, TWO)
        );
    }
}
