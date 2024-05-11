package com.group.libraryapp.repository.book;

import org.springframework.stereotype.Repository;

@Repository
public class BookMemoryRepository implements BookRepository{
    @Override
    public void saveBook(){
        System.out.println("memoryRepository");
    }
}
