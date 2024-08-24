package com.ecom.app.controllers;

import com.ecom.app.model.ResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @GetMapping("/{postId}")
    public ResponseModel getCommentsForAPost(@PathVariable Long postId){
        return new ResponseModel();
    }



}
