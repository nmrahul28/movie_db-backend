package com.example.moviedb.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.moviedb.model.UserFavouriteModel;
import com.example.moviedb.model.UserId;

public interface UserDao extends CrudRepository<UserFavouriteModel,UserId> {
	public List<UserFavouriteModel> findByemailId(String emailId);
}
