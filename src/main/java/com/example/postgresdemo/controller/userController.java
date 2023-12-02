package com.example.postgresdemo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.postgresdemo.dao.NguoiDungDAO;
import com.example.postgresdemo.model.NguoiDung;

@Controller
public class userController {

    @Autowired
    NguoiDungDAO ndd;

    @GetMapping("/qlthongtin")
    public String showUserInfo(Model model, HttpSession session) {
        NguoiDung user = (NguoiDung) session.getAttribute("nguoidung");
        if (user == null) {
            // Lấy user id từ session hoặc từ bất kỳ nguồn dữ liệu nào khác
            String userId = (String) session.getAttribute("idND");
            if (userId != null) {
                user = ndd.findById(userId).orElse(null);
            }
        }
        if (user != null) {
            model.addAttribute("user", user);
            return "qlThongTin";
        } else {
            return "redirect:/login";
        }
    }

    // @PostMapping("/qlthongtin/update")
    // public String update(NguoiDung item, HttpSession session) {
    // String images = item.getImages();
    // // Nếu tên tệp tin mới không rỗng, cập nhật giá trị trong cơ sở dữ liệu
    // if (images != null && !images.isEmpty()) {
    // item.setImages(images);
    // }

    // ndd.save(item);
    // session.setAttribute("nguoidung", item);
    // session.setAttribute("user", item.getHoTen());
    // return "redirect:/qlthongtin";
    // }
    @PostMapping("/qlthongtin/update")
    public String update(@ModelAttribute("user") NguoiDung item,
            HttpSession session) {
        MultipartFile imagesFile = item.getImagesFile();
        // Xử lý tệp tin ảnh và lưu trữ tên vào đối tượng NguoiDung
        if (imagesFile != null && !imagesFile.isEmpty()) {
            try {
                String imageName = imagesFile.getOriginalFilename();
                // Lưu tên tệp tin vào trường images của đối tượng NguoiDung
                item.setImages(imageName);
                // Lưu tệp tin vào thư mục images (nếu cần)
                // ...
            } catch (Exception e) {
                e.printStackTrace();
                // Xử lý nếu có lỗi khi xử lý tệp tin
            }
        }

        // Lưu cập nhật vào cơ sở dữ liệu
        ndd.save(item);

        // Lưu thông tin người dùng vào session
        session.setAttribute("nguoidung", item);
        session.setAttribute("user", item.getHoTen());

        return "redirect:/qlthongtin";
    }
}
