package edu.drexel.ws.model;


import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Created with IntelliJ IDEA.
 * User: bsmitc
 * Date: 10/7/13
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */

@JsonInclude(Include.NON_NULL)
public class Publications {

    private Collection<Publication> publications = null;
    private RequestError error;

    public RequestError getError() {
        return error;
    }

    public void setError(RequestError error) {
        this.error = error;
    }

    public Collection<Publication> getPublications() {
        return publications;
    }

    public void setPublications(Collection<Publication> publications) {
        this.publications = publications;
    }
}
