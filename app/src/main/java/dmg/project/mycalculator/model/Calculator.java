package dmg.project.mycalculator.model;

/**
 * Класс производит основные арифметические операции над числами.
 */
public class Calculator {

    private Calculator() {}

    public static Number addiction (double firstArgument, double secondArgument) {
        return firstArgument+secondArgument;
    }

    public static Number subtraction (double firstArgument, double secondArgument) {
        return firstArgument-secondArgument;
    }

    public static Number multiply (double firstArgument, double secondArgument) {
        return firstArgument*secondArgument;
    }

    public static Number division (double firstArgument, double secondArgument) {
        if (secondArgument == 0) throw new ArithmeticException("На 0 делить нельзя");
        return firstArgument/secondArgument;
    }
}
