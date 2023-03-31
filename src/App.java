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

        var http = new ClienteHttp();
        String json = http.buscarDados(url);

        JsonParser parser = new JsonParser();

        var extrator = new ExtratorDeConteudoDaNasa();
        List<Conteudo> conteudos = extrator.extradorDeConteudoDaNasa(json);

        for (int i = 0; 0 <= 3; i++) {
            Conteudo conteudo = conteudos.get(i);
            String texto = "";

            InputStream inputStream = new URL().openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";
            var geradora = new GeradorDeFigurinhas();
            geradora.criar(inputStream, nomeArquivo, texto);

            System.out.println("\n");
        }
    }
}
    

