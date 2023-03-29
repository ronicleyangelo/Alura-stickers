import java.net.URI;
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
            System.out.println("\u001b[38;5;214mTítulo:\u001b[m" + " 🎥 " + filme.get("title"));
            System.out.println("\u001b[38;5;218mURL da imagem:\u001b[m" + filme.get("image"));
            System.out.println();
            double classificao = Double.parseDouble(filme.get("imDbRating"));
            int numeroEstrela = (int) classificao;
            for (int i = 1; i <= numeroEstrela ; i++) {
                System.out.print("❤");
            }
            System.out.println("\n");
        }
    }
}
    

