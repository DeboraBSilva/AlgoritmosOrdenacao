package criararquivoarray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CriarArquivoArray {

    public static void main(String[] args) throws IOException {
        String nomeArquivo = "arrayAleatorio.json";
        String path = "C:\\Users\\debba\\Desktop\\" + nomeArquivo;
        escreverArquivo(path);
        lerArquivo(path);
    }

    private static void escreverArquivo(String path) throws IOException {
        JSONArray jsArray = new JSONArray();
        Random num_aleatorio = new Random();
        FileWriter arq = new FileWriter(path);
        for (int i = 0; i < 100000; i++) {
            jsArray.add(num_aleatorio.nextInt(1000));
        }
        arq.write(jsArray.toJSONString());
        arq.close();
        System.out.printf("\nLista gravada com sucesso em " + path + ".\n");
    }

    public static int[] lerArquivo(String path) {
        JSONArray jsonArray;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        
        //Variaveis que irao armazenar os dados do arquivo JSON
        int[] lista;
        lista = new int[100_000];
        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonArray = (JSONArray) parser.parse(new FileReader(path));

            //Salva nas variaveis os dados retirados do arquivo
            for (int i = 0; i < 100000; i++) {
                lista[i] = Integer.parseInt(jsonArray.get(i).toString());
            }
        } //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("Error:" + e);
        } catch (ParseException e) {
            System.out.println("Error:" + e);
        }
        return lista;
    }

}
