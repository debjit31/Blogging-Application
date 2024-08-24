package com.ecom.app.model;

import com.ecom.app.entity.Author;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class PostCreateRequest {

    private String title;
    private String content;
    private Author author;
    private LocalDateTime createdAt;
    private byte[] image;
}
