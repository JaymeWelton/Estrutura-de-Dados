
package Main;

import java.util.*;
import java.lang.*;

public class Main {
    
    public static void main(String[] args) throws java.lang.Exception {
        class No{
            private String palavra;
            private No prox;
        
            public void No(){
                setProx(null);
            }

            public String getPalavra() {
                return palavra;
            }

            public void setPalavra(String palavra) {
                this.palavra = palavra;
            }

            public No getProx() {
                return prox;
            }

            public void setProx(No prox) {
                this.prox = prox;
            }
        }
        
        class Lista{
            private No cabeça;
            private int tamanho;
        
            public void Lista(){
                setCabeça(null);
                setTamanho(0);
            }

            public No getCabeça() {
                return cabeça;
            }

            public void setCabeça(No cabeça) {
                this.cabeça = cabeça;
            }

            public int getTamanho() {
                return tamanho;
            }

            public void setTamanho(int tamanho) {
                this.tamanho = tamanho;
            }
        
            public void insereNoComeço(String str){
                No novoNo = new No();
                novoNo.setPalavra(str);
                cabeça = novoNo;
                tamanho++;
            }
        
            public void insereNoFim(String str){
                No novoNo = new No();
                novoNo.setPalavra(str);
                No aux = cabeça;
                while (aux.getProx() != null) {
                    aux = aux.getProx();
                }
                aux.setProx(novoNo);
                tamanho++;
            }
        }
        
        Scanner sc = new Scanner(System.in);
        int a, b, contador = 0;
        
        /*Cria as listas encadeadas a serem comparadas.*/
        Lista começo1 = new Lista();
        Lista começo2 = new Lista();
        
        /*Le os valores dos tamanhos das duas listas.*/
        a = sc.nextInt();
        b = sc.nextInt();
        
        /*Preenche ambas as listas dependendo se a lista esta vazia ou nao, uma funçao eh chamada.*/
        for (int i = 0; i < a; i++) {
            if (começo1.getTamanho() == 0) {
                começo1.insereNoComeço(sc.next());
                        
            }else{
                começo1.insereNoFim(sc.next());
            }
        }
        
        for (int i = 0; i < b; i++) {
            if (começo2.getTamanho() == 0) {
                começo2.insereNoComeço(sc.next());
                        
            }else{
                começo2.insereNoFim(sc.next());
            }
        }
        
        /*Aponta para o começo de cada lista.*/
        No aux = começo1.getCabeça();
        No aux2 = começo2.getCabeça();
        
        /*Compara se ha um prefixo na 1ª lista encadeada.*/
        while (aux2 != null) {
            while (aux != null) {
                if (aux.getPalavra().startsWith(aux2.getPalavra())) {
                    contador++;//Incrementa caso haja um prefixo.
                }
                aux = aux.getProx();//Passa para a proxima palavra a ser analisada.
            }
            System.out.println(contador);
            aux2 = aux2.getProx();//Passa para a proxima palavra da 2ª lista a ser analisada.
            contador = 0;
            aux = começo1.getCabeça();//Retorna para o começo da 1ª lista.
        }
    }
}
