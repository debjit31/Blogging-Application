package com.ecom.app.controllers;

import com.ecom.app.entity.Post;
import com.ecom.app.exceptions.PostNotFoundException;
import com.ecom.app.model.PostCreateRequest;
import com.ecom.app.model.PostUpdateRequest;
import com.ecom.app.model.ResponseModel;
import com.ecom.app.services.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/posts")
public class PostController {


    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping(value = "/createPost")
    public ResponseEntity<Post> createPost(@RequestParam(value = "request") PostCreateRequest postCreateRequest) throws IOException {
        Post createdPost = postService.savePost(postCreateRequest);
        log.info("Post created successfully in db...");
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/updatePost")
    public ResponseEntity<ResponseModel> updatePost(@RequestParam int postId, @RequestBody PostUpdateRequest postUpdateRequest){
        try {
            int updatedCount = postService.updatePost(postId, postUpdateRequest);
            if(updatedCount > 0){
                ResponseModel responseModel = ResponseModel.builder()
                        .data(updatedCount)
                        .status("SUCCESS")
                        .build();
                return new ResponseEntity<>(responseModel,HttpStatus.ACCEPTED);
            }
        } catch (PostNotFoundException e) {
            log.info("Post update failed with exception {}", e.getMessage());
            ResponseModel responseModel = ResponseModel.builder()
                    .data(0)
                    .status(e.getMessage())
                    .build();
            return new ResponseEntity<>(responseModel, HttpStatus.CONFLICT);
        }
        return null;
    }

    @DeleteMapping("/deletePost")
    public ResponseEntity<ResponseModel> deletePost(@RequestParam int postId) {
        try {
            boolean deletedStatus = postService.deletePost(postId);
            ResponseModel responseModel = ResponseModel.builder()
                    .data(deletedStatus)
                    .status("SUCCESS")
                    .build();
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (PostNotFoundException e) {
            log.info("Post delete failed with exception {}", e.getMessage());
            ResponseModel responseModel = ResponseModel.builder()
                    .data(false)
                    .status(e.getMessage())
                    .build();
            return new ResponseEntity<>(responseModel, HttpStatus.CONFLICT);
        }
    }
}
