package com.aditya.SpringMVCDemo.controller;

import com.aditya.SpringMVCDemo.dto.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private List<Book> bookList = new ArrayList<>();

    @GetMapping("/books")
    public String getBooks(Model model){
//Book book1 = new Book("Let us See" ,"Aditya" );
//        Book book2 = new Book("You" ,"Sarfaraz" );
//        bookList.add(book1);
//        bookList.add(book2);

        model.addAttribute("books",bookList);
        return "books";
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute Book book){
   bookList.add(book);
   return "redirect:/books";
    }

    @GetMapping("/add-book")
    public String showAllAddedBooks(Model model){
        model.addAttribute("book",new Book());
        return "add-book";
    }

}
