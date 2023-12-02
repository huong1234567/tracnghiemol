package com.example.postgresdemo.model;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "ketQua")
public class KetQua {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	@Column(name = "image_data", columnDefinition = "VARBINARY(MAX)")
	private byte[] imageData;
=======
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
	@Column(columnDefinition = "nvarchar(255)")
	String idBaiThi;
	@Column(columnDefinition = "nvarchar(255)")
	String diem;
	@Column(columnDefinition = "nvarchar(255)")
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
>>>>>>> 607c2686262ffd24ca57f232767c020fceb2d051

	public KetQua() {
	}

<<<<<<< HEAD
	public KetQua(Long id, byte[] imageData) {
		this.id = id;
		this.imageData = imageData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

=======
>>>>>>> 607c2686262ffd24ca57f232767c020fceb2d051
}
