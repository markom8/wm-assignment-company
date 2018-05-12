package com.wirelessmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "A employee must be junior or senior developer!")
public class EmplyeeMystBeJuniorOrMediorDeveloper extends Exception
{

    private static final long serialVersionUID = -4464338314368265241L;


    public EmplyeeMystBeJuniorOrMediorDeveloper(String message)
    {
        super(message);
    }
}
