package com.gpch.login.controller


import com.gpch.login.dto.PlaceAddDTO
import com.gpch.login.service.PlaceService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@Controller
@RequestMapping("/places/")
class PlaceController(
        private val placeService: PlaceService
) {

    @GetMapping("/list/")
    fun placeList(model: Model): String {
        val placesList = placeService.placesList()
        println("PlaceList: $placesList")
        model.addAttribute("placeList",placesList )

        return "place_list"
    }

    @GetMapping("/verify_place_list/")
    fun verifyPlaceList(model: Model): String {
        val placesList = placeService.getPlacesToVerify()
        println("PlaceList: $placesList")
        model.addAttribute("placeList",placesList )

        return "admin/verify_place_list"
    }

    @GetMapping("/add/")
    fun showAddPlaceForm(@ModelAttribute placeAddDTO: PlaceAddDTO): String {
        return "place_add"
    }

    @PostMapping("/add/")
    fun addPlace(@Valid @ModelAttribute placeAddDTO: PlaceAddDTO, result: BindingResult): String {
        placeService.verifyAndSavePlace(placeAddDTO, result)
        return if(result.hasErrors())
            "place_add"
        else
            "redirect:../list/"
    }


    @RequestMapping("/verify_place_list/")
    fun registration(@ModelAttribute placeAddDTO: PlaceAddDTO) : String {
        placeAddDTO.verified = true
        return "verify_place_list"
    }
}
