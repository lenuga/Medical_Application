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
@Table(name="admin")
public class Admin {

    @Id
    private Long adminId;
    private String mail;
    
    public Login getLogin() { return login; }

    public void setLogin(Login login) { this.login = login; }

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name ="loginId", nullable = false)
    private Login login;
}
