package dmg.project.mycalculator;

import android.widget.TextView;

/**
 * Класс отвечает за форматирование и вывод результирующей строки на экран.
 */
public class ExpressionBuilder {
    private TextView textViewForExpression;
    private TextView textViewForError;
    private StringBuilder expression = new StringBuilder();

    private void updateTextView() {
        checkZero();
        textViewForExpression.setText(expression.toString());
    }

    public ExpressionBuilder(TextView ...textView) {
        this.textViewForExpression = textView[0];
        this.textViewForError = textView[1];
    }

    public String getString() {
        return expression.toString();
    }

    public void setString(String s) {
        if (s == null) return;
        expression = new StringBuilder(s);
        updateTextView();
    }

    public void updateExpression(String s) {
        if (s == null) return;
        expression.append(s);
        updateTextView();
    }

    public void updateExpression(Number i) {
        if (i == null) return;
        expression.append(i.toString());
        updateTextView();
    }

    public void clearExpression() {
        expression = new StringBuilder();
        updateTextView();
    }

    public void delChar() {
        if (expression.toString().isEmpty()) return;
        expression.deleteCharAt(expression.length() - 1);
        updateTextView();
    }

    public void printError(String message) {
        textViewForError.setText(message);
    }

    public void clearError() {
        textViewForError.setText("");
    }

    private void checkZero() {
        if (expression.toString().endsWith(".0")) {
            expression.delete(expression.indexOf("."), expression.length());
        }
    }
}
