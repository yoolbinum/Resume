package com.example.demo.Controllers;

import com.example.demo.Models.Skill;
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
public class SkillController {
    @Autowired
    SkillRepository skillRepository;

    final private String skillDir = "/skill/";

    @RequestMapping(skillDir)
    public String skillList(Model model){
        model.addAttribute("skills", skillRepository.findAll());
        return skillDir + "list";
    }

    @GetMapping(skillDir + "add")
    public String skillForm(Model model){
        model.addAttribute("skill", new Skill());
        return skillDir + "form";
    }

    @PostMapping(skillDir + "process")
    public String processForm(@Valid Skill skill, BindingResult result){
        if(result.hasErrors()){
            return skillDir + "form";
        }
        skillRepository.save(skill);
        return "redirect:" + skillDir;
    }

    @RequestMapping(skillDir + "update/{id}")
    public String updateSkill(@PathVariable("id") long id, Model model){
        model.addAttribute("skill", skillRepository.findOne(id));
        return skillDir+ "form";
    }

    @RequestMapping(skillDir + "delete/{id}")
    public String skillDelete(@PathVariable("id") long id) {
        skillRepository.delete(id);
        return "redirect:" + skillDir;
    }
}

