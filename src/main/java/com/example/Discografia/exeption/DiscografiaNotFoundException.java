package com.example.Discografia.exeption;

public class DiscografiaNotFoundException extends RuntimeException{

    public DiscografiaNotFoundException(Long id){
        super("could not find discografia with id: "+ id);
    }
}
