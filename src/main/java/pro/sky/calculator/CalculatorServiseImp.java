package pro.sky.calculator;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class CalculatorServiseImp implements CalculatorServise {

    @GetMapping(path = "/calculator")
    public String hello(){
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/calculator/plus")
    public static String plus(@RequestParam String num1, @RequestParam String num2){
//        String result ="";
        Integer s1 = Integer.valueOf(num1);
        Integer s2 = Integer.valueOf(num2);
        if (num1 == null || num2 == null) {
//            result = "Ошибка. Введите оба числа.";
            return "Ошибка. Введите оба числа.";
        } else {
            return  num1 + " + " + num2 + " = " + (s1+s2);
//        return "ID: " + num2.orElseGet(() -> "Error");
        }
//        return result;
    }

    @GetMapping(path = "/calculator/minus")
    public static String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        String result ="";
//        if (num1 != null || num2 != null) {
        result = num1 + " - " + num2 + " = " + (num1-num2);
//        } else {
//            System.out.println("Ошибка. Введите оба числа.");
//        }
        return result;
    }
    @GetMapping(path = "/calculator/multiply")
    public static String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        String result ="";
//        if (num1 != null || num2 != null) {
        return num1 + " * " + num2 + " = " + (num1*num2);
//        } else {
//            System.out.println("Ошибка. Введите оба числа.");
//        }
//        return result;
    }
    @GetMapping(path = "/calculator/divide")
    public static String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        String result = "";
        if (num2 == 0) {
            return "Ошибка. На 0 делить нельзя.";
        } else {
            result = num1 + " / " + num2 + " = " + (num1/num2);
        }
        return result;
    }
}
