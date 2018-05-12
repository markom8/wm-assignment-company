package com.wirelessmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "A employee must be team lead!")
public class EmplyeeMystBeTeamLead extends Exception
{

    private static final long serialVersionUID = 2660604039071161606L;


    public EmplyeeMystBeTeamLead(String message)
    {
        super(message);
    }
}
