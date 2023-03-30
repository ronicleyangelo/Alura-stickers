import GerarFigurinhas.GeradorDeFigurinhas;

import java.awt.*;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url  = "https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbtop250moviesdata.json";
        HttpClient client = HttpClient.newHttpClient();
        URI endereco = URI.create(url);
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        for (Map<String,String> filme : listaDeFilmes) {
            // Print Terminal
            double classificao = Double.parseDouble(filme.get("imDbRating"));
            int numeroEstrela = (int) classificao;

            String texto = "";
            if (numeroEstrela == 8 || numeroEstrela >= 10)  {
                texto = "Ótimas Avaliações 👌";
            } else if(numeroEstrela >= 7 || numeroEstrela == 6) {
                texto = "Filme pouco recomendado 🤔";
            } else {
                texto = "Não recomendado 😿";
            }
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            var geradora = new GeradorDeFigurinhas();
            geradora.criar(inputStream, nomeArquivo, texto);

            System.out.println("\u001b[38;5;214mTítulo:\u001b[m" + " 🎥 " + filme.get("title"));
            System.out.println("\u001b[38;5;218mImagem:\u001b[m" + filme.get("image"));
            System.out.println("\u001b[38;5;212mClassificação: \u001b[m" + filme.get("imDbRating"));

            for (int i = 1; i <= numeroEstrela; i++) {
                System.out.print("⭐");
            }

            System.out.println("\n");
        }
    }
}
    

