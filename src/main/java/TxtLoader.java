import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TxtLoader implements DocLoader {
    public String load(String fileName1) throws IOException {
        StringBuilder text = new StringBuilder();
        Scanner input = new Scanner(new File(fileName1));
        while (input.hasNextLine()) {
            text.append(input.nextLine());
            text.append("\n");
        }
        return text.toString();
    }
}
