package algoritmoordenacao;

import criararquivoarray.CriarArquivoArray;

public class InsertionSort {

    public static void main(String[] args) {

        int[] lista = CriarArquivoArray.lerArquivo("C:\\Users\\debba\\Desktop\\arrayAleatorio.json");

        System.out.println("Insertion Sort: ");

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

    private static void crescente(int[] lista) {
        int tamanho = lista.length;
        for (int i = 1; i < tamanho; i++) {
            int aux = lista[i];
            int j = i;
            while ((j > 0) && (lista[j - 1] > aux)) {
                lista[j] = lista[j - 1];
                j -= 1;
            }
            lista[j] = aux;
        }
    }

    private static void decrescente(int[] lista) {
        int tamanho = lista.length;
        for (int i = 1; i < tamanho; i++) {
            int aux = lista[i];
            int j = i;
            while ((j > 0) && (lista[j - 1] < aux)) {
                lista[j] = lista[j - 1];
                j -= 1;
            }
            lista[j] = aux;
        }
    }

}
