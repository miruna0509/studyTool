import java.io.IOException;
import java.util.*;

public class RetrievalClient {
    private EmbeddingClient embeddingClient =  new EmbeddingClient();
    public List<Chunk> relevantChunks(String question, List<Chunk> chunks) throws IOException, InterruptedException {
        List<Chunk> copyChunks = new ArrayList<>(chunks);
        List<Chunk> relevantChunks = new ArrayList<>();
        Map<Chunk,Double> similarities =  new HashMap<>();
        float[] questionEmbedding = embeddingClient.embed(question);
        for(Chunk chunk : chunks){
        similarities.put(chunk,cosineSimilarity(questionEmbedding, chunk.getVector()));
        }
        Collections.sort(copyChunks, (c2,c1) -> Double.compare(similarities.get(c1),similarities.get(c2)));
        for(int i = 0; i < Math.min(5, copyChunks.size()); i++){
            relevantChunks.add(copyChunks.get(i));
        }
        return relevantChunks;
    }
    public double cosineSimilarity(float[] vector1, float[] vector2){
        double sum = 0;
        for(int i = 0; i < vector1.length; i++){
            sum += vector1[i] * vector2[i];
        }
        return (double) sum/(magnitude(vector1)*magnitude(vector2));
    }
    public double magnitude(float[] vector){
        double sum = 0;
        for(int i = 0; i < vector.length; i++){
            sum += vector[i] * vector[i];
        }
        return (double)Math.sqrt(sum);
    }
}
