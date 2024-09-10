import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GeradorDeArquivo {
    private static final String FILE_NAME = "enderecos.json";

    public void salvaJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Lê o conteúdo existente do arquivo JSON
        List<Endereco> enderecos = new ArrayList<>();
        try (FileReader leitor = new FileReader(FILE_NAME)) {
            Type enderecoListType = new TypeToken<ArrayList<Endereco>>() {}.getType();
            enderecos = gson.fromJson(leitor, enderecoListType);
            if (enderecos == null) {
                enderecos = new ArrayList<>();
            }
        } catch (IOException e) {
            // Caso o arquivo não exista, iniciamos uma nova lista
            System.out.println("Arquivo não encontrado, será criado um novo.");
        }

        // Adiciona o novo endereço à lista
        enderecos.add(endereco);

        // Escreve a lista atualizada no arquivo JSON
        try (FileWriter escrita = new FileWriter(FILE_NAME)) {
            escrita.write(gson.toJson(enderecos));
        }
    }
}
