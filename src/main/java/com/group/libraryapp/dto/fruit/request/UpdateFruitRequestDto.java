package com.group.libraryapp.dto.fruit.request;

public class UpdateFruitRequestDto {
    private long id;
    public UpdateFruitRequestDto(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
