package com.ecom.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "posts", schema = "hubexspw")
public class Post {

    @Id
    @SequenceGenerator(
            name = "post_generator",
            sequenceName = "post_sequence",
            schema = "hubexspw",
            allocationSize = 1,
            initialValue = 1001
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "post_generator"
    )
    private Long id;
    private String title;
    private String content;
    @Lob
    private byte[] image;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
