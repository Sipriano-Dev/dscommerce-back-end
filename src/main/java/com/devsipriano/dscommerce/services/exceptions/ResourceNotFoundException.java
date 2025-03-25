package com.devsipriano.dscommerce.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{//Runtime não exige o try catch, Exception exige

    //Vai intercepta a excetpion e lança sua propria
    public ResourceNotFoundException(String msg) {//Recebe e passa a msg para runtimeException
        super(msg);
    }

}
