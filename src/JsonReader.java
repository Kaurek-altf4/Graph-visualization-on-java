import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class JsonReader{
  
 public List<String> fetchFile(String url) throws IOException, InterruptedException, ConfigException{

   HttpClient client = HttpClient.newBuilder()
        .followRedirects(HttpClient.Redirect.ALWAYS)
        .build();
   HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
   HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

   if (response.statusCode() != 200){
        throw new ConfigException("Неудалось скачать файл: " + response.statusCode());
    }

    String body = response.body();
    return Arrays.asList(body.split("\n"));
  }
}
