package com.gpch.login.controller


import com.gpch.login.dto.PlaceAddDTO
import com.gpch.login.repository.PlaceRepository
import com.gpch.login.service.PlaceService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@Controller
@RequestMapping("/places/")
class PlaceController(
        private val placeService: PlaceService,
        private val placeRepository: PlaceRepository
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

    fun addPlace(@Valid @ModelAttribute placeAddDTO: PlaceAddDTO, result: BindingResult): String {
        placeService.verifyAndSavePlace(placeAddDTO, result)
        return if(result.hasErrors())
            "place_add"
        else
            "redirect:../list/"
    }


    @PostMapping("/verify/{id}")
    fun verify(@PathVariable id : String)  {
        val selectedPlace = placeRepository.findById(id.toInt()).get()
        selectedPlace.verified = true

    }
}
