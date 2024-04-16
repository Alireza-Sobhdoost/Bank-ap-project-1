import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class BankHistory {
    // public static void main(String[] args) {
    //     add_save_history("1894", "A S have increades an pay");
    // }
    public static void save_history(String fileName , String content) {
        // String fileName = "output.txt";
        // String content = "Hello, World!";
        
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
            // System.out.println("Content has been written to " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }



    public static void add_save_history (String fileName , String content) {
        //String fileName = "output.txt";
        //String content = "This is a new line of text.";

        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("\n" + content); // Add a new line before appending content
            writer.close();
            // System.out.println("Content has been appended to " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
    public static void read_saved_history (String fileName) {

        System.out.println("==History==");
        //String fileName = "example.txt"; // Specify the path to your text file

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        
    


    }

}