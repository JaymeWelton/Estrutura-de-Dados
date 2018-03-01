/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        int[] array1; //1º array para armazenagem.
        int[] array2; //2º array para armazenagem.
        int[] arrayFinal = new int[100]; //Array final com o elementos que nao estao no 2º.
        int numero, elementos = 0; //variaveis de controle.
        boolean temNumero; //flag para saber se tem um numero no outro array.
        
        Scanner sc = new Scanner(System.in);
        
        array1 = new int[sc.nextInt()]; //Tamanho do 1º.
        
        for (int i = 0; i < array1.length; i++) {
            array1[i] = sc.nextInt(); //Popula o 1º array.
        }
        
        array2 = new int[sc.nextInt()]; //Tamanho do 2º.
        
        for (int i = 0; i < array2.length; i++) {
            array2[i] = sc.nextInt(); //Popula o 2º array.
        }
        
        for (int i = 0; i < array1.length; i++) { //for para percorrer array1.
            temNumero = false; //inicia a flag como falsa.
            numero = array1[i]; //pega o 1º elemento do array1 e armazena em numero.
            for (int j = 0; j < array2.length; j++) { //for para percorrer array2 em cada interaçao de array1.
                if (numero == array2[j]) { //testa se o numero de array esta em array2.
                    temNumero = true;
                }
            }
            if(!temNumero){ //caso um numero nao esteja em array2, ele adiciona dentro de arrayFinal.
                arrayFinal[elementos] = numero;
                elementos++; //incrementa o nº de elementos a cada interaçao.
            }
        }
        
        for (int i = 0; i < elementos; i++) {
            System.out.print(arrayFinal[i] + " "); //percorre e printa na tela os elementos na tela.
        }
    }
}
