import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        DocLoader loader;
        if (fileName1.endsWith(".pdf")) {
            loader = new PDFLoader();
        } else {
            loader = new TxtLoader();
        }
        String s = loader.load(fileName1);
        System.out.println(s);
        List<Chunk> chunks = Chunker.chunk(s, fileName1);
        for (Chunk chunk : chunks) {
            System.out.println("newChunk:\n");
            System.out.println(chunk.getText());
        }
    }
}