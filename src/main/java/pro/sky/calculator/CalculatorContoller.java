package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CalculatorContoller {
    private final CalculatorServise calculatorServise;

    public CalculatorContoller(CalculatorServise calculatorServise) {
        this.calculatorServise = calculatorServise;
    }

    @GetMapping(path = "/calculator")
    public String hello(){
        return calculatorServise.hello();
    }

    @GetMapping(path = "/calculator/plus")
    public static String plus(@RequestParam int num1, @RequestParam int num2){
        return CalculatorServiseImp.plus(num1,num2);
    }
    @GetMapping(path = "/calculator/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return CalculatorServiseImp.minus(num1,num2);
    }
    @GetMapping(path = "/calculator/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return CalculatorServiseImp.multiply(num1,num2);
    }
    @GetMapping(path = "/calculator/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return CalculatorServiseImp.divide(num1,num2);
    }
}
