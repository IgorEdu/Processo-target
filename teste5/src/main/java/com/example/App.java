/*5) Escreva um programa que inverta os caracteres de um string.

IMPORTANTE:
a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
b) Evite usar funções prontas, como, por exemplo, reverse; */

package com.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o que deseja inverter: ");
            String stringInicial = scanner.nextLine();

            String stringInvertida = inverterString(stringInicial);

            System.out.println("Palavra invertida: " + stringInvertida);
        }
    }

    public static String inverterString(String stringInicial) {
        char[] caracteres = stringInicial.toCharArray();

        int inicio = 0;
        int fim = caracteres.length - 1;

        while (inicio < fim) {
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;

            inicio++;
            fim--;
        }

        String stringInvetida = new String(caracteres);

        return stringInvetida;
    }
}
