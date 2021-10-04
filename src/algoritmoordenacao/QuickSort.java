package algoritmoordenacao;

import criararquivoarray.CriarArquivoArray;

public class QuickSort {

    public static void main(String[] args) {

        int[] lista = CriarArquivoArray.lerArquivo("C:\\Users\\debba\\Desktop\\arrayAleatorio.json");

        int tamanho = lista.length;
        
        System.out.println("Quick Sort: ");
        
        // CASO MEDIO
        long tempo_inicial = System.currentTimeMillis();

        crescente(lista, 0,tamanho-1);
        
        long tempo_final = System.currentTimeMillis();

        long casoMedio = (tempo_final - tempo_inicial);
        
        
        //MELHOR CASO
        
        tempo_inicial = System.currentTimeMillis();
        
        crescente(lista, 0,tamanho-1);
        
        tempo_final = System.currentTimeMillis();
        
        long melhorCaso = (tempo_final - tempo_inicial);
        
        //PIOR CASO
        
        decrescente(lista, 0,tamanho-1);
        
        tempo_inicial = System.currentTimeMillis();
        
        crescente(lista, 0,tamanho-1);
        
        tempo_final = System.currentTimeMillis();
        
        long piorCaso = (tempo_final - tempo_inicial);


        System.out.printf("Caso medio: %d ms%n", casoMedio);

        System.out.printf("Melhor caso: %d ms%n", melhorCaso);
        
        System.out.printf("Pior caso: %d ms%n", piorCaso);
        
    }
    
    private static void decrescente(int lista[],int menor,int maior){
        int mid = (menor + maior)/2;
        int i = menor;
        int j = maior;
        int pivot = lista[mid];
        while (i<=j) {
            while (lista[i] > pivot){
                i++;
            }
            while (lista[j] < pivot) {
                j--;
            }
            if (i<=j) {
                int temp = lista[i];
                lista[i]= lista[j];
                lista[j]= temp ;
                i++;
                j--;
            }
        }
        if(menor<j) decrescente(lista, menor, j);
        if(maior > i) decrescente(lista, i, maior);
    }
    
    
    
    static void crescente(int lista[],int menor,int maior ) {
        int mid = (menor + maior)/2;
        int i = menor;
        int j = maior;
        int pivot = lista[mid];
        while (i<=j) {
            while (lista[i] < pivot){
                i++;
            }
            while (lista[j] > pivot) {
                j--;
            }
            if (i<=j) {
                int temp = lista[i];
                lista[i]= lista[j];
                lista[j]= temp ;
                i++;
                j--;
            }
        }
        if(menor<j) crescente(lista, menor, j);
        if(maior > i) crescente(lista, i, maior);
    }

}
