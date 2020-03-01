package blog.juanfrancisco.net.sofware.architecture.lab3.services;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Book;

import java.util.List;

public interface BookServices {
    public Book  addBook(Book book);
    public void  deleteBook(String isbn);
    public Book getBook(String isbn);
    public List<Book> getAllBooks();
}
