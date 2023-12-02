package com.example.postgresdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.postgresdemo.model.NguoiDung;

public interface NguoiDungDAO extends JpaRepository<NguoiDung, String> {
	NguoiDung findByEmail(String email);

	boolean existsByEmail(String email);

	boolean existsById(String Id);

	NguoiDung findByEmailOrIdND(String email, String idND);

	@Transactional
	@Modifying
	@Query("UPDATE NguoiDung n SET n.matKhau = :newmatKhau WHERE n.idND = :idND")
	void updatePassword(@Param("idND") String idND, @Param("newmatKhau") String newmatKhau);

}