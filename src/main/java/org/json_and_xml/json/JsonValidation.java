package org.json_and_xml.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class JsonValidation {

    /**
     * This method Validate  actor.json  and actor_schema.json   using  json-schema-validator lib.
     *
     * @throws ProcessingException;
     * @throws IOException;
     */
    public void validationJson(String pathJson, String pathJsonScheme) throws ProcessingException, IOException {
        File actorFile = new File(pathJson);
        JsonNode actorJson = new ObjectMapper().readTree(actorFile);

        File schemaFile = new File(pathJsonScheme);
        JsonNode schemaJson = new ObjectMapper().readTree(schemaFile);

        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaJson);

        try {
            schema.validate(actorJson);
            System.out.println("Validation succeeded");
        } catch (ProcessingException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
