import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NumberStorage {

    // Public method to store the number
    public static void store(int number) {
        // Specify the file where numbers will be stored
        File file = new File("numbers.txt");

        // Use try-with-resources to handle file writing
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            // Check if the file exists and has content
            if (file.exists() && file.length() > 0) {
                // Simply append the number without any spaces or newlines
                writer.write(Integer.toString(number));
            } else {
                // If the file is empty, write the number without any leading space
                writer.write(Integer.toString(number));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
