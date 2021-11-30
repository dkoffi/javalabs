package com.company;
/*
Сравнить производительность ArrayList и LinkedList
Необходимо написать код, который бы вызывал основные методы коллекций определенное(1000 или 2000,
или любое другое) количество раз.
При этом должно засекаться время.
Минимально необходимо протестировать методы:add, delete, get
После этого вывести таблицу с результатами(метод, сколько раз выполнялся, время выполнения)
@author Дарья Пухленко
 */
import java.util.ArrayList;
import java.util.LinkedList;
public class Main {

    public static void main(String[] args) {
        ArrayList<Object> list1 = new ArrayList<>();
        LinkedList<Object> list2 = new LinkedList<>();
        System.out.print("Method:           Count:        Time:\n");
        System.out.print("----------------------------------------\n");
        System.out.print("testAddArray       1500        ");
        System.out.print(testAddArray(list1));
        System.out.print("\n");
        System.out.print("testAddLinked      1500        ");
        System.out.print(testAddLinked(list2));
        System.out.print("\n");
        System.out.print("----------------------------------------\n");
        System.out.print("testGetArray       1500        ");
        System.out.print(testGetArray(list1));
        System.out.print("\n");
        System.out.print("testGetLinked      1500        ");
        System.out.print(testGetLinked(list2));
        System.out.print("\n");
        System.out.print("----------------------------------------\n");
        System.out.print("testDeleteArray    1500        ");
        System.out.print(testDeleteArray(list1));
        System.out.print("\n");
        System.out.print("testDeleteLinked   1500        ");
        System.out.print(testDeleteLinked(list2));
        System.out.print("\n");
        System.out.print("----------------------------------------\n");

    }
/*
@param count - количество раз
@param startTime - время
добавляем элементы много раз
 */
    private static long testAddArray(ArrayList<Object> list1) {
        int count = 1500;
        Object object = 10;
        long startTime = System.nanoTime();
        for (int i = 0; i < count; ++i) {
            list1.add(object);
        }
        return System.nanoTime() - startTime;
    }
    /*
    @param count - количество раз
    @param startTime - время
    добавляем элементы много раз
     */
    private static long testAddLinked(LinkedList<Object> list2) {
        int count = 1500;
        Object object = 20;
        long startTime = System.nanoTime();
        for (int i = 0; i < count; ++i) {
            list2.add(object);
        }
        return System.nanoTime() - startTime;
    }
    /*
    @param count - количество раз
    @param startTime - время
    удаляем элементы много раз
     */
    private static long testDeleteArray(ArrayList<Object> list1) {
        int count = 1500;
        Object object = 10;
        long startTime = System.nanoTime();
        for (int i = 0; i < count; ++i) {
            list1.remove(object);
        }
        return System.nanoTime() - startTime;
    }
    /*
    @param count - количество раз
    @param startTime - время
    удаляем элементы много раз
     */
    private static long testDeleteLinked(LinkedList<Object> list2) {
        int count = 1500;
        Object object = 20;
        long startTime = System.nanoTime();
        for (int i = 0; i < count; ++i) {
            list2.remove(object);
        }
        return System.nanoTime() - startTime;
    }
    /*
    @param count - количество раз
    @param startTime - время
    получаем элементы много раз
     */
    private static long testGetArray(ArrayList<Object> list1) {
        int count = 1500;
        Object object = 10;
        long startTime = System.nanoTime();
        for (int i = 0; i < count; ++i) {
            Object a = list1.get(0);
        }
        return System.nanoTime() - startTime;
    }
    /*
        @param count - количество раз
        @param startTime - время
        получаем элементы много раз
         */
    private static long testGetLinked(LinkedList<Object> list2) {
        int count = 1500;
        Object object = 20;
        long startTime = System.nanoTime();
        for (int i = 0; i < count; ++i) {
            Object b = list2.get(0);
        }
        return System.nanoTime() - startTime;
    }

}
