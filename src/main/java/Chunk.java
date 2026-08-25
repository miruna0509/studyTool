import java.io.File;

public class Chunk {
    private String text;
    private String sourceFile;
    private int chunkIndex;
    public Chunk(String text, String sourceFile, int chunkIndex) {
        this.text = text;
        this.sourceFile = sourceFile;
        this.chunkIndex = chunkIndex;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getSourceFile() {
        return sourceFile;
    }
    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }
}
