package com.cognizant.ormlearn.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "attempt_question")
public class AttemptQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aq_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "at_id")
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name = "qu_id")
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion", fetch = FetchType.LAZY)
    private Set<AttemptOption> attemptOptionList;

    public AttemptQuestion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Attempt getAttempt() {
        return attempt;
    }

    public void setAttempt(Attempt attempt) {
        this.attempt = attempt;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Set<AttemptOption> getAttemptOptionList() {
        return attemptOptionList;
    }

    public void setAttemptOptionList(Set<AttemptOption> attemptOptionList) {
        this.attemptOptionList = attemptOptionList;
    }
}