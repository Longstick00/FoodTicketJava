package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Restaurant;
import domain.RestaurantList;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonConverter {

    public static JsonConverter create() {
        return new JsonConverter();
    }

    private JsonConverter() {
    }

    public RestaurantList convertToObject() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            List<Restaurant> restaurants = objectMapper.readValue(new File("C:\\Users\\78945\\IdeaProjects\\foodTicket\\info.json"), new TypeReference<List<Restaurant>>() {
            });
            return new RestaurantList(restaurants);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
