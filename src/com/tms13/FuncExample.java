package com.tms13;

import java.util.Scanner;

/**
 * 3. Создать обобщенный функциональный интерфейс.
 * Написать класс с одним методом (подумать и аргмументировать решение о том будет ли это статический методо или нет).
 * В этом методе реализуйте логику:
 * 	- если в консоль введена цифра 1, то:
 * 	использования интерфейса со строковым типом
 * 	и передать в метод интерфейса логику реверса строки(вывода строки в обратном порядке).
 * 	- если в консоль введена цифра 2, то:
 * 	использования интерфейса с целочисленным типом и передать в метод интерфейса логику нахождения факториала числа.
 */
public class FuncExample {

    public static void main(String[] args) {
        FuncInt<String> reverseString = str -> {
            return String.valueOf(new StringBuilder(str).reverse());
        };
        FuncInt<Integer> factorial = num -> {
            int factorialResult = 1;
            int i = 1;
            while (i <= num) {
                factorialResult = factorialResult * i;
                i++;
            }
            return factorialResult;
        };
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter to console 1 or 2: ");
        int value = scanner.nextInt();
        if (value == 1) operation(reverseString, "String");
        if (value == 2) operation(factorial, 5);
        scanner.close();
    }

    /**
     * Использую статику чтобы не создавать экземпляр класса для вызова метода
     * + в рамках этой задачи не нужно переопределять данный метод
     */
    private static <T> void operation(FuncInt function, T value) {
        System.out.println(function.getValue(value));
    }

}
