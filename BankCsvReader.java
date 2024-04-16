import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class BankCsvReader {
    public static void read_data() {
        String csvFile = "account_data.csv";
        String line = "";
        String cvsSplitBy = ",";
        boolean firstLine = true; // Flag to skip the first line

        List<String[]> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip the first line
                    continue;
                }
                String[] data = line.split(cvsSplitBy);
                lines.add(data);
            }

            // Print the data
            // for (String[] row : lines) {
            //     for (String element : row) {
            //         System.out.print(element + ",");
            //     }
            //     System.out.println();
            // }

            BankSignUp.users_detail = lines.toArray(new String[0][]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void read_borrowing_data() {
        String csvFile = "borrowing_data.csv";
        String line = "";
        String cvsSplitBy = ",";
        boolean firstLine = true; // Flag to skip the first line

        List<String[]> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip the first line
                    continue;
                }
                String[] data = line.split(cvsSplitBy);
                lines.add(data);
            }

            // Print the data
            // for (String[] row : lines) {
            //     for (String element : row) {
            //         System.out.print(element + ",");
            //     }
            //     System.out.println();
            // }
            // for (String[] row : BankBorrowing.broowing_detail) {
            //     for (String element : row) {
            //         System.out.print(element + ",");
            //     }
            //     System.out.println();
            // }


            BankBorrowing.broowing_detail = lines.toArray(new String[0][]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public static void main(String[] args) {
    //     read_data();
    // }



    // Method to append data to a 2D array
    public static String[][] appendData(String[][] array, String[] newData) {
        String[][] newArray = new String[array.length + 1][];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = newData;
        return newArray;
    }
    // public static void main(String[] args) {
    //     String[] a = new String[0]; // Initialize as an empty array
    //     String[][] b = new String[0][]; // Initialize as an empty 2D array
    //     read_data();

    // }
}
