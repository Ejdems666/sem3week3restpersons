package org.cba.sem3.exception;

import com.google.gson.JsonObject;

/**
 * Created by adam on 08/09/2017.
 */
public class ExceptionFactory {
    public static PersonNotFound createNotFound(int id) {
        JsonObject message = new JsonObject();
        message.addProperty("error","Person with id "+id+" was not found!");
        return new PersonNotFound(message.toString());
    }
}
