package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
import java.util.Set;
@Entity
@Table(name="attempt_question")
public class AttemptQuestion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="aq_id") private int id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="aq_at_id")
    private QuizAttempt attempt;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="aq_qn_id")
    private QuizQuestion question;
    
    @OneToMany(mappedBy="attemptQuestion", fetch=FetchType.EAGER)
    private Set<AttemptOption> attemptOptions;

    public AttemptQuestion() {}
    public int getId() { return id; }
    public QuizQuestion getQuestion() { return question; }
    public Set<AttemptOption> getAttemptOptions() { return attemptOptions; }
}