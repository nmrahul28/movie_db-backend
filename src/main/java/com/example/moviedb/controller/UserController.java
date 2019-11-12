package com.example.moviedb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviedb.model.UserFavouriteModel;
import com.example.moviedb.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userservice;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void add(@RequestBody UserFavouriteModel user) {
        userservice.add(user);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public List<UserFavouriteModel> getdata(@RequestParam(required = false) String email) {
        return userservice.getdata(email);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "/getmovie")
    public Optional<UserFavouriteModel> getMovie(@RequestParam String emailId, @RequestParam int movieId){
        return userservice.getMovie(emailId,movieId);
    }
}
