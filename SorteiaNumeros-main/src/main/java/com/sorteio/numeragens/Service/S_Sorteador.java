package com.sorteio.numeragens.Service;

import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;
import java.util.Random;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;

@Service
public class S_Sorteador {

    public static int[] geraNumeros(int min, int max, int quantidade,
                                            boolean checkedOrdenarN, boolean checkedRepetirN) {
        Random rand = new Random();
        int resultado;
        int[] numeros = new int[quantidade];

        for(int i = 0; i < quantidade; i++){
            boolean existeNoVetor = false;
            if(checkedRepetirN) {
                resultado = rand.nextInt(min,max+1);
            }else{
                do {
                    resultado = rand.nextInt(min,max+1);
                    int finalResultado = resultado;
                    existeNoVetor = Arrays.stream(numeros).anyMatch(numero -> numero == finalResultado);
                } while (existeNoVetor);
            }
            numeros[i] = resultado;
        }
        if (checkedOrdenarN) { //Ordenar numero
            Arrays.sort(numeros);
        }
        return numeros;
    }
}
