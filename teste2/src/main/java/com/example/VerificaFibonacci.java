/*2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.

IMPORTANTE:
Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código; */

package com.example;

import java.util.Scanner;

public class VerificaFibonacci {

    public static boolean isFibonacci(int num) {
        if (num < 0) {
            throw new IllegalArgumentException(
                    "Número inválido. A sequência de Fibonacci clássica consiste apenas em números inteiros positivos. Informe um número não negativo. ");
        }

        int a = 0;
        int b = 1;
        int c = 0;
        System.out.print(a + " ");
        System.out.print(b + " ");
        ;
        while (c < num) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
        }
        System.out.println("");
        return c == num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe um número: ");
        int num = scanner.nextInt();

        try {
            boolean pertence = isFibonacci(num);

            if (pertence) {
                System.out.println(num + " pertence à sequência de Fibonacci.");
            } else {
                System.out.println(num + " não pertence à sequência de Fibonacci.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}