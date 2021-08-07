package com.example.moviedb.service;

import com.example.moviedb.Dao.UserDao;
import com.example.moviedb.model.Myjson;
import com.example.moviedb.model.UserFavouriteModel;
import com.example.moviedb.model.UserId;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userservice;
    @Mock
    private UserDao userdao;
    UserFavouriteModel user;
    Myjson movieJson;
    UserId uid;
    @BeforeEach
    public void setUp() throws Exception{
        user=new UserFavouriteModel();
        movieJson=new Myjson();
        movieJson.setAdult(false);
        movieJson.setBackdrop_path("/abcdef");
        int [] a= {1,2,3};
        movieJson.setGenre_ids(a);
        movieJson.setId(1234);
        movieJson.setOriginal_language("en");
        user.setEmailId("abcd@gmail.com");
        user.setMovieId(1234);
        user.setMovieObj(movieJson);
        uid=new UserId(user.getMovieId(), user.getEmailId());
    }

    @Test
    public void getDataTest(){
        when(userdao.findByemailId("abcd@gmail.com")).thenReturn((List<UserFavouriteModel>) user);
        List<UserFavouriteModel> user1= userdao.findByemailId("abcd@gmail.com");
        assertEquals(user,user1);
        List<UserFavouriteModel> user2=userdao.findByemailId("");
        assertEquals(0,user2.size());
    }

    @Test
    public void getMovieTest(){
        when(userdao.findById(uid)).thenReturn(Optional.ofNullable(user));
        Optional<UserFavouriteModel> user1=userdao.findById(new UserId(1234,"abcd@gmail.com"));
        assertEquals(Optional.ofNullable(user),user1);
    }

    @Test
    public void addTest() {
        doNothing().when(userdao.save(user));
        System.out.println();

    }

}