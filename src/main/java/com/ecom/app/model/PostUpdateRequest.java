package com.ecom.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateRequest {

    private String title;
    private String content;
    private LocalDateTime updatedAt;
    private byte[] image;
}
