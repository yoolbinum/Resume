package com.example.demo.Controllers;

import com.example.demo.Repositories.EducationRepository;
import com.example.demo.Repositories.ExperienceRepository;
import com.example.demo.Repositories.ResumeRepository;
import com.example.demo.Repositories.SkillRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    /*
    ResumeRepository resumeRepository = ResumeController.getResumeRepository();
    EducationRepository educationRepository = EducationController.educationRepository;
    ExperienceRepository experienceRepository = ExperienceController.experienceRepository;
    SkillRepository skillRepository = SkillController.skillRepository;
*/


    @RequestMapping("/")
    public String homePage(){
        return "index";
    }
/*
    @RequestMapping("/view")
    public String viewResume(Model model){
        model.addAttribute("resumes", resumeRepository.findAll());
        model.addAttribute("experiences", experienceRepository.findAll());
        model.addAttribute("educations", educationRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());

        return "view";
    }
*/
}
