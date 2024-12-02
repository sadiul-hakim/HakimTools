package com.hakim.hakimtools.restClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

/**
 *
 * @author Hakim
 */
public class WebClient {

    private WebClient() {
    }

    private static final HttpClient client = HttpClient.newHttpClient();

    public static String sendGetRequest(String url, Map<String, String> headers) throws URISyntaxException, IOException, InterruptedException {
        
        // Create get requst builder
        HttpRequest.Builder builder = HttpRequest.newBuilder(new URI(url))
                .GET();

        // Set headers
        headers.forEach((key, value) -> builder.header(key, value));

        // Set timeout
        HttpRequest request = builder.timeout(Duration.ofSeconds(30)).build();

        // Send the request
        return client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).body();
    }
}
