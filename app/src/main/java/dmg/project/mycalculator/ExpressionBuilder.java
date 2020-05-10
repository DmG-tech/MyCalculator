package dmg.project.mycalculator;

import android.widget.TextView;

/**
 * Класс отвечает за форматирование и вывод результирующей строки на экран.
 */
public class ExpressionBuilder {
    private TextView textView;
    private StringBuilder expression = new StringBuilder();

    private void updateTextView() {
        textView.setText(expression.toString());
    }

    public ExpressionBuilder(TextView textView) {
        this.textView = textView;
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

    public void clear() {
        expression = new StringBuilder();
        updateTextView();
    }

    public void delChar() {
        if (expression.toString().isEmpty()) return;
        expression.deleteCharAt(expression.length() - 1);
        updateTextView();
    }
}
