package de.marie.eventboard.exception;

public class EventNotFoundException extends RuntimeException{

    public EventNotFoundException(String guid){
        super("Could not find event with guid: " + guid);
    }
}
