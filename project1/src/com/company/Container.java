package com.company;

/**
 * Класс контейнер
 * @author Дарья Пухленко
 */
public class Container {
    /**
     * Метод, позволяющий добавлять элементы в массив
     * @param n - размер исходного массива
     * @param arr - исходный массив
     * @param numtoadd - массив чисел, которые нужно добавить в массив
     * @param x - размер массива numtoadd
     * @return новый массив
     */
    public static Object[] add(int n, Object arr[], Object numtoadd[], int x)
    {
        int i;
        Object newarr[] = new Object[n + x];
        for (int j = 0; j < x; j++) {
            for (i = 0; i < n; i++)
                newarr[i] = arr[i];
            newarr[n + j] = numtoadd[j];
        }
        return newarr;
    }

    /**
     * Метод удаления элемента из массива по индексу
     * @param n - размер исходного массива
     * @param arr - исходный массив
     * @param x - индекс элемента, который нужно удалить
     * @return новый массив
     */
    public static Object[] delete(int n, Object arr[], int x)
    {
        int i;
        Object newarr[] = new Object[n - 1];
        for (i = 0; i < x; i++) {
              newarr[i] = arr[i];
    }
        for (i = x; i < n - 1; i++) {
            newarr[i] = arr[i+1];
        }
        return newarr;
    }

    /**
     * Метод, извлекающий элемент из массива по индексу
     * @param n - размер массива
     * @param arr - массив
     * @param x - индекс извлекаемого элемента
     * @return значение элемента
     */
    public static Object extract(int n, Object arr[], int x)
    {
        Object number = arr[x];
        return number;
    }
}
