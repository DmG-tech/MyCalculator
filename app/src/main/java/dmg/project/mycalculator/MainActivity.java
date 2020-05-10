package dmg.project.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import dmg.project.mycalculator.controller.CommandExecutor;
import dmg.project.mycalculator.controller.Operation;
import dmg.project.mycalculator.controller.Symbol;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Button> numButtons = new ArrayList<>();
    private ArrayList<Button> actionButtons = new ArrayList<>();
    private ExpressionBuilder expressionBuilder;
    private CommandExecutor commandExecutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeButtons();
        expressionBuilder = new ExpressionBuilder(findViewById(R.id.expression));
        commandExecutor = new CommandExecutor(expressionBuilder);

        View.OnClickListener numButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expressionBuilder.updateExpression(Symbol.getNumber(v.getId()));
            }
        };

        View.OnClickListener actionButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commandExecutor.executeCommand(Operation.getOperation(v.getId()));
            }
        };

        numButtons.forEach( numButton -> numButton.setOnClickListener(numButtonListener));
        actionButtons.forEach( actionButton -> actionButton.setOnClickListener(actionButtonListener));
    }

    private void initializeButtons() {
            numButtons.add(findViewById(R.id.zero));
            numButtons.add(findViewById(R.id.one));
            numButtons.add(findViewById(R.id.two));
            numButtons.add(findViewById(R.id.three));
            numButtons.add(findViewById(R.id.four));
            numButtons.add(findViewById(R.id.five));
            numButtons.add(findViewById(R.id.six));
            numButtons.add(findViewById(R.id.seven));
            numButtons.add(findViewById(R.id.eight));
            numButtons.add(findViewById(R.id.nine));
            numButtons.add(findViewById(R.id.point));

            actionButtons.add(findViewById(R.id.plus));
            actionButtons.add(findViewById(R.id.minus));
            actionButtons.add(findViewById(R.id.equals));
            actionButtons.add(findViewById(R.id.division));
            actionButtons.add(findViewById(R.id.multiply));
            actionButtons.add(findViewById(R.id.delete));
            actionButtons.add(findViewById(R.id.clear));
    }
}
