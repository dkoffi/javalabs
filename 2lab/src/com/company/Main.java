package com.company;
/*
 Выражение может содержать числа, знаки операций, скобки.
 В случае, если вырожение записано корректно, вычислить значение, в противном случае - вывести сообщение об ошибке.
 * @author Дарья Пухленко
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression:\n");
        // ввод выражения
        String expression = scanner.nextLine();
        /*
        @param operationdigns - список, куда записываются знаки в зависимости от типа
         */
        List<OperationSigns> operationsigns = OperationSignsAnalyze(expression);
        OperationSignsPos operationsignspos = new OperationSignsPos(operationsigns);
        System.out.println(expr(operationsignspos));
    }
    /*
    @param pos - позиция
    @param c - знак операции в соответствии с типом
    пробел - исключение
     */
    public static List<OperationSigns> OperationSignsAnalyze(String expression) {
        ArrayList<OperationSigns> operationsigns = new ArrayList<>();
        int pos = 0;
        while (pos < expression.length()) {
            char c = expression.charAt(pos);
            switch (c) {
                case '(':
                    operationsigns.add(new OperationSigns(OperationsSignsType.L_B, c));
                    pos++;
                    continue;
                case ')':
                    operationsigns.add(new OperationSigns(OperationsSignsType.R_B, c));
                    pos++;
                    continue;
                case '+':
                    operationsigns.add(new OperationSigns(OperationsSignsType.PLUS, c));
                    pos++;
                    continue;
                case '-':
                    operationsigns.add(new OperationSigns(OperationsSignsType.MINUS, c));
                    pos++;
                    continue;
                case '*':
                    operationsigns.add(new OperationSigns(OperationsSignsType.MUL, c));
                    pos++;
                    continue;
                case '/':
                    operationsigns.add(new OperationSigns(OperationsSignsType.DIV, c));
                    pos++;
                    continue;
                default:
                    if (c <= '9' && c >= '0') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= expression.length()) {
                                break;
                            }
                            c = expression.charAt(pos);
                        } while (c <= '9' && c >= '0');
                        operationsigns.add(new OperationSigns(OperationsSignsType.NUMBER, sb.toString()));
                    } else {
                        if (c != ' ') {
                            throw new RuntimeException("Error");
                        }
                        pos++;
                    }
            }
        }
        operationsigns.add(new OperationSigns(OperationsSignsType.EOF, ""));
        return operationsigns;
    }
    /*
    если конец выражения, возвращаемся на позицию назад и вовзращаем значение plusminus
     */
    public static int expr(OperationSignsPos operationsigns) {
        OperationSigns operationsign = operationsigns.next();
        if (operationsign.type == OperationsSignsType.EOF) {
            return 0;
        } else {
            operationsigns.back();
            return plusminus(operationsigns);
        }
    }
    /*
    @param value - значение сложения либо вычитания
     */
    public static int plusminus(OperationSignsPos operationsigns) {
        int value = multdiv(operationsigns);
        while (true) {
            OperationSigns operationsign = operationsigns.next();
            switch (operationsign.type) {
                case PLUS:
                    value += multdiv(operationsigns);
                    break;
                case MINUS:
                    value -= multdiv(operationsigns);
                    break;
                case EOF:
                case R_B:
                    operationsigns.back();
                    return value;
                default:
                    throw new RuntimeException("Error");
            }
        }
    }
    /*
        @param value - значение умножения либо деления
         */
    public static int multdiv(OperationSignsPos operationsigns) {
        int value = brackets(operationsigns);
        while (true) {
            OperationSigns operationsign = operationsigns.next();
            switch (operationsign.type) {
                case MUL:
                    value *= brackets(operationsigns);
                    break;
                case DIV:
                    value /= brackets(operationsigns);
                    break;
                case EOF:
                case R_B:
                case PLUS:
                case MINUS:
                    operationsigns.back();
                    return value;
                default:
                    throw new RuntimeException("Error");
            }
        }
    }
    /*
    соответствие левой и правой скобки, если нет правой - ошибка
     */
     public static int brackets(OperationSignsPos operationsigns) {
        OperationSigns operationsign = operationsigns.next();
        switch (operationsign.type) {
            case NUMBER:
                return Integer.parseInt(operationsign.value);
            case L_B:
                int value = plusminus(operationsigns);
                operationsign = operationsigns.next();
                if (operationsign.type != OperationsSignsType.R_B) {
                    throw new RuntimeException("Error");
                }
                return value;
            default:
                throw new RuntimeException("Error");
        }
    }
}



