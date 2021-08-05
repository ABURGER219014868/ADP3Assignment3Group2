package za.ac.cput.entity;
/*
 * Genre.java
 * This code represents an entity using the builder pattern
 * @author Plamedie Bitota Bukasa (219260532)
 * Date: 10th June 2021
 */
public class BookGenre
{
    private String bookGenreId,genreId,bookId;

    public BookGenre(BookGenre.Builder builder)
    {
        this.bookGenreId= builder.bookGenreId;
        this.genreId=builder.genreId;
        this.bookId=builder.bookId;

    }

    @Override
    public String toString() {
        return "BookGenre{" +
                "bookGenreId='" + bookGenreId + '\'' +
                ", genreId='" + genreId + '\'' +
                ", bookId='" + bookId + '\'' +
                '}';
    }

    public String getbookGenreId()
    {
        return bookGenreId;
    }

    public static class Builder
    {
        private String bookGenreId,genreId,bookId;

        public BookGenre.Builder setBookGenreId(String bookGenreId)
        {
            this.bookGenreId = bookGenreId;
            return this;
        }

        public BookGenre.Builder setGenreId(String genreId) {
            this.genreId =genreId;
            return this;
        }
        public BookGenre.Builder setBookId(String bookId) {
            this.bookId =bookId;
            return this;
        }
        public BookGenre build()
        {
            return new BookGenre(this);
        }
        public BookGenre.Builder copy (BookGenre bookGenre)
        {
            this.bookGenreId=bookGenre.bookGenreId;
            this.genreId=bookGenre.genreId;
            this.bookId=bookGenre.bookId;
            return this;
        }

    }
}
