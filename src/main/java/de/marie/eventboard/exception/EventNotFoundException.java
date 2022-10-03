package de.marie.eventboard.exception;

public class EventNotFoundException extends RuntimeException{

    public EventNotFoundException(Long id){
        super("Could not find event with title: " + id);
    }
}
