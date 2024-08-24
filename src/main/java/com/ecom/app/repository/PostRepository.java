package com.ecom.app.repository;

import com.ecom.app.entity.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Post p SET p.title = :title, p.content = :content, p.image = :image, p.updatedAt = :updatedAt WHERE p.id = :postId")
    int updatePostById(@Param("postId") Long postId, @Param("title") String title, @Param("content") String content,
                       @Param("image") byte[] image, @Param("updatedAt") LocalDateTime updatedAt);

}
