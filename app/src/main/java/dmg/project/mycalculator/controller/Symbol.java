package dmg.project.mycalculator.controller;

import dmg.project.mycalculator.R;

/**
 * Вспомогательный класс с одним методом, который возвращает строковое представление введенного символа.
 */
public class Symbol {

    private Symbol(){}

    public static String getNumber(int id) {
        switch (id) {
            case R.id.zero: return "0";
            case R.id.one: return "1";
            case R.id.two: return "2";
            case R.id.three: return "3";
            case R.id.four: return "4";
            case R.id.five: return "5";
            case R.id.six: return "6";
            case R.id.seven: return "7";
            case R.id.eight: return "8";
            case R.id.nine: return "9";
            case R.id.point: return ".";
            default: throw new IllegalArgumentException();
        }
    }
}
