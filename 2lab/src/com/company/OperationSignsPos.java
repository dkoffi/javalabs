package com.company;
import java.util.List;
public class OperationSignsPos {
    private int pos;

    public List<OperationSigns> operationsigns;

    public OperationSignsPos(List<OperationSigns> operationsigns) {
        this.operationsigns = operationsigns;
    }

    public OperationSigns next() {
        return operationsigns.get(pos++);
    }

    public void back() {
        pos--;
    }
    // получаем позицию
    public int getPos() {
        return pos;
    }
}
