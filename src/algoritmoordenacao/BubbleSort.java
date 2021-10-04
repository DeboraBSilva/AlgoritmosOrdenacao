package algoritmoordenacao;

import criararquivoarray.CriarArquivoArray;

public class BubbleSort {

    public static void main(String[] args) {

        int[] lista = CriarArquivoArray.lerArquivo("C:\\Users\\debba\\Desktop\\arrayAleatorio.json");

        System.out.println("Bubble Sort: ");
        
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
    
    private static void crescente(int[] lista){
        int tamanho = lista.length;
        int temp = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 1; j < (tamanho - i); j++) {
                if (lista[j - 1] > lista[j]) {
                    //inverte os elementos 
                    temp = lista[j - 1];
                    lista[j - 1] = lista[j];
                    lista[j] = temp;
                }
            }
        }
    }
    
    private static void decrescente(int[] lista){
        int tamanho = lista.length;
        int temp = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 1; j < (tamanho - i); j++) {
                if (lista[j - 1] < lista[j]) {
                    //inverte os elementos   
                    temp = lista[j - 1];
                    lista[j - 1] = lista[j];
                    lista[j] = temp;
                }
            }
        }
    }

}
