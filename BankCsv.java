import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

public class BankCsv {

    public static void file_update() throws IOException {
        File file = new File("account_data.csv");
        
        // Delete the file if it exists
        if (file.exists()) {
            file.delete();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("First name,Last name,Password,Account number,Credit\n");
            
            for (String[] rowData : BankSignUp.users_detail) {
                for (int i = 0; i < rowData.length; i++) {
                    writer.write(rowData[i]);
                    if (i < rowData.length - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
            
            // System.out.println("Data added successfully to the CSV file.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
    public static void file_update_broowing() throws IOException {
        File file = new File("borrowing_data.csv");
        
        // Delete the file if it exists
        if (file.exists()) {
            file.delete();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("Identify code,Costs remain\n");
            
            for (String[] rowData : BankBorrowing.broowing_detail) {
                for (int i = 0; i < rowData.length; i++) {
                    writer.write(rowData[i]);
                    if (i < rowData.length - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
            
            // System.out.println("Data added successfully to the CSV file.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}

