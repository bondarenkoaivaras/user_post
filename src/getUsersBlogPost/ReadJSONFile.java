package getUsersBlogPost;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class ReadJSONFile {
    private ObjectMapper objectMapper;

    ReadJSONFile (){
        this.objectMapper = new ObjectMapper();
    }

    public void read(String filePath) throws JsonProcessingException {
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // convert JSON array to list of books
        List<UserPost> books = null;
        try {
            books = Arrays.asList(objectMapper.readValue(new File(filePath), UserPost[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // print books
        books.forEach(System.out::println);
    }
}
