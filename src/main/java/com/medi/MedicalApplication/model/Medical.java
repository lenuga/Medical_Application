package com.medi.MedicalApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="medical")
public class Medical {

    @Id
    private Long medicalId;
    private String studentId;
    private Date startDate;
    private Date endDate;
    private Integer courseId;
    private Integer attendance;
    private Integer midExam;
    private Integer finalExam;
    private Integer groupActivityId;
    private Integer quizId;
    private Integer assignmentId;
    //private  image
    //private image



}
