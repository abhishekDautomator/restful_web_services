package com.abhishek.rest.webservices.restful_web_services.services;

import com.abhishek.rest.webservices.restful_web_services.dto.Post;
import com.abhishek.rest.webservices.restful_web_services.entities.PostEntity;

import java.util.List;

public interface PostService {

    public List<PostEntity> getAllPosts();
    public List<PostEntity> getAUserPosts(int userId);
    public PostEntity getPost(int postId);
    public void deletePost(int postId);
    public PostEntity editPost(int postId);
}
