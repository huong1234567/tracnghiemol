package com.example.postgresdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postgresdemo.model.BaiThi;

public interface BaiThiDAO extends JpaRepository<BaiThi, String> {

}
