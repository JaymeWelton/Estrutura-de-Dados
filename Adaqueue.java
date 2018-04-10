
package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

class Main{
    public static void main (String[] args) throws java.lang.Exception	{
	class No{
            private int conteudo;
            private No proximo;
            private No anterior;
            
            public void No(){
                setProximo(null);
            }

            public int getConteudo() {
                return conteudo;
            }

            public void setConteudo(int valor) {
                this.conteudo = valor;
            }

            public No getProximo() {
                return proximo;
            }

            public void setProximo(No proximo) {
                this.proximo = proximo;
            }

            public No getAnterior() {
                return anterior;
            }

            public void setAnterior(No anterior) {
                this.anterior = anterior;
            } 
        }
        
        class Fila{
            private No inicio;
            private No fim;
            private int nElementos;
            private boolean revertido = false;
            
            public Fila(){
                nElementos = 0;
                inicio = null;
                fim = null;
            }
            
            public boolean vazia(){
                return nElementos == 0;
            }
            
            public int back(){
                int conteudo;
                conteudo = fim.getConteudo();
                nElementos--;
                 
                if(revertido){
                    fim = fim.getProximo();
                    if (fim != null) {
                        fim.setAnterior(null);
                    }
                }else{
                    fim = fim.getAnterior();
                    if (fim != null) {
                        fim.setProximo(null);
                    }
                }
                return conteudo;
            }
            
            public int front(){
                int conteudo;
                conteudo = inicio.getConteudo();
                nElementos--;
                
                if(revertido){
                    inicio = inicio.getAnterior();
                    if (inicio != null) {
                        inicio.setProximo(null);
                    }
                }else{
                    inicio = inicio.getProximo();
                        if (inicio != null) {
                            inicio.setAnterior(null);
                        }
                    }
                return conteudo;
            }
            
            public void reverse(){
                No aux = inicio;
                inicio = fim;
                fim = aux;
                revertido = !revertido;
            }
            
            public void push_back(int valor){
                No novoNo = new No();
                novoNo.setConteudo(valor);
                if (vazia()) {
                    inicio = novoNo;
                    fim = novoNo;
                }else{
                    if(revertido){
                        novoNo.setProximo(fim);
                        fim.setAnterior(novoNo);
                    }else{
                        novoNo.setAnterior(fim);
                        fim.setProximo(novoNo);
                    }
                    fim = novoNo;
                }
                nElementos++;
            }
            
            public void toFront(int valor){
                No novoNo = new No();
                novoNo.setConteudo(valor);
                if (vazia()) {
                    inicio = novoNo;
                    fim = novoNo;
                }else{
                    if (revertido) {
                        novoNo.setAnterior(inicio);
                        inicio.setProximo(novoNo);
                    }else{
                        novoNo.setProximo(inicio);
                        inicio.setAnterior(novoNo);
                    }
                    inicio = novoNo;
                }
                nElementos++;
            }
        }
        
        int x;
        String string;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Fila fila = new Fila();
        x = Integer.parseInt(in.readLine());
        
        for (int i = 0; i < x; i++) {
            string = in.readLine();
            
            if (string == null) {
                break;
            }
            
            String[] partes = string.split(" ");
            if (partes[0].equals("back")) {
                if (fila.vazia()) {
                    System.out.println("No job for Ada?");
                }else{
                    System.out.println(fila.back());
                }
            }else if (partes[0].equals("front")) {
                if (fila.vazia()) {
                    System.out.println("No job for Ada?");
                }else{
                    System.out.println(fila.front());
                }
            }else if (partes[0].equals("reverse")) {
                fila.reverse();
            }else if (partes[0].equals("push_back")){
                fila.push_back(Integer.parseInt(partes[1]));
            }else if (partes[0].equals("toFront")) {
                fila.toFront(Integer.parseInt(partes[1]));
            }
        }
    }
}