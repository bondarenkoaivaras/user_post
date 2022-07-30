package main.java.blogpost;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

///MAKE IT STATIC
public class JsonRepository {
    private final static ObjectMapper objectMapper;
    private static List<UserPost> userPosts;

    static {
        objectMapper = new ObjectMapper();
        userPosts = null;
    }

    /* Nuskaito faila ir issaugo sukurtus objektus userPost sarase*/

    public static String read(String filePath) {

        String error = "";
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // convert JSON array to list of books
        try {
            userPosts = Arrays.asList(objectMapper.readValue(new File(filePath), UserPost[].class));
        }catch (JsonProcessingException e){
            error = "Nepavyko nuskaityti failo: " + filePath;
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            error = "Nepavyko rasti kelio, failas: " + filePath + "Neegzistuoja";
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            error = "Ivyko klaida: " + e.getMessage();
        }

        return error;
    }

    public static List<UserPost> getUserPostsByID(int id) {

        List<UserPost> posts = new ArrayList<>();

        for (UserPost userPost : userPosts) {
            if (validateMatchingId(userPost, id)) {
                posts.add(userPost);
            }
        }

        return posts;
    }

    public static List<UserPost> getUserPosts(){
        return userPosts;
    }
    public static boolean validateMatchingId(UserPost post, int userInput) {
        return post.getUserId().equals(userInput) || post.getId() == userInput;
    }
}
