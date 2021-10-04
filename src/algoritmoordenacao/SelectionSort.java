package algoritmoordenacao;

import criararquivoarray.CriarArquivoArray;

public class SelectionSort {

    public static void main(String args[]) {

        int[] lista = CriarArquivoArray.lerArquivo("C:\\Users\\debba\\Desktop\\arrayAleatorio.json");

        System.out.println("Selection Sort: ");

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
        int size = lista.length;
        for (int i = 0; i < size - 1; i++) {
            int min = i;

            for (int j = i + 1; j < size; j++) {
                if (lista[j] < lista[min]) {
                    min = j;
                }
            }
            int temp = lista[min];
            lista[min] = lista[i];
            lista[i] = temp;
        }
    }
    
    private static void decrescente(int[] lista){
        int size = lista.length;
        for (int i = 0; i < size - 1; i++) {
            int max = i;

            for (int j = i + 1; j < size; j++) {
                if (lista[j] > lista[max]) {
                    max = j;
                }
            }
            int temp = lista[max];
            lista[max] = lista[i];
            lista[i] = temp;
        }
    }
}
