import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();
        boolean cepValido = false;

        while (!cepValido) {
            System.out.println("Digite um número de CEP para consulta: ");

            var cep = leitura.nextLine();
            if (cep.equalsIgnoreCase("sair")) {
                System.out.println("Finalizando operação");
                break;
            }
            try {
                Endereco novoEndereco = consultaCep.buscaEndereco(cep);
                System.out.println(novoEndereco);
                GeradorDeArquivo gerador = new GeradorDeArquivo();
                gerador.salvaJson(novoEndereco);
            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando aplicação.");
            }
        }
    }
}
