ConsultaCep
Este projeto em Java realiza consultas de endereço com base no CEP utilizando a API pública ViaCEP. A aplicação faz uma requisição HTTP e converte o JSON de resposta em um objeto da classe Endereco utilizando a biblioteca Gson.

Funcionalidades
Consulta de endereço a partir de um CEP.
Conversão automática do JSON de resposta para um objeto Java.
Tratamento de erros caso a consulta não seja bem-sucedida.
Pré-requisitos
Para executar este projeto, você precisará ter instalado:

Java 11+
Gson
Conexão com a Internet para realizar as consultas à API ViaCEP.
Como executar
Clone este repositório em sua máquina local:
https://github.com/EuSouWill/buscadorCep.git
Importe o projeto na sua IDE favorita (como IntelliJ ou Eclipse).

Certifique-se de que o Maven ou Gradle esteja configurado para baixar a dependência da biblioteca Gson. Adicione no seu arquivo pom.xml (para Maven):
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.6</version>
</dependency>
Compile e execute o código. Você pode utilizar um método main() para testar a funcionalidade:
public static void main(String[] args) {
    ConsultaCep consulta = new ConsultaCep();
    Endereco endereco = consulta.buscaEndereco("01001000"); // Exemplo de CEP
    System.out.println(endereco);
}

Estrutura do Código
ConsultaCep.java: Esta classe realiza a requisição HTTP para a API ViaCEP e converte o resultado JSON em um objeto Endereco.

Endereco.java: Classe de modelo que representa o endereço retornado pela API.
Tratamento de Erros
Caso a API não consiga processar o CEP ou haja problemas na comunicação, uma exceção será lançada com a mensagem:
"Não conseguiu obter o endereço a partir desse cep"

Desenvolvido por WIlliam Régis.
