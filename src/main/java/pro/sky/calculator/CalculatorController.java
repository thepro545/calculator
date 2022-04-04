package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return num1 + " + " + num2 + "=" + calculatorService.plus(num1,num2);
    }
    @GetMapping(path = "/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return num1 + " - " + num2 + "=" + calculatorService.minus(num1,num2);
    }
    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return num1 + " * " + num2 + "=" + calculatorService.multiply(num1,num2);
    }
    @GetMapping(path = "/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        if (num2 == 0) {
            return "Ошибка. На 0 делить нельзя.";
        } else {
            return num1 + " / " + num2 + " = " + calculatorService.divide(num1,num2);
        }
    }
}
