package org.map;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Courses
{
    @Id
    private int course_id;
    private String course_name;
    private List<String> subjects;
    @ManyToOne
    @JoinColumn(name = "stream_id")
    private Streams stream;

    /****************
     * Constructors *
     ****************/
    public Courses(int course_id, String course_name, List<String> subjects, Streams stream) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.subjects = subjects;
        this.stream = stream;
    }

    public Courses() {
    }

    /*******************************
     * Getters and Setters methods *
     *******************************/
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Streams getStream() {
        return stream;
    }

    public void setStream(Streams stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", subjects=" + subjects +
                ", stream=" + ((stream != null) ? stream.getStreamId() : null) +
                '}';
    }
}
