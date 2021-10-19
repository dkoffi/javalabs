package com.company;
import java.lang.*;
import java.util.*;


public class Main {
    public static void main(String[] args)

    {
        Container container = new Container();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = input.nextInt();
        /**
         * Создание массива и заполнение его элементами с клавиатуры
         */
        Object arr[] = new Object[size];
        System.out.println("Enter elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        /**
         * Вывод массива на экран
         */
        System.out.print ("Inserted array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print (" " + arr[i]);
        }
        System.out.println();

        /**
         * Создание массива numtoadd для добавления элементов в массив и вызов метода добавления
         */
        System.out.println("Enter the count of elements to add: ");
        int num = input.nextInt();
        Object numtoadd[] = new Object[num];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < num; i++) {
            numtoadd[i] = input.nextInt();
        }
            arr = container.add(size, arr, numtoadd, num);

        System.out.println("\nArray:\n" + Arrays.toString(arr));

        /**
         * Вызов метода удаления элемента из массива по индексу
         */
        System.out.println("Enter index to delete the element: ");
        int index = input.nextInt();
        arr = container.delete(size + num, arr, index);
        System.out.println("\nArray:\n" + Arrays.toString(arr));

        /**
         * Вызов метода извлечения элемента по индексу
         */
        System.out.println("Enter index to extract the element: ");
        index = input.nextInt();
        Object number = container.extract(size + num, arr, index);
        System.out.println("\nThe number is:\n"+ number);
    }
}
