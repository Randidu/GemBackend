package com.srilankagem.gembackend.common.exception;

public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(String resource ,String field){
        super(String.format("Resource Not Found -%s with field - %s" , resource,field));
    }
}
