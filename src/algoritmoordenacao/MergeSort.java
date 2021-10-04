package algoritmoordenacao;

import criararquivoarray.CriarArquivoArray;

public class MergeSort {


    public static void main(String[] args) {

        int[] lista = CriarArquivoArray.lerArquivo("C:\\Users\\debba\\Desktop\\arrayAleatorio.json");
        
        System.out.println("Merge Sort: ");
        
        // CASO MEDIO
        long tempo_inicial = System.currentTimeMillis();

        crescente(lista);
        
        long tempo_final = System.currentTimeMillis();

        long casoMedio = (tempo_final - tempo_inicial);
        
        
        //MELHOR CASO
        
        tempo_inicial = System.currentTimeMillis();
        
        crescente(lista);
        
        tempo_final = System.currentTimeMillis();
        
        long melhorCaso = (tempo_final - tempo_inicial);
        
        //PIOR CASO
        
        decrescente(lista);
        
        tempo_inicial = System.currentTimeMillis();

        
        crescente(lista);
        
        tempo_final = System.currentTimeMillis();
        
        long piorCaso = (tempo_final - tempo_inicial);


        System.out.printf("Caso medio: %d ms%n", casoMedio);

        System.out.printf("Melhor caso: %d ms%n", melhorCaso);
        
        System.out.printf("Pior caso: %d ms%n", piorCaso);

        
    }
    
    public static void crescente(int[] lista){
        int tamanho = lista.length;
        int elementos = 1;
        int inicio, meio, fim;
        
        
        while (elementos < tamanho){
            
            inicio = 0;
            
            while(inicio + elementos < tamanho) {
                
                meio = inicio + elementos;
                
                fim = inicio + 2 * elementos;
                
                if(fim > tamanho) fim = tamanho;
                
                intercalarCrescente(lista, inicio, meio, fim);
                
                inicio = fim;
            }
            
            elementos *= 2;  
        }
    }
    
    private static void intercalarCrescente(int[] lista, int inicio, int meio, int fim) {
        int novoVetor[] = new int[fim - inicio];
        int i = inicio;
        int m = meio;
        int pos = 0;
        
        while(i < meio && m < fim) {
            
            if(lista[i] <= lista[m]) {
                novoVetor[pos] = lista[i];
                pos++;
                i++;
            }else {
                novoVetor[pos] = lista[m];
                pos = pos + 1;
                m = m + 1;
            }
            
        }
        
        while(i < meio) {
            novoVetor[pos] = lista[i];
            pos++;
            i++;
        }
        
        while(m < fim) {
            novoVetor[pos] = lista[m];
            pos++;
            m++;
        }
        
        for(pos = 0, i = inicio; i < fim; i++, pos++) {
            lista[i] = novoVetor[pos];
        }
        
    }
    
    public static void decrescente(int[] lista){
        int tamanho = lista.length;
        int elementos = 1;
        int inicio, meio, fim;
        
        
        while (elementos < tamanho){
            
            inicio = 0;
            
            while(inicio + elementos < tamanho) {
                
                meio = inicio + elementos;
                
                fim = inicio + 2 * elementos;
                
                if(fim > tamanho) fim = tamanho;
                
                intercalarDecrescente(lista, inicio, meio, fim);
                
                inicio = fim;
            }
            
            elementos *= 2;
        }
    }
    
    private static void intercalarDecrescente(int[] lista, int inicio, int meio, int fim) {
        int novoVetor[] = new int[fim - inicio];
        int i = inicio;
        int m = meio;
        int pos = 0;
        
        while(i < meio && m < fim) {
            
            if(lista[i] >= lista[m]) {
                novoVetor[pos] = lista[i];
                pos++;
                i++;
            }else {
                novoVetor[pos] = lista[m];
                pos = pos + 1;
                m = m + 1;
            }
            
        }
        
        while(i < meio) {
            novoVetor[pos] = lista[i];
            pos++;
            i++;
        }
        
        while(m < fim) {
            novoVetor[pos] = lista[m];
            pos++;
            m++;
        }
        
        for(pos = 0, i = inicio; i < fim; i++, pos++) {
            lista[i] = novoVetor[pos];
        }
    }
}