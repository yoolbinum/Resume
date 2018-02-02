package com.example.demo.Controllers;

import com.example.demo.Models.Experience;
import com.example.demo.Repositories.ExperienceRepository;
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
public class ExperienceController {
    @Autowired
    ExperienceRepository experienceRepository;

    final private String experienceDir = "/experience/";

    @RequestMapping(experienceDir)
    public String experienceList(Model model){
        model.addAttribute("experiences", experienceRepository.findAll());
        return experienceDir + "list";
    }

    @GetMapping(experienceDir + "add")
    public String experienceForm(Model model){
        model.addAttribute("experience", new Experience());
        return experienceDir + "form";
    }

    @PostMapping(experienceDir + "process")
    public String processForm(@Valid Experience experience, BindingResult result){
        if(result.hasErrors()){
            return experienceDir + "form";
        }
        experienceRepository.save(experience);
        return "redirect:" + experienceDir;
    }

    @RequestMapping(experienceDir + "update/{id}")
    public String updateExperience(@PathVariable("id") long id, Model model){
        model.addAttribute("experience", experienceRepository.findOne(id));
        return experienceDir+ "form";
    }

    @RequestMapping(experienceDir + "delete/{id}")
    public String experienceDelete(@PathVariable("id") long id) {
        experienceRepository.delete(id);
        return "redirect:" + experienceDir;
    }
}
