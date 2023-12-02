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
@Table(name = "ketQua")
@Service
public class KetQua implements Serializable {

	@Id
	@Column(columnDefinition = "varchar(255)")
	String idBaiThi;
	@Column(columnDefinition = "varchar(255)")
	String diem;
	@Column(columnDefinition = "varchar(255)")
	String baithi;

	@ManyToOne
	@JoinColumn(name = "idMon")
	MonHoc monHoc;

	@ManyToOne
	@JoinColumn(name = "idNguoiDung")
	NguoiDung nguoiDung;

	public KetQua(String idBaiThi, String diem, String baithi) {
		this.idBaiThi = idBaiThi;
		this.diem = diem;
		this.baithi = baithi;
	}

	public String getIdBaiThi() {
		return idBaiThi;
	}

	public void setIdBaiThi(String idBaiThi) {
		this.idBaiThi = idBaiThi;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}

	public String getBaithi() {
		return baithi;
	}

	public void setBaithi(String baithi) {
		this.baithi = baithi;
	}

	public KetQua() {
	}

}
