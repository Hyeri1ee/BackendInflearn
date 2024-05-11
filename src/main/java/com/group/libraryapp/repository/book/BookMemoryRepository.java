package com.group.libraryapp.repository.book;

import com.group.libraryapp.dto.book.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BookMemoryRepository implements BookRepository{
    @Override
    public void saveBook(){
        System.out.println("memoryRepository");
    }
}
