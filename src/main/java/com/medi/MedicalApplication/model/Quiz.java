package com.medi.MedicalApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="quiz")
public class Quiz {

    @Id
    private Long quizId;
    private int quizNo;
    private int medicalId;

}
