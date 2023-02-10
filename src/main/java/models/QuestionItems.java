package models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_question_item")
public class QuestionItems {
    @Id//первинний ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY)// авто інкремент по ключу, коли додається новий запис
    private int id;

    @Column(nullable = false, length = 500)
    private String text;

    @Column(name = "is_true")
    private boolean isTrue;

    @ManyToOne(fetch = FetchType.LAZY)//зв'язок багато до одного
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)//зв'язок один до багатьох
    private List<QuestionItems> questionItems;//список питань

    //конструктор для класа
    public QuestionItems(Question question, String text, boolean isTrue) {
        this.text = text;
        this.question = question;
        this.isTrue = isTrue;
    }

    public QuestionItems() {
    }
}
