/*3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média; */

package com.example;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.OptionalDouble;

public class App {

    public static void main(String[] args) throws IOException, ParseException {
        // Caminho do arquivo JSON
        String caminhoArquivo = System.getProperty("user.dir") + "/teste3/data/dados.json";
        int diasSuperiorMedia = 0;
        NumberFormat formatoReal = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        Object jsonObject = new JSONParser().parse(new FileReader(caminhoArquivo));
        JSONArray mesFaturamento = (JSONArray) jsonObject;

        List<Double> listFaturados = new ArrayList<>();

        for (Object tempObject : mesFaturamento) {
            JSONObject faturamento = (JSONObject) tempObject;
            Double valor = (Double) faturamento.get("valor");
            if (valor > 0) {
                listFaturados.add(valor);
            }
        }

        OptionalDouble mediaFaturamento = listFaturados.stream().mapToDouble(Double::doubleValue).average();
        double menorValor = listFaturados.stream().mapToDouble(Double::doubleValue).min().orElse(0);
        double maiorValor = listFaturados.stream().mapToDouble(Double::doubleValue).max().orElse(0);

        for (double valor : listFaturados) {
            if (valor > mediaFaturamento.getAsDouble()) {
                diasSuperiorMedia++;
            }
        }

        System.out.println("O menor valor de faturamento ocorrido no mês foi de: " + formatoReal.format(menorValor));

        System.out.println("O maior valor de faturamento ocorrido no mês foi de: " + formatoReal.format(maiorValor));

        System.out.println(
                "A quantidade de dias que tiveram o faturamento superior à média mensal ("
                        + formatoReal.format(mediaFaturamento.getAsDouble())
                        + ") foi de: " + diasSuperiorMedia + " dias");

    }
}