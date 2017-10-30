package model;

import java.util.List;

/**
 * Created by ryadav on 2017-10-28.
 */
public class Email {

    private List<Header> headers;

    private String from;

    private Body body;

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
