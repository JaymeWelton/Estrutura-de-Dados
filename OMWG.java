/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author jayme
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int contaPontos(int l, int c) {
        int[][] matriz = new int[l + 2][c + 2];
        int pontos = 0;
        for (int i = 1; i < l + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                int left = matriz[i][j - 1];
                int right = matriz[i][j + 1];
                int up = matriz[i + 1][j];
                int down = matriz[i - 1][j];
                matriz[i][j] = 1;
                pontos += left + right + up + down;
            }
        }
        return pontos;
    }
    
    public static void main(String[] args) throws IOException {
        try {
            int linha, coluna;
            Scanner sc = new Scanner(System.in);
            
            int testes = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < testes; i++) {
                String[] lc = sc.nextLine().split(" ");
                linha = Integer.parseInt(lc[0]);
                coluna = Integer.parseInt(lc[1]);
                System.out.println(contaPontos(linha, coluna));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}