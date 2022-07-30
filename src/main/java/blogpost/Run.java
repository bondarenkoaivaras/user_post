package main.java.blogpost;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        int option = 1;
        Scanner sc = null;
        while (option != 2) {
            System.out.println("--------------- Pasirinkite varianta: ---------------");
            System.out.println("Iveskite 1 jei norite gauti vartotojo posta pagal id");
            System.out.println("Iveskite 2 jei norite baigti");
            sc = new Scanner(System.in);
            try {
                option = sc.nextInt();
                if(option != 1 && option != 2){
                    System.out.println("Tokio pasirinkimo nera, bandykite dar karta");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ivesta neteisinga reiksme, bandykite dar karta");
                continue;
            }

            if (option == 2) {
                System.out.println("Pasirinkote uzbaigti darba");
                break;
            }

            sc = new Scanner(System.in);
            System.out.println("Iveskite iraso id: ");
            int userInput;

            try {
                userInput = sc.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Ivesta neteisinga reiksme, bandykite dar karta");
                continue;
            }

            String errorMessage = JsonRepository.read(FilePath.JSONFILE.value);
            if(errorMessage == "" && JsonRepository.getUserPosts() != null){
                List<UserPost> userPosts = JsonRepository.getUserPostsByID(userInput);
                if(userPosts.isEmpty()){
                    System.out.println("Tokio vartotojo ar irasu su siuo id nera");
                }else{
                    userPosts.forEach(System.out::println);
                }
                userPosts.forEach(System.out::println);
            }else{
                System.out.println(errorMessage);
                break;
            }
        }

        if (sc != null) {
            sc.close();
        }
    }
}