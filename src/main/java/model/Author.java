package model;

import java.sql.Date;

public class Author {

    private int authorId;
    private String authorName;
    private String country;
    private Date birthDate;

    public Author(){

    }

    public Author(int authorId, String authorName, String country, Date birthDate){
        this.authorId = authorId;
        this.authorName = authorName;
        this.country = country;
        this.birthDate = birthDate;
    }

    public Author(String authorName, String country, Date birthDate){
        this.authorName = authorName;
        this.country = country;
        this.birthDate = birthDate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", country='" + country + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

}
