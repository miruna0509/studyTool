import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EmbeddingClient {
    float[] embed(String text) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject obj = new JSONObject("nomic-embed-text", text);
        String jsonString = objectMapper.writeValueAsString(obj);
        System.out.println(jsonString);
        HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:11434/api/embeddings"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode node = objectMapper.readTree(response.body());
        JsonNode embeddingArray = node.get("embedding");
        float[] embeddings = new float[embeddingArray.size()];
        for(int i = 0; i < embeddingArray.size(); i++) {
            embeddings[i] = embeddingArray.get(i).floatValue();
        }
        return embeddings;


    }

}
