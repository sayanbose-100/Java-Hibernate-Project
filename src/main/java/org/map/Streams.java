package org.map;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Streams {
    @Id
    @Column(name = "stream_id")
    private String streamId;
    private String streamName;

    @OneToMany(mappedBy = "stream", cascade = CascadeType.ALL)
    private List<Courses> courses_provided;

    /****************
     * Constructors *
     ****************/
    public Streams(String streamName, String streamId, List<Courses> courses_provided) {
        this.streamName = streamName;
        this.streamId = streamId;
        this.courses_provided = courses_provided;
    }
    public Streams() {
    }

    /***********************
     * Getters and setters *
     ***********************/
    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public List<Courses> getCourses_provided() {
        return courses_provided;
    }

    public void setCourses_provided(List<Courses> courses_provided) {
        this.courses_provided = courses_provided;
    }

    @Override
    public String toString() {
        return "Streams{" +
                "streamId='" + streamId + '\'' +
                ", streamName='" + streamName + '\'' +
                '}';
    }
}
