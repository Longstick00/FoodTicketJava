package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonConverter {

    private static final String PATH = "C:\\Users\\78945\\IdeaProjects\\foodTicket\\";

    public static <T> List<T> jsonToEntity(Class<T> clazz, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(PATH + fileName);
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void entityToJson(T object, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(PATH + fileName);
        List<T> dataList = new ArrayList<>();

        if (file.exists()) {
            try {
                dataList = objectMapper.readValue(file, new TypeReference<>() {});
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
