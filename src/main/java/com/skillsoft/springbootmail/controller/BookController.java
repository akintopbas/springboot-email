package com.skillsoft.springbootmail.controller;

import com.skillsoft.springbootmail.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
@Controller
public class BookController {
    private static Map<Integer, Book> bookStore = new HashMap<>();
    static {
        Book book1 = new Book(123,"Harry Potter","J.K. Rowling");
        bookStore.put(book1.getId(),book1);

        Book book2 = new Book(456,"Lord Of The Rings","Tolkien");
        bookStore.put(book2.getId(),book2);
    }

    /*
    @RequestMapping(value = "/")
    public String welcome(){
        return "book";
    }
    */

    @RequestMapping(value = "/getBookById")
    public ResponseEntity<Object> getBookById(@RequestParam("bookId") Integer bookId){
        System.out.println("Retrieving book...");

        return new ResponseEntity<>(bookStore.get(bookId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        System.out.println("Retrieving all books...");

        List<Book> response = new ArrayList<>(bookStore.values());
        return new ResponseEntity<List<Book>>(response,HttpStatus.OK);
    }
}
