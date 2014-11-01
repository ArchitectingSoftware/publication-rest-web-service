package edu.drexel.ws.model;

/**
 * Created by bsmitc on 11/1/14.
 */
public class RequestError
{

    public RequestError(){

    }

    public RequestError(int id, String msg)
    {
        this.code = id;
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private int code;
    private String message;
}
