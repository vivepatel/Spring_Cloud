package com.bookmanagement.bookmanagementsystem.controller;

import com.tit.springjdbc.Book;
import com.tit.springjdbc.Bookrepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final Bookrepository bookRepository;

    public BookController(Bookrepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/addBook")
    public Object createBook(@RequestBody Book book) {
        try {
            return bookRepository.save(book);

        }catch (NullPointerException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        try{
            return (List<Book>) bookRepository.findAll();
        }
        catch (NullPointerException e) {
            return null;
        }

    }

    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable Long id) {
        try{
            return bookRepository.findById(id).get();
        }
        catch (NullPointerException e) {
            return null;
        }
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updateBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setAuthor(updateBook.getAuthor());
                    book.setTitle(updateBook.getTitle());
                    return bookRepository.save(book);
                })
                .orElseGet(
                        () -> {
                            updateBook.setId(id);
                            return bookRepository.save(updateBook);
                        }
                );
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id) {
        try {
            bookRepository.deleteById(id);
        }
        catch(NullPointerException e) {
            return "Delete Book Failed";
        }
        return "Deleted Book Successfully";
    }

    @DeleteMapping("/deleteAllBooks")
    public String deleteAllBooks() {
        try {
            bookRepository.deleteAll();
        }
        catch(NullPointerException e) {
            return "Delete All Books Failed";
        }
        return "Deleted All Books Successfully";
    }
}
