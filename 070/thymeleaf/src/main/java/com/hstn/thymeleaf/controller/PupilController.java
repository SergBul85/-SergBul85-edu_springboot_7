package com.hstn.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PupilController {

    @RequestMapping("/showPupilForm")
    public String showPupilForm() {
        return "pupil-form";
    }

    @RequestMapping("/processPupilForm")
    public String processPupilForm() {
        return "pupil-info";
    }

    @RequestMapping("/processPupilFormV2")
    public String correctName(HttpServletRequest request, Model model) {
        String oldNameLowerCase = request.getParameter("pupilName").toLowerCase();
        String correctName = "";
        String[] words = oldNameLowerCase.split(" ");
        for (String word : words) {
            String firstLetter = word.substring(0, 1).toUpperCase();
            word = firstLetter + word.substring(1);
            correctName += word + " ";
        }
        correctName=correctName.trim();
        model.addAttribute("correctName", correctName);
        return "pupil-info";
    }

}
