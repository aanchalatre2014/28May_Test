package com.example.May_Test.controller;

import com.example.May_Test.model.BmsModel;
import com.example.May_Test.service.BmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BmsController {
    @Autowired
    BmsService service;
    @GetMapping("/get_books") // End Point to get details of all the books
    public List<BmsModel> getAllBooks() {

        return service.getAllBooks();
    }
    //EndPoint to list all the books - Subject Wise
    @GetMapping("/list_books/{subject}")
    public List<BmsModel> getBookBySubject(@PathVariable String subject){
        return service.getBookBySubject(subject);
    }

    //EndPoint to list all the books - Subject and Name Wise
    @GetMapping("/list_books_NSW/{name}/{sub}")
    public List<BmsModel> getBookByNameAndSubject(@PathVariable String name, @PathVariable String sub){
        
        return service.getBookByNameAndSubject(name, sub);
    }

    //EndPoint to add new book
    @PostMapping("/add_book") // End Point to add book details in the table
    public String add(@RequestBody BmsModel book) {

        return service.add(book); // it will save employee object into database
    }

    @PutMapping("/update_book/{id}/{subject}/{name}/{pages}") // End point to update specific record..
    public String updateInfo(@PathVariable long id, @PathVariable String subject, @PathVariable String name, @PathVariable int pages){

        return service.updateInfo(id,subject,name,pages);
    }
    @DeleteMapping("/delete_book/{id}") // Endpoint to delete specific record..
    public String remove(@PathVariable long id){

        return service.removeBook(id);
    }

}
