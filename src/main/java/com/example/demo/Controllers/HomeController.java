package com.example.demo.Controllers;

import com.example.demo.Repositories.EducationRepository;
import com.example.demo.Repositories.ExperienceRepository;
import com.example.demo.Repositories.ResumeRepository;
import com.example.demo.Repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String homePage(){
        return "index";
    }
}
