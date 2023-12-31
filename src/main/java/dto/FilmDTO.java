package dto;

public class FilmDTO {
    private int filmId;
    private String filmName;
    private int filmYear;
    private String filmLang;
    private double filmRating;

    public FilmDTO() {
    }

    public FilmDTO(String filmName, int filmYear, String filmLang, double filmRating) {
        this.filmName = filmName;
        this.filmYear = filmYear;
        this.filmLang = filmLang;
        this.filmRating = filmRating;
    }

    public int getFilmId() {
        return filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getFilmYear() {
        return filmYear;
    }

    public void setFilmYear(int filmYear) {
        this.filmYear = filmYear;
    }

    public String getFilmLang() {
        return filmLang;
    }

    public void setFilmLang(String filmLang) {
        this.filmLang = filmLang;
    }

    public double getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(double filmRating) {
        this.filmRating = filmRating;
    }
}
