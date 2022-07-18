import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;





public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        // Acessar a url

        var url = "https://imdb-api.com/en/API/Top250Movies/k_ii5mdgg8";
        URI uri = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).build();
        
        //Pegar o texto JSON
        String json = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        //Imprimir o JSON
        System.out.println(json);
        
    }
}
