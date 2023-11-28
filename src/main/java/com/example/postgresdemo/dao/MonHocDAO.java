package com.example.postgresdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postgresdemo.model.MonHoc;

public interface MonHocDAO extends JpaRepository<MonHoc, String> {

}
