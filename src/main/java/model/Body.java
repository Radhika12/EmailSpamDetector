package model;

import java.util.List;

/**
 * Created by ryadav on 2017-10-28.
 */
public class Body {

    private String type;

    private List<BodyPart> parts;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<BodyPart> getParts() {
        return parts;
    }

    public void setParts(List<BodyPart> parts) {
        this.parts = parts;
    }
}
