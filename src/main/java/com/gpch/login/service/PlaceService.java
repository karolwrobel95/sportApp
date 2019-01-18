package com.gpch.login.service;

import com.gpch.login.model.Place;
import com.gpch.login.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> getPlacesList(){
        return placeRepository.findAllByVerifiedIsTrue();
    }
}
