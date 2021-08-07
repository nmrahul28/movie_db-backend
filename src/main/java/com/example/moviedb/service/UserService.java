package com.example.moviedb.service;

import java.util.List;
import java.util.Optional;

import com.example.moviedb.model.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviedb.Dao.UserDao;
import com.example.moviedb.model.UserFavouriteModel;

@Service
public class UserService {
	@Autowired
	private UserDao userdao;
	
	public void add(UserFavouriteModel user) {
		 userdao.save(user);
	}
	
	public List<UserFavouriteModel> getdata(String email){
		return (List<UserFavouriteModel>) userdao.findByemailId(email);
	}

	public Optional<UserFavouriteModel> getMovie(String emailId, int movieId){
		UserId user=new UserId(movieId,emailId);
		return userdao.findById(user);
	}
	public void deleteMovie(String emailId, int movieId){
		UserId userMovie=new UserId(movieId, emailId);
		userdao.deleteById(userMovie);
	}
}
