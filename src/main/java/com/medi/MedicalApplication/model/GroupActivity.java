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
@Table(name="groupactivity")
public class GroupActivity {

    @Id
    private Long groupActivityId;
    private int groupActivityNo;
    private int medicalId;

}
