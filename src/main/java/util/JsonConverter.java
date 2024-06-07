package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonConverter {

    private static final String PATH = "C:\\Users\\78945\\IdeaProjects\\foodTicket\\";
//    private static final String PATH = "C:\\Users\\laptop\\Desktop\\놀이방\\FoodTicketJava\\";

    public static <T> List<T> jsonToEntity(final Class<T> clazz, final String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(PATH + path);
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void entityToJson(final T object, final String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(PATH + path);
        List<T> dataList = new ArrayList<>();

        if (file.exists()) {
            try {
                dataList = objectMapper.readValue(file, new TypeReference<List<T>>() {});
            } catch (IOException e) {
                throw new RuntimeException("JSON 파일 읽기 실패", e);
            }
        }

        dataList.add(object);

        try {
            objectMapper.writeValue(file, dataList);
        } catch (IOException e) {
            throw new RuntimeException("JSON 파일 읽기 실패", e);
        }
    }


}
