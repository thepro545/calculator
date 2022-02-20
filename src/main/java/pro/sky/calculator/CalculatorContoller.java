package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorContoller {
    private final CalculatorServise calculatorServise;

    public CalculatorContoller(CalculatorServise calculatorServise) {
        this.calculatorServise = calculatorServise;
    }

    @GetMapping(path = "/calculator")
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/calculator/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return num1 + " + " + num2 + "=" + calculatorServise.plus(num1,num2);
    }
    @GetMapping(path = "/calculator/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return num1 + " - " + num2 + "=" + calculatorServise.minus(num1,num2);
    }
    @GetMapping(path = "/calculator/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return num1 + " * " + num2 + "=" + calculatorServise.multiply(num1,num2);
    }
    @GetMapping(path = "/calculator/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        if (num2 == 0) {
            return "Ошибка. На 0 делить нельзя.";
        } else {
            return num1 + " / " + num2 + " = " + calculatorServise.divide(num1,num2);
        }
    }
}
