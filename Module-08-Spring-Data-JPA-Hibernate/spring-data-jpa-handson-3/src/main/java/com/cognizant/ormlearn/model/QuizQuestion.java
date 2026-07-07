package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
import java.util.Set;
@Entity
@Table(name="quiz_question")
public class QuizQuestion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="qn_id") private int id;
    @Column(name="qn_text") private String text;
    @OneToMany(mappedBy="question", fetch=FetchType.EAGER) private Set<QuizOption> optionsList;
    public QuizQuestion() {}
    public int getId() { return id; }
    public String getText() { return text; }
    public Set<QuizOption> getOptionsList() { return optionsList; }
}