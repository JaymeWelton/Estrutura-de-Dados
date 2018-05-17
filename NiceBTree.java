/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.*;
import java.lang.*;

/**
 *
 * @author jayme
 */
import java.util.Scanner;

public class Main {
    public static class No {
        private int valor;
        private No esquerda;
        private No direita;
        
        public No(){
            esquerda = null;
            direita = null;
        }
        
        public int getValor() {
            return valor;
        }
        
        public void setValor(int valor) {
            this.valor = valor;
        }
        
        public No getEsquerda() {
            return esquerda;
        }
        
        public void setEsquerda(No esquerda) {
            this.esquerda = esquerda;
        }
        
        public No getDireita() {
            return direita;
        }
        
        public void setDireita(No direita) {
            this.direita = direita;
        }
    }
    
    static class Arvore{
        public String transversal;
        public int index;
        public No raiz;
        
        public Arvore(String transversal) {
            index = 0;
            this.transversal = transversal;
            
            No novoNo = new No();
            raiz = novoNo;
            raiz.setValor(transversal.charAt(index));
            
            if (raiz.getValor() == 'l') {
                raiz.setEsquerda(null);
                raiz.setDireita(null);
            }else {
                raiz.setEsquerda(addFilho(raiz, transversal.charAt(++index)));
                raiz.setDireita(addFilho(raiz, transversal.charAt(++index)));
            }
        }
        
        private No addFilho(No pai, char valor) {
            No aux = new No();
            
            if(valor == 'l') {
                aux.setDireita(null);
                aux.setEsquerda(null);
            }else if(valor == 'n') {
                aux.setDireita(addFilho(aux, transversal.charAt(++index)));
                aux.setEsquerda(addFilho(aux, transversal.charAt(++index)));
            }
            
            return aux;
        }
        
        public int getProfundidade() {
            return getProfundidade(raiz) - 1;
        }
        
        private int getProfundidade(No no) {
            if (no == null) {
                return 0;
            }
            
            int profundidadeD = getProfundidade(no.getDireita());
            int profundidadeE = getProfundidade(no.getEsquerda());
            
            if (profundidadeE > profundidadeD) {
                return ++profundidadeE;
            }else{
                return ++profundidadeD;
            }
        }
    }
    
    public static void main(String[] args) throws java.lang.Exception{
        try {
            Scanner in = new Scanner(System.in);
            int testes = in.nextInt();
            in.nextLine();
            String transversal;
            
            for (int i = 0; i < testes; i++) {
                transversal = in.nextLine();
                Arvore arvore = new Arvore(transversal);
                System.out.println(arvore.getProfundidade());
            }
            
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}