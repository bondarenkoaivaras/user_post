package user.blogpost;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args)  {
        try {
            start();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void start() throws JsonProcessingException{
        ReadJSONFile readJSONFile = new ReadJSONFile();
        readJSONFile.read(FilePath.JSONFILE.value);
        System.out.println("------------------------------------- STARTING APPLICATION--------------------------------");
        System.out.println("Please enter post id or user id: ");
        Scanner scanner = new Scanner(System.in);

        String userInput =  scanner.nextLine();
        if(readJSONFile.validateUserInput(userInput)){
            List<UserPost> userPosts = readJSONFile.getUserPostsByID(userInput);
            userPosts.forEach(System.out::println);
            scanner.close();
        }else{
            System.out.println("No such post was found with given id");
        };
    }
}