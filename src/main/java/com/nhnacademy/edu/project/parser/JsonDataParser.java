package com.nhnacademy.edu.project.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class JsonDataParser implements DataParser {

    Collection<WaterBill> list;

    public JsonDataParser() {
        this.list = new ArrayList<>();
    }

    @Override
    public void parse(String fileLocation) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileLocation);

        try {
            List values = mapper.readValue(file, List.class);
            values.forEach(value -> {
                String valueString = value.toString();
                String[] split = valueString.split(",");
                WaterBill temp = new WaterBill(
                        Integer.parseInt(split[0].substring(4)),    // seq
                        split[1].substring(6),  // city
                        split[2].substring(4),  // sector
                        Integer.parseInt(split[4].substring(13)),   // sectionStart
                        Integer.parseInt(split[5].substring(12)),   // sectionEnd
                        Integer.parseInt(split[6].substring(9))     // unitPrice
                );
                list.add(temp);
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<WaterBill> findAll() {
        return list;
    }
}
