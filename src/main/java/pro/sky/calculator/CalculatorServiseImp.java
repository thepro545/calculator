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

    public static String plus(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    public static String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    public static String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    public static String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        String result = "";
        if (num2 == 0) {
            return "Ошибка. На 0 делить нельзя.";
        } else {
            result = num1 + " / " + num2 + " = " + (num1 / num2);
        }
        return result;
    }
}
