package models;

import enums.QuestionType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_questions")//назва таблиці в базі
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="text",nullable = false,length = 500)
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name = "question_type")
    private QuestionType questionType;


}