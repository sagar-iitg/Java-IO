package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MonthlyTradeSummary {
    public static void main(String[] args) {
        String filePath = "src/main/resource/tradebook.csv";

        // Map to hold year-wise and month-wise totals for each trade type
        Map<Integer, Map<String, Map<TradeType, Double>>> yearWiseTotals = new HashMap<>();

        // Define custom month order: April to March
        List<String> customMonthOrder = Arrays.asList(
                "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER",
                "OCTOBER", "NOVEMBER", "DECEMBER", "JANUARY", "FEBRUARY", "MARCH"
        );

        // Date formatter for parsing trade_date
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header row
            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("CSV file is empty.");
                return;
            }

            String[] header = headerLine.split(",");
            int priceIndex = -1, quantityIndex = -1, tradeTypeIndex = -1, tradeDateIndex = -1;

            for (int i = 0; i < header.length; i++) {
                if (header[i].equalsIgnoreCase("price")) priceIndex = i;
                if (header[i].equalsIgnoreCase("quantity")) quantityIndex = i;
                if (header[i].equalsIgnoreCase("trade_type")) tradeTypeIndex = i;
                if (header[i].equalsIgnoreCase("trade_date")) tradeDateIndex = i;
            }

            if (priceIndex == -1 || quantityIndex == -1 || tradeTypeIndex == -1 || tradeDateIndex == -1) {
                System.out.println("Required columns not found in the CSV file.");
                return;
            }

            // Process the rows
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                try {
                    // Parse trade type
                    TradeType tradeType = TradeType.fromString(values[tradeTypeIndex]);

                    // Parse trade_date and extract year and month
                    LocalDate tradeDate = LocalDate.parse(values[tradeDateIndex], dateFormatter);
                    String month = tradeDate.getMonth().toString(); // e.g., "JANUARY"
                    int year = tradeDate.getYear();

                    // Adjust the year for months January to March
                    if (tradeDate.getMonthValue() <= 3) {
                        year--; // Move to the previous fiscal year
                    }

                    // Parse price and quantity
                    double price = Double.parseDouble(values[priceIndex]);
                    double quantity = Double.parseDouble(values[quantityIndex]);
                    double total = price * quantity;

                    // Update the totals in the map
                    yearWiseTotals
                            .computeIfAbsent(year, k -> new HashMap<>())      // Get or create year entry
                            .computeIfAbsent(month, k -> new HashMap<>())    // Get or create month entry
                            .merge(tradeType, total, Double::sum);           // Add the total to the specific trade type
                } catch (Exception e) {
                    System.out.println("Error processing row: " + line);
                    e.printStackTrace();
                }
            }

            // Print the results
            System.out.println("Month-wise totals for BUY and SELL transactions (April to March):");
            for (Map.Entry<Integer, Map<String, Map<TradeType, Double>>> yearEntry : yearWiseTotals.entrySet()) {
                int year = yearEntry.getKey();
                Map<String, Map<TradeType, Double>> monthWiseData = yearEntry.getValue();

                double totalBuy = 0.0;
                double totalSell = 0.0;

                System.out.printf("Year: %d-%d%n", year, year + 1); // Print fiscal year
                for (String month : customMonthOrder) {
                    if (monthWiseData.containsKey(month)) {
                        Map<TradeType, Double> tradeTotals = monthWiseData.get(month);
                        double buyTotal = tradeTotals.getOrDefault(TradeType.BUY, 0.0);
                        double sellTotal = tradeTotals.getOrDefault(TradeType.SELL, 0.0);

                        // Add month totals to the overall year totals
                        totalBuy += buyTotal;
                        totalSell += sellTotal;

                        System.out.printf("%s: BUY = %.2f, SELL = %.2f%n", month, buyTotal, sellTotal);
                    } else {
                        System.out.printf("%s: BUY = 0.00, SELL = 0.00%n", month);
                    }
                }

                // Print the total summary for the year
                System.out.printf("Total for Year %d-%d: BUY = %.2f, SELL = %.2f%n", year, year + 1, totalBuy, totalSell);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
