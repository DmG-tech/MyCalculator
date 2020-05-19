package dmg.project.mycalculator.controller;

import dmg.project.mycalculator.model.Calculator;
import dmg.project.mycalculator.ExpressionBuilder;

/**
 * Класс обработчик.
 * Обрабатывает и исполняет команды, связанные с кнопками "действия".
 */
public class CommandExecutor {
    private ExpressionBuilder expressionBuilder;
    private Operation currentOperation;
    private Number firstArgument;
    private Number secondArgument;

    public CommandExecutor(ExpressionBuilder expressionBuilder) {
        this.expressionBuilder = expressionBuilder;
    }

    public void executeCommand(Operation operation) {
        expressionBuilder.clearError();
        switch (operation) {
            case ADDITION:
            case MULTIPLY:
            case DIVISION:
                currentOperation = operation;
                if (expressionBuilder.getString() == null || expressionBuilder.getString().isEmpty())
                    return;
                firstArgument = Double.parseDouble(expressionBuilder.getString());
                expressionBuilder.clearExpression();
                break;
            case SUBTRACTION:
                if (expressionBuilder.getString().isEmpty())
                    expressionBuilder.updateExpression("-");
                else {
                    currentOperation = operation;
                    firstArgument = Double.parseDouble(expressionBuilder.getString());
                    expressionBuilder.clearExpression();
                }
                break;
            case DELETE:
                if (expressionBuilder.getString() == null || expressionBuilder.getString().isEmpty())
                    return;
                expressionBuilder.delChar();
                break;
            case EQUAL:
                if (currentOperation == Operation.EQUAL || expressionBuilder.getString() == null || expressionBuilder.getString().isEmpty())
                    return;
                secondArgument = Double.parseDouble(expressionBuilder.getString());
                expressionBuilder.clearExpression();
                try {
                    expressionBuilder.updateExpression(expressionBuilder.checkZero(executeArithmeticOperation()));
                } catch (ArithmeticException e) {
                    expressionBuilder.setString("");
                    expressionBuilder.printError(e.getMessage());
                }
                currentOperation = operation;
                break;
            case CLEAR:
                currentOperation = operation;
                expressionBuilder.clearExpression();
                break;
        }
    }

    private Number executeArithmeticOperation() throws ArithmeticException {
        Number result = 0;
        switch (currentOperation) {
            case ADDITION:
                result = Calculator.addiction((double) firstArgument, (double) secondArgument);
                break;
            case SUBTRACTION:
                result = Calculator.subtraction((double) firstArgument, (double) secondArgument);
                break;
            case DIVISION:
                result = Calculator.division((double) firstArgument, (double) secondArgument);
                break;
            case MULTIPLY:
                result = Calculator.multiply((double) firstArgument, (double) secondArgument);
                break;
        }
        return result;
    }
}
