package com.example.postgresdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NguoiDungService {

    private final NguoiDungDAO nguoiDungRepository;

    @Autowired
    public NguoiDungService(NguoiDungDAO nguoiDungRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
    }

    public void updatePassword(String idND, String newmatKhau) {
        nguoiDungRepository.updatePassword(idND, newmatKhau);
    }
}
