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
        private int conteudo;
        private No esquerda;
        private No direita;
        
        public No(int c){
            conteudo = c;
            esquerda = null;
            direita = null;
        }

        /**
         * @return the conteudo
         */
        public int getConteudo() {
            return conteudo;
        }

        /**
         * @param conteudo the conteudo to set
         */
        public void setConteudo(int conteudo) {
            this.conteudo = conteudo;
        }

        /**
         * @return the esquerda
         */
        public No getEsquerda() {
            return esquerda;
        }

        /**
         * @param esquerda the esquerda to set
         */
        public void setEsquerda(No esquerda) {
            this.esquerda = esquerda;
        }

        /**
         * @return the direita
         */
        public No getDireita() {
            return direita;
        }

        /**
         * @param direita the direita to set
         */
        public void setDireita(No direita) {
            this.direita = direita;
        }
    }
    
    static class Arvore{
        private int c;
        private No raiz;
        
        public Arvore(){
            c = 0;
            raiz = null;
        }
        
        public int getConteudo(){
            return c;
        }
        
        public void setConteudo(int c){
            this.c = c;
        }
        
        public No getRaiz(){
            return raiz;
        }
        
        public void setRaiz(int valor){
            this.raiz = new No(valor);
        }
        
        public void insert(int x, No n){
            c++;
            if (x < n.getConteudo()) {
                if (n.getEsquerda() == null) {
                    n.setEsquerda(new No(x));
                }else{
                    insert(x, n.getEsquerda());
                }
            }else if (x > n.getConteudo()) {
                if (n.getDireita() == null) {
                    n.setDireita(new No(x));
                }else{
                    insert(x, n.getDireita());
                }
            }
        }
    }
    
    public static void main(String[] args) throws java.lang.Exception{
        try {
            int testes;
            int[] valores;
            Arvore arvore = new Arvore();
            
            Scanner sc = new Scanner(System.in);
            
            testes = sc.nextInt();
            valores = new int[testes];
            arvore.setRaiz(sc.nextInt());
            valores[0] = arvore.getConteudo();
            
            for (int i = 1; i < testes; ++i) {
                arvore.insert(sc.nextInt(), arvore.getRaiz());
                valores[i] = arvore.getConteudo();
            }
            
            System.out.println(valores[0]);
            for (int i = 1; i < testes; ++i) {
                System.out.println(valores[i]);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
