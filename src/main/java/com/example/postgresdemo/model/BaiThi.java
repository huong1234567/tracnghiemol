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
@Table(name = "baiThi")
@Service
public class BaiThi implements Serializable {

	@Id
	@Column(columnDefinition = "nvarchar(255)")
	String idBaiThi;
	@Column(columnDefinition = "nvarchar(255)")
	String tieuDe;
	@Column(columnDefinition = "nvarchar(255)")
	String cauHoi;
	@Column(columnDefinition = "nvarchar(255)")
	String loiGiai;

	@ManyToOne
	@JoinColumn(name = "idMon")
	MonHoc monHoc;

	@ManyToOne
	@JoinColumn(name = "idNguoiDung")
	NguoiDung nguoiDung;

	@OneToMany(mappedBy = "BaiThi")
	List<BaiThi> BaiThi;

	public BaiThi() {
	}

	public BaiThi(String idBaiThi, String tieuDe, String cauHoi, String loiGiai, MonHoc monHoc, NguoiDung nguoiDung,
			List<BaiThi> baiThi) {
		this.idBaiThi = idBaiThi;
		this.tieuDe = tieuDe;
		this.cauHoi = cauHoi;
		this.loiGiai = loiGiai;
		this.monHoc = monHoc;
		this.nguoiDung = nguoiDung;
		BaiThi = baiThi;
	}

	public String getIdBaiThi() {
		return idBaiThi;
	}

	public void setIdBaiThi(String idBaiThi) {
		this.idBaiThi = idBaiThi;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getCauHoi() {
		return cauHoi;
	}

	public void setCauHoi(String cauHoi) {
		this.cauHoi = cauHoi;
	}

	public String getLoiGiai() {
		return loiGiai;
	}

	public void setLoiGiai(String loiGiai) {
		this.loiGiai = loiGiai;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public List<BaiThi> getBaiThi() {
		return BaiThi;
	}

	public void setBaiThi(List<BaiThi> baiThi) {
		BaiThi = baiThi;
	}

}
