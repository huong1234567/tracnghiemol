package com.example.postgresdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postgresdemo.model.NguoiDung;

public interface NguoiDungDAO extends JpaRepository<NguoiDung, String> {
	NguoiDung findByEmail(String email);

	boolean existsByEmail(String email);

	boolean existsById(String Id);

	NguoiDung findByEmailOrIdND(String email, String idND);

}
