package ecom.domain;

import javax.validation.constraints.NotNull;

public class Search {

    @NotNull
    private String book_name;

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
}
