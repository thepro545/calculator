package pro.sky.calculator.Exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Not Found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
