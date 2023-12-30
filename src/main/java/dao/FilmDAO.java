package dao;

import dto.FilmDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    private static Connection conn = null;
    static{
        String url = "jdbc:mysql://localhost:3306/filmdb";
        String userName = "root";
        String password = "sql123";
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int insertFilmDetails(FilmDTO f) {
        PreparedStatement pstmt = null;
        int count = 0;
        String insertQuery = "insert into film_info (film_name, fim_year, film_lang, film_rating) values (?, ?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1,f.getFilmName());
            pstmt.setInt(2,f.getFilmYear());
            pstmt.setString(3,f.getFilmLang());
            pstmt. setDouble(4, f.getFilmRating());

            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }

    public int updateFilmDetails(FilmDTO f) {
        int count = 0;
        String updateQuery = "update film_info set  fim_year = "+f.getFilmYear()+" WHERE film_name = '"+f.getFilmName()+"';";

        try {
            Statement stmt = conn.createStatement();
            count = stmt.executeUpdate(updateQuery);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return count;
    }

    public List<FilmDTO> displayFilmDetails() {
        String displayQuery = "select * from film_info";
        List<FilmDTO> filmList = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(displayQuery);

            while (rs.next())
            {
                int filmId = rs.getInt(1);
                String filmName = rs.getString(2);
                int filmYear = rs.getInt(3);
                String filmLang = rs.getString(4);
                double filmRating = rs.getDouble(5);

                FilmDTO f = new FilmDTO(filmName, filmYear, filmLang, filmRating);
                filmList.add(f);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return filmList;
    }
}
