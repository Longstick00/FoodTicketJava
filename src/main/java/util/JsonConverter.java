package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonConverter {

    private static final String PATH = "C:\\Users\\78945\\IdeaProjects\\foodTicket\\";

    public static <T> List<T> convertToEntity(Class<T> clazz, String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            // Create a TypeReference for the given class
            TypeReference<List<T>> typeReference = new TypeReference<>() {};
            return objectMapper.readValue(new File(PATH), typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public static List<Restaurant> convertToRestaurant() {
//        return convertToEntity(Restaurant.class);
//    }
//
//    public static List<Account> convertToAccounts() {
//        return convertToEntity(Account.class);
//    }

}
