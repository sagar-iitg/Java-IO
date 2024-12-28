package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvCalculateExample {
    public static void main(String[] args) {
        String filePath = "src/main/resource/tradebook.csv";
        double totalSum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header row
            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("CSV file is empty.");
                return;
            }

            String[] header = headerLine.split(",");
            int priceIndex = -1, quantityIndex = -1, tradeTypeIndex = -1;

            for (int i = 0; i < header.length; i++) {
                if (header[i].equalsIgnoreCase("price")) priceIndex = i;
                if (header[i].equalsIgnoreCase("quantity")) quantityIndex = i;
                if (header[i].equalsIgnoreCase("trade_type")) tradeTypeIndex = i;
            }

            if (priceIndex == -1 || quantityIndex == -1 || tradeTypeIndex == -1) {
                System.out.println("Required columns not found in the CSV file.");
                return;
            }

            // Process the rows
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                try {
                    TradeType tradeType = TradeType.fromString(values[tradeTypeIndex]);
                    if (tradeType == TradeType.BUY) { // Check using enum
                        double price = Double.parseDouble(values[priceIndex]);
                        double quantity = Double.parseDouble(values[quantityIndex]);
                        totalSum += price * quantity;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid trade type found: " + values[tradeTypeIndex]);
                }
            }

            System.out.println(String.format("Total: %f", totalSum));

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
