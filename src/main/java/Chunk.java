import java.io.File;

public class Chunk {
    private String text;
    private String sourceFile;
    private int chunkIndex;
    private float[]  vector;
    public Chunk(String text, String sourceFile, int chunkIndex, float[] vector) {
        this.text = text;
        this.sourceFile = sourceFile;
        this.chunkIndex = chunkIndex;
        this.vector = vector;
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
    public int getChunkIndex() {
        return chunkIndex;
    }
    public float[] getVector() {
        return vector;
    }
}
