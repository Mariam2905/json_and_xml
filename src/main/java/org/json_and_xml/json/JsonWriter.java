package org.json_and_xml.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JsonWriter {

    /**
     * This method generate json file from object.
     *
     * @param actor;
     * @param file;
     * @throws IOException;
     */
    public void jsonWriter(Actor actor, File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String jsonString = objectMapper.writeValueAsString(actor);
        objectMapper.writeValue(file, actor);
    }
}
