package main.java.blogpost;

import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties
public class UserPost {
    @JsonPropertyOrder({
            "id",
            "user_id",
            "title",
            "body"
    })

    @JsonProperty("id")
    private int id;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
 
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id + " \n" +
                ", userId=" + userId + " \n" +
                ", title='" + title + '\''  + " \n" +
                ", body='" + body + '\'' +  " \n" +
                ", additionalProperties=" + additionalProperties +
                '}' +
                " /n";
    }

}
