//Pacote java.net
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        var url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";

        var http = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(new URI(url)).GET().build();

        HttpResponse<String> response = http.send(request, BodyHandlers.ofString());

        var body = response.body();

        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = jsonParser.parse(body);
    }
}
