package Application.Java11;

import Application.programs.Employee;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.SSLContext;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpClientEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException, NoSuchAlgorithmException {

        HttpRequest httpRequest= HttpRequest.newBuilder(URI.create("https://postman-echo.com/get"))
                .GET()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpClient httpClient1 = HttpClient.newHttpClient();
        HttpClient httpClient = HttpClient.newBuilder().sslContext(SSLContext.getInstance(""))
                .connectTimeout(Duration.ofSeconds(10)).version(HttpClient.Version.HTTP_2).build();

        CompletableFuture<HttpResponse<String>> httpResponseCompletableFuture = HttpClient.newHttpClient()
                .sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());

        String body =  httpResponseCompletableFuture.get().body();

        System.out.println(body);

    }
}
