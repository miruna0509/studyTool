import java.util.ArrayList;
import java.util.List;

public class Chunker {
    private static final int CHUNK_SIZE = 300;
    private static final int OVERLAP = 50;

    public static List<Chunk> chunk(String text, String sourceFile) {
        List<Chunk> chunks = new ArrayList<>();
        String[] words = text.trim().split("\\s+");

        int start = 0;
        int chunkIndex = 0;

        while (start < words.length) {
            int end = Math.min(start + CHUNK_SIZE, words.length);

            StringBuilder sb = new StringBuilder();
            for (int i = start; i < end; i++) {
                sb.append(words[i]).append(' ');
            }

            chunks.add(new Chunk(sb.toString().trim(), sourceFile, chunkIndex));
            chunkIndex++;

            if (end == words.length) break;

            start = end - OVERLAP;
        }

        return chunks;
    }
}