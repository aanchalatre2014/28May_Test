package com.example.May_Test.service;

import com.example.May_Test.model.BmsModel;
import com.example.May_Test.repository.BmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BmsService {
    @Autowired
    BmsRepository repository;

    // List all the Books
    public List<BmsModel> getAllBooks(){
        // it will fetch all the records of Employees in Ascending order of their salary..

        return repository.findByOrderBySubjectAsc();
    }
    public String add(BmsModel book) {
        repository.save(book); // this will add the employee record in the table
        return "Book Added Successfully..!!";
    }

    // Update Book Name, Subject, pages for the selected book id
    public String updateInfo(long id, String subject, String name, int pages){
        BmsModel book=repository.getById(id); // Update specific record..
        book.setSubject(subject); // Subject, Book name, Pages can be updated
        book.setName(name);
        book.setPages(pages);
        repository.save(book);
        return "Data updated successfully..!!";
    }
    // Delete Book for the selected book id...
    public String removeBook(Long id){
        repository.deleteById(id); // Delete specific record..
        return "Record deleted successfully...!!";
    }
    //Fetch all the books based on Subject search
    public List<BmsModel> getBookBySubject(String subject){

        return repository.findBySubject(subject);
    }
    // Fetch all the books based on Name & Subject search
    public List<BmsModel> getBookByNameAndSubject(String name, String sub){

        return repository.findByNameAndSubject(name, sub);
    }
}
