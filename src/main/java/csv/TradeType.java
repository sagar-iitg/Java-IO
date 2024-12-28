package csv;

public enum TradeType {
    BUY,
    SELL;

    // Method to parse a string to TradeType (case-insensitive)
    public static TradeType fromString(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Trade type cannot be null");
        }
        return TradeType.valueOf(type.trim().toUpperCase());
    }
}
