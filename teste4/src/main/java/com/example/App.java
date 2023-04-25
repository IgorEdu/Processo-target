/*4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:

SP – R$67.836,43
RJ – R$36.678,66
MG – R$29.229,88
ES – R$27.165,48
Outros – R$19.849,53

Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.*/

package com.example;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App {
        public static void main(String[] args) {
                Locale BRASIL = new Locale("pt", "BR");

                Double FATURAMENTO_SP = 67836.43,
                                FATURAMENTO_RJ = 36678.66,
                                FATURAMENTO_MG = 29229.88,
                                FATURAMENTO_ES = 27165.48,
                                FATURAMENTO_OUTROS = 19849.53;

                Double faturamentoTotal = (FATURAMENTO_SP + FATURAMENTO_RJ + FATURAMENTO_MG + FATURAMENTO_ES
                                + FATURAMENTO_OUTROS);

                NumberFormat percentualFormatado = NumberFormat.getPercentInstance(BRASIL);
                NumberFormat reaisFormatado = NumberFormat.getCurrencyInstance(BRASIL);

                percentualFormatado.setMinimumFractionDigits(2);
                percentualFormatado.setMaximumFractionDigits(2);

                System.out.println("Valor total faturado: " + reaisFormatado.format(faturamentoTotal));
                System.out.println(
                                "Valor faturado em SP: " + reaisFormatado.format((FATURAMENTO_SP))
                                                + " - Percentual de representação em SP: "
                                                + percentualFormatado.format(FATURAMENTO_SP / faturamentoTotal));
                System.out.println(
                                "Valor faturado em RJ: " + reaisFormatado.format((FATURAMENTO_RJ))
                                                + " - Percentual de representação em RJ: "
                                                + percentualFormatado.format(FATURAMENTO_RJ / faturamentoTotal));
                System.out.println(
                                "Valor faturado em MG: " + reaisFormatado.format((FATURAMENTO_MG))
                                                + " - Percentual de representação em MG: "
                                                + percentualFormatado.format(FATURAMENTO_SP / faturamentoTotal));
                System.out.println(
                                "Valor faturado em ES: " + reaisFormatado.format((FATURAMENTO_ES))
                                                + " - Percentual de representação em ES: "
                                                + percentualFormatado.format(FATURAMENTO_SP / faturamentoTotal));
                System.out.println(
                                "Valor faturado em Outros estados: " + reaisFormatado.format((FATURAMENTO_OUTROS))
                                                + " - Percentual de representação em Outros estados: "
                                                + percentualFormatado.format(FATURAMENTO_OUTROS / faturamentoTotal));

        }
}
