package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
@Table(name="quiz_attempt")
public class QuizAttempt {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="at_id") private int id;
    @Column(name="at_date") private Date date;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="at_us_id")
    private QuizUser user;
    
    @OneToMany(mappedBy="attempt", fetch=FetchType.EAGER)
    private Set<AttemptQuestion> attemptQuestions;

    public QuizAttempt() {}
    public int getId() { return id; }
    public Date getDate() { return date; }
    public QuizUser getUser() { return user; }
    public Set<AttemptQuestion> getAttemptQuestions() { return attemptQuestions; }
}