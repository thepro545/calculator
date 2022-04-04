package pro.sky.calculator.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ZeroDivideException extends IllegalArgumentException{

    public ZeroDivideException(){
        super("Нельзя делить на 0");
    }
}
