import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String fileName1 = args[0];
        DocLoader loader;
        if (fileName1.endsWith(".pdf")) {
            loader = new PDFLoader();
        } else {
            loader = new TxtLoader();
        }
        String s = loader.load(fileName1);
        List<Chunk> chunks = Chunker.chunk(s, fileName1);

        RetrievalClient retrievalClient = new RetrievalClient();
        List<Chunk> results = retrievalClient.relevantChunks("What are the phases of cell division", chunks);

        StringBuilder context = new StringBuilder();
        for (Chunk chunk : results) {
            context.append(chunk.getText()).append("\n\n");
        }

        GenerationClient generationClient = new GenerationClient();
        String answer = generationClient.generate(
                "Given the following context: " + context + "\n\nAnswer this prompt: What are the phases of cell division"
        );

        System.out.println("Answer: " + answer);
    }
}