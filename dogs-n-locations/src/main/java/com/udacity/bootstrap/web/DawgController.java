package com.udacity.bootstrap.web;

import com.udacity.bootstrap.entity.Dawg;
import com.udacity.bootstrap.entity.Location;
import com.udacity.bootstrap.repository.DawgRepository;
import com.udacity.bootstrap.service.DawgService;
import com.udacity.bootstrap.service.LocationService;
import com.udacity.bootstrap.service.DogNotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
public class DawgController {

    @Autowired
    private DawgService dawgService;
    private DawgRepository dawgRepository;

    /*
    public void setDawgService(DawgService dawgService) {
        this.dawgService = dawgService;
    }

     */



    @GetMapping("/dawg")
    public ResponseEntity<List<Dawg>> getAllDawgs() {
        List<Dawg> liste = dawgService.retrieveDawgs();
        return new ResponseEntity<List<Dawg>>(liste, HttpStatus.OK);
    }

    @GetMapping("/dawg/names")
    public ResponseEntity<List<String>> getAllNames() {
        List<String> liste = dawgService.retrieveDogNames();
        return new ResponseEntity<List<String>>(liste, HttpStatus.OK);
    }

    @GetMapping("/dawg/onlynames")
    public ResponseEntity<List<String>> eifachoepis2() {
        List<String> liste = dawgService.retrieveOnlyDogNames();
        return new ResponseEntity<List<String>>(liste, HttpStatus.OK);
    }

    @GetMapping("/dawg/onlybreedsdistinct")
    public ResponseEntity<List<String>> eifachoepis3() {

        List<String> liste = dawgService.retrieveDogBreed();
        List<String> newList = new ArrayList<String>(new HashSet<String>(liste));
        return new ResponseEntity<List<String>>(newList, HttpStatus.OK);

    }

    @GetMapping("/dawg/breedbyid={id}")
    public ResponseEntity<String> eifachoepis4(@PathVariable Long id) {
        String liste = dawgService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(liste, HttpStatus.OK);
    }


}
