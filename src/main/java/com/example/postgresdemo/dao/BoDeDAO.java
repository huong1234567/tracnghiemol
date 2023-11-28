package com.example.postgresdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postgresdemo.model.BoDe;

public interface BoDeDAO extends JpaRepository<BoDe, String> {
	List<BoDe> findByMonHoc_Id(String idMon);

	List<BoDe> findAllByTenDeLike(String keywords);

}
