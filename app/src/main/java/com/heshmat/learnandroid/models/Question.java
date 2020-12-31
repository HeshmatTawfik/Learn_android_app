package com.heshmat.learnandroid.models;

public class Question {
    private int id;
    private int topicID;
    private String question;
    private String answers; //will be separated by,
    private String correctChoice;

    public Question(String question, String answers, String correctChoice) {
        this.question = question;
        this.answers = answers;
        this.correctChoice = correctChoice;
    }

    public Question(int topicID, String question, String answers) {
        this.topicID = topicID;
        this.question = question;
        this.answers = answers;
    }

    public Question(int id, String question, String answers, String correctChoice, int topicID) {
        this.id = id;
        this.topicID = topicID;
        this.question = question;
        this.answers = answers;
        this.correctChoice = correctChoice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getCorrectChoice() {
        return correctChoice;
    }

    public void setCorrectChoice(String correctChoice) {
        this.correctChoice = correctChoice;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", topicID=" + topicID +
                ", question='" + question + '\'' +
                ", answers='" + answers + '\'' +
                ", correctChoice='" + correctChoice + '\'' +
                '}';
    }
}
