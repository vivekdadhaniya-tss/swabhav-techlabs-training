package com.tss.ooad.chap05_part2_cohesive;

import java.util.HashMap;
import java.util.Map;

public class InstrumentSpec {

    private Map<String, Object> properties;

    public InstrumentSpec(Map<String, Object> properties) {
        this.properties = (properties == null)
                ? new HashMap<>()
                : new HashMap<>(properties);
    }

    public Object getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public boolean matches(InstrumentSpec searchSpec) {
        for (Map.Entry<String, Object> entry : searchSpec.getProperties().entrySet()) {
            String propertyName = entry.getKey();
            Object searchValue = entry.getValue();
            Object thisValue = properties.get(propertyName);

            if (thisValue == null || !thisValue.equals(searchValue)) {
                return false;
            }
        }
        return true;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//
//        for (Map.Entry<String, Object> entry : properties.entrySet()) {
//            builder.append(entry.getKey())
//                    .append(" : ")
//                    .append(entry.getValue())
//                    .append("\n");
//        }
//
//        return builder.toString();
//    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {

            String formattedKey = formatKey(entry.getKey());

            builder.append(String.format("%-18s : %s%n",
                    formattedKey,
                    entry.getValue()));
        }

        return builder.toString();
    }

    private String formatKey(String key) {

        // Convert camelCase to words
        String result = key.replaceAll("([a-z])([A-Z])", "$1 $2");

        // Capitalize first letter
        return result.substring(0, 1).toUpperCase() + result.substring(1);
    }
}

