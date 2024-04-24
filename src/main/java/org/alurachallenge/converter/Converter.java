package org.alurachallenge.converter;

public class Converter {
    private String baseCode;
    private String targetCode;
    private String amount;
    private String conversionRate;
    private String conversionResult;

    public Converter(String baseCode, String targetCode, String amount, String conversionRate, String conversionResult) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.amount = amount;
        this.conversionRate = conversionRate;
        this.conversionResult = conversionResult;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public String getAmount() {
        return amount;
    }

    public String getConversionRate() {
        return conversionRate;
    }

    public String getConversionResult() {
        return conversionResult;
    }

    @Override
    public String toString() {
        return "El cambio de " + amount +" "+ baseCode +" a " + targetCode + " es: " + conversionResult;
    }
}
