package Application.Stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExecutorServiceExample {

    public static void main(String[] args) {
        ObjectMapper objectMapper=new ObjectMapper();
        // Create an ExecutorService with a fixed number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Create an instance of HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Define the API endpoint
        String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

        // Create a CompletableFuture for making the HTTP request
        CompletableFuture<HttpResponse<String>> responseFuture = CompletableFuture.supplyAsync(() -> {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            try {
                return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                throw new RuntimeException("Error sending HTTP request: " + e.getMessage(), e);
            }
        }, executorService);

        responseFuture.thenAcceptAsync(r->{
            try {
                List<Root> roots = objectMapper.readValue(r.body(), new TypeReference<>() {
                });
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });


        // Shut down the ExecutorService when done
        executorService.shutdown();
    }
}
class Root{
    public int userId;
    public int id;
    public String title;
    public String body;
}


