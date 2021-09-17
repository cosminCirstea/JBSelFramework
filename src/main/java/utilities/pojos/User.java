package utilities.pojos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.LocalDateTime;

public class User {
    @JsonProperty("name")
    public String name;
    @JsonProperty("job")
    public String job;
    @JsonProperty("id")
    public String id;
    @JsonProperty("createdAt")
    public String createdAt;

    public User(String name, String job) {
        setName(name);
        setJob(job);
    }

    public User() {
    }

    @JsonGetter
    public String getName() {
        return name;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter
    public String getJob() {
        return job;
    }

    @JsonSetter
    public void setJob(String job) {
        this.job = job;
    }

    @JsonGetter
    public String getId() {
        return id;
    }

    @JsonSetter
    public void setId(String id) {
        this.id = id;
    }

    @JsonGetter
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonSetter
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
