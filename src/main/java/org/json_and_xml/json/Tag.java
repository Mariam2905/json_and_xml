package org.json_and_xml.json;


import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
public enum Tag {
    @SerializedName("oil")
    OIL("oil"),
    @SerializedName("watercolor")
    WATERCOLOR("watercolor"),
    @SerializedName("digital")
    DIGITAL("digital"),
    @SerializedName("famous")
    FAMOUS("famous");
    private final String value;
    private final static Map<String, Tag> CONSTANTS = new HashMap<String, Tag>();
    static {
        for (Tag c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }
    Tag(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return this.value;
    }
    public String value() {
        return this.value;
    }

    /**
     * Method check constant value.
     * @param value
     * @return
     */
    public static Tag fromValue(String value) {
        Tag constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}