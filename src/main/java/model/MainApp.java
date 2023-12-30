package model;

import dao.FilmDAO;
import dto.FilmDTO;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static Scanner sc = new Scanner(System.in);
    private static FilmDAO dao = new FilmDAO();

    public static void main(String[] args) {
        boolean status = true;

        while(status)
        {
            System.out.println("Film Application");
            System.out.println("--------------------------");
            System.out.println("1. Insert Film Details");
            System.out.println("2. Update Film Details");
            System.out.println("3. Display Film Details");
            System.out.println("4. Selected Movies For Oscar Award");
            System.out.println("5. Exit");
            System.out.println("---------------------------");

            System.out.print("Select : ");
            int ch1 = sc.nextInt();
            switch (ch1)
            {
                case 1:
                    insertFilmDetails();
                    break;
                case 2:
                    updateFilmDtails();
                    break;
                case 3:
                    displayFilmDetails();
                    break;
                case 4:
                    awarded();
                    break;
                case 5:
                    status = false;
                    break;
                default:
                    System.err.println("Invalid Input");
            }
        }
    }

    private static void awarded() {

    }

    private static void displayFilmDetails() {
        List<FilmDTO> filmList = dao.displayFilmDetails();
        System.out.println("Film Name ");
        for(FilmDTO f: filmList)
        {
            System.out.println(f.getFilmName()+"            "+f.getFilmYear()+"       "+f.getFilmLang()+"       "+f.getFilmRating());
        }
    }

    private static void updateFilmDtails() {
        System.out.println("Insert Film Name");
        String filmName = sc.next();

        System.out.println("Insert Film Year");
        int filmYear = sc.nextInt();

        FilmDTO f = new FilmDTO();
        f.setFilmName(filmName);
        f.setFilmYear(filmYear);

        int count = dao.updateFilmDetails(f);
        if(count>0){
            System.out.println("Film Details Are Updated Successfully !!");
        }else{
            System.err.println("Film Details are Not Updated !!");
        }
    }

    private static void insertFilmDetails() {
        System.out.println("Insert Film Name");
        sc.nextLine();
        String filmName = sc.nextLine();

        System.out.println("Insert Film Year");
        int filmYear = sc.nextInt();

        System.out.println("Insert Film Language");
        String filmLang = sc.next();

        System.out.println("Insert Film Rating");
        double filmRating = sc.nextDouble();

        FilmDTO f = new FilmDTO();
        f.setFilmName(filmName);
        f.setFilmYear(filmYear);
        f.setFilmLang(filmLang);
        f.setFilmRating(filmRating);

        int count = dao.insertFilmDetails(f);
        if(count>0){
            System.out.println("Details Inserted Successfully !!");
        }else{
            System.err.println("Details Not Inserted !!");
        }
    }
}
