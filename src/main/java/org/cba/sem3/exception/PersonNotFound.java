package org.cba.sem3.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by adam on 05/09/2017.
 */
public class PersonNotFound extends WebApplicationException {

    public PersonNotFound(String message) {
        super(Response.status(Response.Status.NOT_FOUND)
                .entity(message)
                .type(MediaType.APPLICATION_JSON).build());
    }
}
