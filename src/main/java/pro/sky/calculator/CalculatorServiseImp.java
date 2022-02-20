package pro.sky.calculator;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class CalculatorServiseImp implements CalculatorServise {

    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    public static String plus(int num1, int num2) {
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    public static String minus(int num1, int num2) {
        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    public static String multiply(int num1, int num2) {
        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    public static String divide(int num1, int num2) {
        String result = "";
        if (num2 == 0) {
            return "Ошибка. На 0 делить нельзя.";
        } else {
            result = num1 + " / " + num2 + " = " + (num1 / num2);
        }
        return result;
    }
}
