
package com.example.relational_mappings.OneToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "answers")
public class Answer {

    @Id
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;

    private String answer;

    @OneToOne(mappedBy = "answer")
    private Question question;

    public Answer(String answer) {
        this.answer = answer;
    }

}
