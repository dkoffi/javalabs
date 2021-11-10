package com.company;

public class OperationSigns {
    OperationsSignsType type;
    String value;

    // тип и значение
    public OperationSigns(OperationsSignsType type, String value) {
        this.type = type;
        this.value = value;
    }

    public OperationSigns(OperationsSignsType type, Character value) {
        this.type = type;
        this.value = value.toString();
    }
    // переопределяем метод для перевода toString
    @Override
    public String toString() {
        return "OperationSigns{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
