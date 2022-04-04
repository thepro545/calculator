package pro.sky.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImp implements CalculatorService {

    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
            return num1 / num2;
    }
}
