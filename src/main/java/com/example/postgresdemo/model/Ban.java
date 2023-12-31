package com.example.postgresdemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

@Entity
@Table(name = "Ban")
@Service
public class Ban implements Serializable {
    @Id
    String idBan;
    @Column(columnDefinition = "nvarchar(255)")
    String tenBan;

    public Ban() {
    }

    public Ban(String idBan, String tenBan) {
        this.idBan = idBan;
        this.tenBan = tenBan;
    }

    public String getIdBan() {
        return idBan;
    }

    public void setIdBan(String idBan) {
        this.idBan = idBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

}
