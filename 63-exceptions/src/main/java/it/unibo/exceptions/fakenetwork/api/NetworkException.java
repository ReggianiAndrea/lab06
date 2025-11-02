package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;

public class NetworkException extends IOException{
    /*0-ary constructor */
    public NetworkException(){
        super("Network error: no response");
    }
    
    /*1-ary constructor */
    public NetworkException(final String message){
        super("Network error while sending message:"+message);
    }

}
