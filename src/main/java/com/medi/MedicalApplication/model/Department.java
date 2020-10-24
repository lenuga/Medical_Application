package com.medi.MedicalApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="department")
public class Department {

    @Id
    @Column(name="pepartmentId")
    private String departmentId;
    private String departmentName;
    private String dShortName;
}
