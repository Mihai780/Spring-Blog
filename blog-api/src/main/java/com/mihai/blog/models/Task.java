package com.mihai.blog.models;

import jakarta.persistence.Entity;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
public class Task {
    private Long id;

    private String title;
    private LocalDateTime day;
    private boolean completed ;

    public Task(String title)
    {
        this.title = title;
        day = LocalDateTime.now();
        completed = false;
    }

    public Long GetId(){
        return id;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public LocalDateTime getDay()
    {
        return day;
    }

    public boolean getCompleted(){
        return completed;
    }
    public void setCompleted(boolean completed){
        this.completed=completed;
    }

}
