import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa {
    public List<Conteudo> extradorDeConteudoDaNasa(String json) {

        JsonParser parser         = new JsonParser();
        List<Map<String, String>> listaDeAtributo = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de atributo
        for (Map<String, String> atributos : listaDeAtributo) {
            String titulo    = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo     = new Conteudo(titulo, urlImagem);
            conteudos.add(conteudo);
        }
        return conteudos;
    }
}
