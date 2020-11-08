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
@Table(name="hod")
public class Hod {

    @Id
    private String hodId;
    private String title;
    private String hodName;
    private int tpNo;
    private String mail;
    private String departmentId;
    
    
    public Login getLogin() { return login; }

    public void setLogin(Login login) { this.login = login; }

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name ="loginId", nullable = false)
    private Login login;

    public String getHodId() { return hodId; }

    public void setHodId(String hodId) { this.hodId = hodId; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getHodName() { return hodName; }

    public void setHodName(String hodName) { this.hodName = hodName; }

    public int getTpNo() { return tpNo; }

    public void setTpNo(int tpNo) { this.tpNo = tpNo; }

    public String getMail() { return mail; }

    public void setMail(String mail) { this.mail = mail; }

    public String getDepartmentId() { return departmentId; }

    public void setDepartmentId(String departmentId) { this.departmentId = departmentId; }
}
