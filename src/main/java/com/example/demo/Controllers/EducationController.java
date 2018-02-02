package com.example.demo.Controllers;

import com.example.demo.Models.Education;
import com.example.demo.Repositories.EducationRepository;
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
public class EducationController {
    @Autowired
    EducationRepository educationRepository;

    final private String educationDir = "/education/";

    @RequestMapping(educationDir)
    public String educationList(Model model){
        model.addAttribute("educations", educationRepository.findAll());
        return educationDir + "list";
    }

    @GetMapping(educationDir + "add")
    public String educationForm(Model model){
        model.addAttribute("education", new Education());
        return educationDir + "form";
    }

    @PostMapping(educationDir + "process")
    public String processForm(@Valid Education education, BindingResult result){
        if(result.hasErrors()){
            return educationDir + "form";
        }
        educationRepository.save(education);
        return "redirect:" + educationDir;
    }

    @RequestMapping(educationDir + "update/{id}")
    public String updateEducation(@PathVariable("id") long id, Model model){
        model.addAttribute("education", educationRepository.findOne(id));
        return educationDir+ "form";
    }

    @RequestMapping(educationDir + "delete/{id}")
    public String educationDelete(@PathVariable("id") long id) {
        educationRepository.delete(id);
        return "redirect:" + educationDir;
    }

}
