package com.gpch.login.controller;


import com.gpch.login.model.Place;
import com.gpch.login.repository.PlaceRepository;
import com.gpch.login.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/places/")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping("/list/")
    public String placeList(Model model){
        model.addAttribute("places", placeService.getPlacesList());
        return "place_list";
    }

    @GetMapping("/add/")
    public String showAddPlaceForm(@ModelAttribute Place place, BindingResult result, Model  model){
        return "place_add";
    }

    @PostMapping("/add/")
    public String addPlace(@Valid @ModelAttribute Place place, BindingResult result, Model  model){
        System.out.println("Dodalem miejsce");
        return "place_add";
    }
}
