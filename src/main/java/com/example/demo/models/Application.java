package com.example.demo.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by okten28 on 6/19/19.
 */

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Application {
    @Id
    @GeneratedValue
    int id;
    Date dateOfEvent;
    String nameOfTheCourse;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    User user;

    public Application() {
    }

    public Application(Date dateOfEvent, String nameOfTheCourse) {
        this.dateOfEvent = dateOfEvent;
        this.nameOfTheCourse = nameOfTheCourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(Date dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getNameOfTheCourse() {
        return nameOfTheCourse;
    }

    public void setNameOfTheCourse(String nameOfTheCourse) {
        this.nameOfTheCourse = nameOfTheCourse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Application)) return false;
        if (!super.equals(o)) return false;

        Application that = (Application) o;

        if (getId() != that.getId()) return false;
        if (getDateOfEvent() != null ? !getDateOfEvent().equals(that.getDateOfEvent()) : that.getDateOfEvent() != null)
            return false;
        return getNameOfTheCourse() != null ? getNameOfTheCourse().equals(that.getNameOfTheCourse()) : that.getNameOfTheCourse() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getId();
        result = 31 * result + (getDateOfEvent() != null ? getDateOfEvent().hashCode() : 0);
        result = 31 * result + (getNameOfTheCourse() != null ? getNameOfTheCourse().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", dateOfEvent=" + dateOfEvent +
                ", nameOfTheCourse='" + nameOfTheCourse + '\'' +
                '}';
    }
}
