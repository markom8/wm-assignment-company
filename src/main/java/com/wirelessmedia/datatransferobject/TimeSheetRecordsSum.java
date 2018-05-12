package com.wirelessmedia.datatransferobject;

import java.io.Serializable;
import java.util.List;

public class TimeSheetRecordsSum implements Serializable
{

    private static final long serialVersionUID = 8505886106097655599L;

    List<TimeSheetRecord> timeSheetRecords;

    Double sumOfWorkingHours;


    public TimeSheetRecordsSum()
    {
    }


    public List<TimeSheetRecord> getTimeSheetRecords()
    {
        return timeSheetRecords;
    }


    public void setTimeSheetRecords(List<TimeSheetRecord> timeSheetRecords)
    {
        this.timeSheetRecords = timeSheetRecords;
    }


    public Double getSumOfWorkingHours()
    {
        return sumOfWorkingHours;
    }


    public void setSumOfWorkingHours(Double sumOfWorkingHours)
    {
        this.sumOfWorkingHours = sumOfWorkingHours;
    }
}
