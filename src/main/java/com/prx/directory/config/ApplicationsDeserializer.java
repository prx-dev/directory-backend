package com.prx.directory.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

import java.io.IOException;
import java.util.Iterator;

/**
 * Custom deserializer for {@link Applications}.
 * This class provides a custom deserialization logic for the Applications object from JSON.
 */
public class ApplicationsDeserializer extends JsonDeserializer<Applications> {

    /**
     * Default constructor.
     * Creates a new instance of ApplicationsDeserializer.
     */
    public ApplicationsDeserializer() {
        super();
    }

    /**
     * Deserializes JSON content into an {@link Applications} object.
     *
     * @param p the JSON parser
     * @param ctxt the deserialization context
     * @return the deserialized Applications object
     * @throws IOException if an I/O error occurs
     */
    @Override
    public Applications deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        Applications applications = new Applications();

        JsonNode applicationsNode = node.get("applications");
        if (applicationsNode != null && applicationsNode.isArray()) {
            Iterator<JsonNode> elements = applicationsNode.elements();
            while (elements.hasNext()) {
                JsonNode applicationNode = elements.next();
                Application application = p.getCodec().treeToValue(applicationNode, Application.class);
                applications.addApplication(application);
            }
        }

        return applications;
    }
}
