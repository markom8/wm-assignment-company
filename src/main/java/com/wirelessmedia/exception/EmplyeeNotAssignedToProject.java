package com.wirelessmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "A employee must be assigned to project!")
public class EmplyeeNotAssignedToProject extends Exception
{

    private static final long serialVersionUID = -8461293800328883097L;


    public EmplyeeNotAssignedToProject(String message)
    {
        super(message);
    }
}
