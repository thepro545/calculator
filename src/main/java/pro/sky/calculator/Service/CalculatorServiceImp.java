package pro.sky.calculator.Service;

import org.springframework.stereotype.Service;
import pro.sky.calculator.Exceptions.ZeroDivideException;
import pro.sky.calculator.Service.CalculatorService;

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
        if (num2 == 0) {
            throw new ZeroDivideException();
        }
        return num1 / num2;
    }
}
