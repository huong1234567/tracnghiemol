package com.example.postgresdemo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

@Entity
@Table(name = "monHoc")
@Service
public class MonHoc implements Serializable {
    @Id
    String id;
    @Column(columnDefinition = "nvarchar(255)")
    String tenMonHoc;
    @Column(columnDefinition = "nvarchar(255)")
    String hinhAnh;
    String thoigian;
    @Column(columnDefinition = "nvarchar(255)")
    String filemon;

    @ManyToOne
    @JoinColumn(name = "idBan")
    Ban Ban;

    @OneToMany(mappedBy = "monHoc")
    List<BaiThi> baiThi;

    @OneToMany(mappedBy = "monHoc")
    List<BoDe> boDe;

    public MonHoc() {
    }

    public MonHoc(String id, String tenMonHoc, String hinhAnh, String thoigian, String filemon,
            com.example.postgresdemo.model.Ban ban,
            List<BaiThi> baiThi, List<BoDe> boDe) {
        this.id = id;
        this.tenMonHoc = tenMonHoc;
        this.hinhAnh = hinhAnh;
        this.thoigian = thoigian;

        Ban = ban;

        this.baiThi = baiThi;
        this.boDe = boDe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public Ban getBan() {
        return Ban;
    }

    public void setBan(Ban ban) {
        Ban = ban;
    }

    public List<BaiThi> getBaiThi() {
        return baiThi;
    }

    public void setBaiThi(List<BaiThi> baiThi) {
        this.baiThi = baiThi;
    }

    public List<BoDe> getBoDe() {
        return boDe;
    }

    public void setBoDe(List<BoDe> boDe) {
        this.boDe = boDe;
    }

    public String getFilemon() {
        return filemon;
    }

    public void setFilemon(String filemon) {
        this.filemon = filemon;
    }

}
