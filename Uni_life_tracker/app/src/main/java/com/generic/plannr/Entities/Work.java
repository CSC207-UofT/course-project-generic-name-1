package com.generic.plannr.Entities;

import androidx.annotation.NonNull;

import java.time.LocalDateTime;

/**
 * Represents a work event with a start date, end date and location.
 */
public class Work extends Event {
    private String location;

    /**
     * Constructs an com.generic.plannr.Entities.Work event, giving it the given name,
     * priority, start date, end date and location.
     *
     * @param name      The com.generic.plannr.Entities.Work's name
     * @param priority  The com.generic.plannr.Entities.Work's priority
     * @param startDate The com.generic.plannr.Entities.Work's start date
     * @param endDate   The com.generic.plannr.Entities.Work's end date
     * @param location  The com.generic.plannr.Entities.Work's location
     */
    public Work(String name, int priority, LocalDateTime startDate,
                LocalDateTime endDate, String location) {
        super(name, priority, startDate, endDate);
        this.location = location;
    }

    /**
     * Gets the location of the com.generic.plannr.Entities.Work event
     *
     * @return the location of the com.generic.plannr.Entities.Work event as a String object
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Changes the location of the work event
     *
     * @param location is the new location of the work event
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * toString method
     *
     * @return a String that describes the com.generic.plannr.Entities.Work event
     */
    @NonNull
    @Override
    public String toString() {
        String strPriority;
        if (this.getPriority() == 0) {
            strPriority = "high";
        } else if (this.getPriority() == 1) {
            strPriority = "mid";
        } else {
            strPriority = "low";
        }
        return String.format("Work (%s priority): Work (%s) at %s starts at %s and ends at %s",
                strPriority,
                this.getName(),
                this.getLocation(),
                this.getStartDate().format(DATEFORMAT),
                this.getEndDate().format(DATEFORMAT));
    }
}