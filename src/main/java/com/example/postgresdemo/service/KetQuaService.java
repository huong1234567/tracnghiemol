package com.example.postgresdemo.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.dao.KetQuaDAO;
import com.example.postgresdemo.model.KetQua;

@Service
public class KetQuaService {

    @Autowired
    private KetQuaDAO screenshotRepository;

    public KetQua getScreenshotById(Long id) {
        return screenshotRepository.findById(id).orElse(null);
    }

    public KetQua saveScreenshot(String imageData) {
        KetQua screenshot = new KetQua();

        try {
            byte[] imageDataBytes = Base64.getDecoder().decode(imageData.split(",")[1]);
            screenshot.setImageData(imageDataBytes);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid Base64 string");
        }

        return screenshotRepository.save(screenshot);
    }
}
