package com.example.demo.Controllers;

import com.example.demo.Models.Resume;
import com.example.demo.Repositories.EducationRepository;
import com.example.demo.Repositories.ExperienceRepository;
import com.example.demo.Repositories.ResumeRepository;
import com.example.demo.Repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ResumeController {

    @Autowired
    ResumeRepository resumeRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    SkillRepository skillRepository;


    final private String resumeDir = "/resume/";

    @RequestMapping(resumeDir)
    public String resumesList(Model model){
        model.addAttribute("resumes", resumeRepository.findAll());
        return resumeDir + "list";
    }

    @GetMapping(resumeDir + "add")
    public String resumeForm(Model model){
        model.addAttribute("resume", new Resume());
        return resumeDir + "form";
    }

    @PostMapping(resumeDir + "process")
    public String processForm(@Valid Resume resume, BindingResult result){
        if(result.hasErrors()){
            return resumeDir + "form";
        }
        resumeRepository.save(resume);
        return "redirect:" + resumeDir;
    }

    @RequestMapping(resumeDir + "detail/{id}")
    public String showResume(@PathVariable("id") long id, Model model){
        model.addAttribute("resume", resumeRepository.findOne(id));
        return resumeDir+ "show";
    }

    @RequestMapping(resumeDir + "update/{id}")
    public String updateResume(@PathVariable("id") long id, Model model){
        model.addAttribute("resume", resumeRepository.findOne(id));
        return resumeDir+ "form";
    }

    @RequestMapping(resumeDir + "/view")
    public String viewResume(Model model){
        model.addAttribute("resumes", resumeRepository.findAll());
        model.addAttribute("experiences", experienceRepository.findAll());
        model.addAttribute("educations", educationRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());

        return resumeDir + "view";
    }
}
