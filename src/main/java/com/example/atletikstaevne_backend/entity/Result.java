package com.example.atletikstaevne_backend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name="result_value")
    private String resultValue;

    @ManyToOne
    @JoinColumn(name = "contestant_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Contestant contestant;

    @ManyToOne
    @JoinColumn(name = "discipline_id", referencedColumnName = "id")
    private Discipline discipline;

    public String getResultType(){
        return discipline.getResultType();
    }
}
