package com.example.postgresdemo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.postgresdemo.dao.BoDeDAO;
import com.example.postgresdemo.dao.MonHocDAO;
import com.example.postgresdemo.dao.NguoiDungDAO;
import com.example.postgresdemo.dao.SessionService;
import com.example.postgresdemo.model.BoDe;
import com.example.postgresdemo.model.MonHoc;
import com.example.postgresdemo.model.NguoiDung;

@Controller
public class controller {
    @Autowired
    SessionService session;

    @Autowired
    NguoiDung nd;

    @Autowired
    MonHocDAO mhdao;

    @Autowired
    BoDeDAO bddao;

    @Autowired
    NguoiDungDAO nddao;
    @Autowired
    BoDe bd;

    @RequestMapping("/quizls")
    public String quizls() {
        return "quizls";
    }

    @RequestMapping("/quiz")
    public String quiz(Model model) {
        addMonHocListToModel(model);
        return "quiz";
    }

    private void addMonHocListToModel(Model model) {
        List<MonHoc> monHocList = mhdao.findAll();
        model.addAttribute("monHocList", monHocList);
    }

    @RequestMapping("/bodethi/{idMon}")
    public String showBoDeThi(@PathVariable String idMon, Model model) {
        List<BoDe> boDeList = bddao.findByMonHoc_Id(idMon);
        model.addAttribute("boDeList", boDeList);
        addMonHocListToModel(model);
        return "dethi";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        addMonHocListToModel(model);
        return "index";
    }

    @RequestMapping("/listdethi")
    public String showlistdethi(Model model) {
        List<BoDe> boDeList = bddao.findAll();
        model.addAttribute("boDeList", boDeList);
        addMonHocListToModel(model);
        return "dethi";
    }

    @RequestMapping("/xacnhan")
    public String showBatdauthi(Model model) {
        return "xacnhan";
    }

    // Search and Pagination

    @RequestMapping("/listdethi/search")
    public String searchAndPage(Model model,
            @RequestParam("keywords") Optional<String> kw) {
        String kwords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", kwords);
        // Pageable pageable = PageRequest.of(p.orElse(0), 6);
        List<BoDe> items = bddao.findAllByTenDeLike("%" + kwords + "%");
        model.addAttribute("search", items);
        addMonHocListToModel(model);
        return "listdethi";
    }

    @RequestMapping("/bodethi")
    public String bodethi() {
        return "bodethi";
    }

    @RequestMapping("/indexAd")
    public String index1() {
        return "indexAd";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/dangxuat")
    public String logout(HttpSession session) {
        session.removeAttribute("tenNguoiDung");
        return "login";
    }

    @RequestMapping("/lienhe")
    public String lienhe() {
        return "lienhe";
    }

    @RequestMapping("/gioithieu")
    public String about() {
        return "gioithieu";
    }

    @RequestMapping("/gopy")
    public String gopy() {
        return "gopy";
    }

    @PostMapping("/login")
    public String session(@RequestParam("emailOrId") String emailOrId,
            @RequestParam("matKhau") String matKhau,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            Model model) {

        NguoiDung user = nddao.findByEmailOrIdND(emailOrId, emailOrId);

        if (user != null && user.getMatKhau().equals(matKhau)) {
            session.setAttribute("user", user.getHoTen());
            session.setAttribute("nguoidung", user);
            if (user.isAdmin()) {
                return "redirect:/indexAd";
            } else {
                return "redirect:/index";
            }
        } else {
            model.addAttribute("error", "Email hoặc mật khẩu không đúng");
            return "login";
        }
    }

    @GetMapping("/dangky")
    public String dangky() {
        return "register";
    }

    @PostMapping("/dangky")
    public String processRegistration(@RequestParam String idND, @RequestParam String rematKhau,
            @RequestParam String sdt,
            @RequestParam String hoTen, @RequestParam String email, @RequestParam String matKhau, Model model) {
        if (nddao.existsByEmail(email)) {
            model.addAttribute("error", "Email này đã tồn tại");
            return "register";
        } else {
            if (nddao.existsById(idND)) {
                model.addAttribute("error", "Tên người dùng này đã tồn tại");
                return "register";
            } else {

                if (matKhau.equals(rematKhau)) {
                    NguoiDung newUser = new NguoiDung();
                    newUser.setHoTen(hoTen);
                    newUser.setIdND(idND);
                    newUser.setEmail(email);
                    newUser.setMatKhau(matKhau);
                    newUser.setSoDienThoai(sdt);
                    nddao.save(newUser);
                    return "redirect:/login"; // Chuyển hướng về trang đăng nhập sau khi đăng ký thành công
                } else {
                    model.addAttribute("error", "Mật khẩu không trùng");
                    return "register";
                }
            }
        }
    }

}
