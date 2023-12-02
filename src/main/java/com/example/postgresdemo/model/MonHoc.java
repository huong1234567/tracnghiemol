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
<<<<<<< HEAD
=======
    List<KetQua> baiThi;

    @OneToMany(mappedBy = "monHoc")
>>>>>>> 607c2686262ffd24ca57f232767c020fceb2d051
    List<BoDe> boDe;

    public MonHoc() {
    }

    public MonHoc(String id, String tenMonHoc, String hinhAnh, String thoigian, String filemon,
<<<<<<< HEAD
            com.example.postgresdemo.model.Ban ban, List<BoDe> boDe) {
=======
            com.example.postgresdemo.model.Ban ban,
            List<KetQua> baiThi, List<BoDe> boDe) {
>>>>>>> 607c2686262ffd24ca57f232767c020fceb2d051
        this.id = id;
        this.tenMonHoc = tenMonHoc;
        this.hinhAnh = hinhAnh;
        this.thoigian = thoigian;

        Ban = ban;

<<<<<<< HEAD
=======
        this.baiThi = baiThi;
>>>>>>> 607c2686262ffd24ca57f232767c020fceb2d051
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

<<<<<<< HEAD
=======
    public List<KetQua> getBaiThi() {
        return baiThi;
    }

    public void setBaiThi(List<KetQua> baiThi) {
        this.baiThi = baiThi;
    }

>>>>>>> 607c2686262ffd24ca57f232767c020fceb2d051
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
