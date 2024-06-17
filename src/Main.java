import java.io.IOException;

public class Main {
    public static void main(String[] args){

        ConsultaCep consulta = new ConsultaCep();

        try {
            Endereco endereco = consulta.buscaEndereco();
            System.out.println(endereco);
            geradorDeArquivo gerador = new geradorDeArquivo();
            gerador.geraArvivoJson(endereco);
        }catch (RuntimeException | IOException  e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }

    }
}