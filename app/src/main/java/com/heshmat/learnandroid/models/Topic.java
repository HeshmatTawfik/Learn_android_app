package com.heshmat.learnandroid.models;

import java.util.List;

public class Topic {
    private int id;
    private String title;
    private String content;
    private String level;
    private List<Question> exercise;
    private int status;  // 0 for not completed 1 for completed

    public Topic(String title, String content, String level, int status) {
        this.title = title;
        this.content = content;
        this.level = level;
        this.status = status;
    }

    public Topic(int id, String title, String content, String level, int status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.level = level;
        this.status = status;
    }

    public Topic(int id, String title, String content, String level,  int status,List<Question> exercise) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.level = level;
        this.exercise = exercise;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Question> getExercise() {
        return exercise;
    }

    public void setExercise(List<Question> exercise) {
        this.exercise = exercise;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
