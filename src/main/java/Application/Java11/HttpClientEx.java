package Application.Java11;

import Application.programs.Employee;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.*;
import java.util.concurrent.CompletableFuture;

public class HttpClientEx {
    public static void main(String[] args) throws Exception {

        HttpRequest httpRequest= HttpRequest.newBuilder(URI.create("https://postman-echo.com/get"))
                .GET()
                .version(HttpClient.Version.HTTP_2)
                .build();

        CompletableFuture<HttpResponse<String>> httpResponseCompletableFuture = HttpClient.newHttpClient()
                .sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());

        String body =  httpResponseCompletableFuture.get().body();

        System.out.println(body);


        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream(new File("keystore.jks")),
                "secret".toCharArray());

        var sslContext = SSLContext.getInstance("SSL");
        KeyManager[] k = new KeyManager[0];
        TrustManager[] xs = new TrustManager[0];
        sslContext.init(k, xs, new SecureRandom());

    }
}
