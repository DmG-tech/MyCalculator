package dmg.project.mycalculator.controller;

import dmg.project.mycalculator.R;

/**
 * Набор поддерживаемых операций.
 */
public enum Operation {
    ADDITION,
    SUBTRACTION,
    DIVISION,
    MULTIPLY,
    DELETE,
    EQUAL,
    CLEAR;

    public static Operation getOperation(int id) {
        switch (id) {
            case R.id.plus: return ADDITION;
            case R.id.minus: return SUBTRACTION;
            case R.id.division: return DIVISION;
            case R.id.multiply: return MULTIPLY;
            case R.id.delete: return DELETE;
            case R.id.equals: return EQUAL;
            case R.id.clear: return CLEAR;
            default: throw new IllegalArgumentException();
        }
    }
}
