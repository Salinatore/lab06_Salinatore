package it.unibo.exceptions.exceptions;

import java.io.IOException;

public class NetworkException extends IOException{

    public NetworkException() {
        super("Network error: no response");
    }

    public NetworkException(String arg) {
        super("Network error: " + arg);
    }
    
}
