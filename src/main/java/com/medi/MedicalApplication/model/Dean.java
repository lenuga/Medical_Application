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
@Table(name="dean")
public class Dean {

    @Id
    private String deanId;
    private String title;
    private String deanName;
    private String mail;
    private Integer tpNo;

    public String getDeanId() {
        return deanId;
    }

    public void setDeanId(String deanId) {
        this.deanId = deanId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeanName() {
        return deanName;
    }

    public void setDeanName(String deanName) {
        this.deanName = deanName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getTpNo() {
        return tpNo;
    }

    public void setTpNo(Integer tpNo) {
        this.tpNo = tpNo;
    }

}
