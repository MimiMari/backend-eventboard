package de.marie.eventboard.exception;

public class EventNotFoundException extends RuntimeException{

    public EventNotFoundException(String title){
        super("Could not find event with title: " + title);
    }
}
