package org.alurachallenge.converter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ConverterGsonDeserializer implements JsonDeserializer<Converter> {

    @Override
    public Converter deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00",symbols);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String baseCode = jsonObject.get("base_code").getAsString();
        String targetCode = jsonObject.get("target_code").getAsString();
        double conversionRateDouble = jsonObject.get("conversion_rate").getAsDouble();
        double conversionResultDouble = jsonObject.get("conversion_result").getAsDouble();
        BigDecimal amount = BigDecimal.valueOf(conversionResultDouble/conversionRateDouble);
        BigDecimal conversionRate = BigDecimal.valueOf(conversionRateDouble);
        BigDecimal conversionResult = BigDecimal.valueOf(conversionResultDouble);
        Converter converter = new Converter(baseCode,targetCode,decimalFormat.format(amount),decimalFormat.format(conversionRate),decimalFormat.format(conversionResult));
        return converter;
    }
}
