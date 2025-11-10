package org.map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Answer {
    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;

    /*************************************************************************
     * Bi-directional Mapping                                                *
     * the mappedBy field does not allow creation of another join col in the *
     * Answer Schema                                                         *
     *************************************************************************/
    @OneToOne(mappedBy = "answer")
    private Question question;

    public Answer() {
    }

    public Answer(int answerId, String answer, Question question) {
        this.answerId = answerId;
        this.answer = answer;
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
