package com.example.postgresdemo.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.postgresdemo.model.KetQua;
import com.example.postgresdemo.service.KetQuaService;

@Controller
@RequestMapping("/api/screenshots")
public class ketQuaController {

    @Autowired
    private KetQuaService screenshotService;

    @PostMapping
    public ResponseEntity<String> uploadScreenshot(@RequestBody String imageData) {
        try {
            Long screenshotId = screenshotService.saveScreenshot(imageData).getId();
            String imagePath = "/api/screenshots/" + screenshotId;
            return ResponseEntity.ok(imagePath);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading screenshot");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ByteArrayResource> getScreenshot(@PathVariable Long id) {
        KetQua screenshot = screenshotService.getScreenshotById(id);
        if (screenshot != null) {
            ByteArrayResource resource = new ByteArrayResource(screenshot.getImageData());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + id + ".png")
                    .contentType(MediaType.IMAGE_PNG)
                    .contentLength(screenshot.getImageData().length)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
