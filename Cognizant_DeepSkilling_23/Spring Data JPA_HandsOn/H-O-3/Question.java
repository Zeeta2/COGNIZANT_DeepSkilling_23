package com.cognizant.ormlearn.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qu_id")
    private int id;

    @Column(name = "qu_text")
    private String text;

    @Column(name = "qu_score")
    private double score;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private Set<Option> optionList;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private Set<AttemptQuestion> attemptQuestionList;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Set<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(Set<Option> optionList) {
        this.optionList = optionList;
    }

    public Set<AttemptQuestion> getAttemptQuestionList() {
        return attemptQuestionList;
    }

    public void setAttemptQuestionList(Set<AttemptQuestion> attemptQuestionList) {
        this.attemptQuestionList = attemptQuestionList;
    }
}