package com.example.postgresdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postgresdemo.model.BinhLuan;

public interface BinhLuanDAO extends JpaRepository<BinhLuan, String> {

}
