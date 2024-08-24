package com.ecom.app.services;

import com.ecom.app.entity.Post;
import com.ecom.app.exceptions.PostNotFoundException;
import com.ecom.app.model.PostCreateRequest;
import com.ecom.app.model.PostUpdateRequest;
import com.ecom.app.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PostService {

    Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository postRepository;


    public Post savePost(PostCreateRequest postCreateRequest) throws IOException {
        logger.info("Received post create request {}", postCreateRequest);
        Post post = createPostDbObject(postCreateRequest);
        return postRepository.save(post);
    }

    private Post createPostDbObject(PostCreateRequest postCreateRequest) throws IOException {
        Post post = Post.builder()
                .title(postCreateRequest.getTitle())
                .content(postCreateRequest.getContent())
                .author(postCreateRequest.getAuthor())
                .createdAt(postCreateRequest.getCreatedAt())
                .image(postCreateRequest.getImage())
                .build();
        return post;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public int updatePost(long postId, PostUpdateRequest postUpdateRequest) throws PostNotFoundException {
        int updatedCount = 0;
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            updatedCount = postRepository.updatePostById(postId, postUpdateRequest.getTitle(), postUpdateRequest.getContent(),
                    postUpdateRequest.getImage(), postUpdateRequest.getUpdatedAt());
        } else {
            throw new PostNotFoundException("The Post which you want to update does not exists.");
        }
        return updatedCount;
    }

    public boolean deletePost(long postId) throws PostNotFoundException {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            postRepository.deleteById(postId);
            return true;
        }else{
            throw new PostNotFoundException("The Post which you want to delete does not exists.");
        }
    }

}
