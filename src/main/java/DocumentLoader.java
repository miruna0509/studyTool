import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DocumentLoader {
    public static String readFromFile(String fileName1) throws FileNotFoundException {
        StringBuilder text = new StringBuilder();
        Scanner input = new Scanner(new File(fileName1));
        while (input.hasNextLine()) {
            text.append(input.nextLine());
            text.append("\n");
        }
        return text.toString();
    }
}
