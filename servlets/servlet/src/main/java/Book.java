import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class Book implements Serializable {
    private String name;
    private String author;

    public Book(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
