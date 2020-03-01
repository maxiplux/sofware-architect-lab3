package blog.juanfrancisco.net.sofware.architecture.lab3.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Book {
    @Id
    private String commentId;


    private String isbn;


    private String content;

}
