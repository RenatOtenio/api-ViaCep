import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaCep {

    Scanner leitura = new Scanner(System.in);

    public Endereco buscaEndereco(){

        System.out.println("Digite o CEP:");
        String cep = leitura.nextLine();

        URI endereco = URI.create("https://viacep.com.br/ws/"+ cep +"/json/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (Exception e) {
            throw new RuntimeException("CEP não identificado!");
        }




    }

}
