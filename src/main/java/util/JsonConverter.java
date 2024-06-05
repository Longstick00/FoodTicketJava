package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonConverter {

    private static final String PATH = "C:\\Users\\78945\\IdeaProjects\\foodTicket\\";

    public static <T> List<T> convertToEntity(Class<T> clazz, String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(PATH + path);
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
