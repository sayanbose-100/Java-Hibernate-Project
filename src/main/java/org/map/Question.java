package org.map;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

@Entity
public class Question {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;

    /*****************************
     * Creating a One to One Map *
     *****************************/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "a_id")
    private Answer answer;

    public Question() {
    }

    public Question(int questionId, String question, Answer answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
