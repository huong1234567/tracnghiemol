package com.example.postgresdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postgresdemo.model.Ban;

public interface BanDAO extends JpaRepository<Ban, String> {

}
