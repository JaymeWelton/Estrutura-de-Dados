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
    static class No{
        int valor;
        No direita;
        No esquerda;
        
        public No(int numero) {
            valor = numero;
            direita = null;
            esquerda = null;
        }
    }
    
    static class ArvoreBinaria{
        String pos = "";
        int index = 0, valor;
        
        private No setArvore(String[] inOrdem, String[] preOrdem, int inicio, int fim) {
            int inIndex;
            
            if (inicio > fim){
                return null;
            }
            
            valor = Integer.parseInt(preOrdem[index++]);
            No novoNo = new No(valor);
            
            if (inicio == fim){
                return novoNo;
            }
            
            inIndex = busca(inOrdem, inicio, fim, novoNo.valor);
            
            novoNo.esquerda = setArvore(inOrdem, preOrdem, inicio, inIndex - 1);
            novoNo.direita = setArvore(inOrdem, preOrdem, inIndex + 1, fim);
            
            return novoNo;
        }
        
        private int busca(String[] string, int começo, int fim, int numero) {
            int aux, valor;
            
            for (aux = começo; aux <= fim; aux++) {
                valor = Integer.parseInt(string[aux]);
                if (valor == numero){
                    return aux;
                }
            }
            return aux;
        }
        private void posOrdemArvore(No no) {
            if (no == null){
                return;
            }
            
            posOrdemArvore(no.esquerda);
            
            posOrdemArvore(no.direita);
            
            pos += no.valor + " ";
        }
        
        private String duplicaArvore() {
            return pos;
        }
    }
    
    public static void main(String[] args) throws java.lang.Exception{
        try {
            int tamanho;
            No raiz;
            String pre, pos, inOrd, arvorePos, string;
            String[] preOrdem;
            String[] inOrdem;
            
            ArvoreBinaria arvore = new ArvoreBinaria();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            
            tamanho = Integer.parseInt(in.readLine());
            
            pre = in.readLine();
            preOrdem = pre.split(" ");
            
            pos = in.readLine();
            
            inOrd = in.readLine();
            inOrdem = inOrd.split(" ");
            
            raiz = arvore.setArvore(inOrdem, preOrdem, 0, tamanho - 1);
            
            arvore.posOrdemArvore(raiz);
            
            arvorePos = arvore.duplicaArvore();
            
            string = arvorePos.substring(0, arvorePos.length() - 1);
            
            if(pos.equals(string)) {
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}