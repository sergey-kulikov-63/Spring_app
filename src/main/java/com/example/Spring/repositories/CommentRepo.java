package com.example.Spring.repositories;

import com.example.Spring.models.Comment;
import com.example.Spring.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> { // наследование методов от JpaRepository
    List<Comment> findByPost(Post post); // дополнительный метод - поиск по посту
    // нужен для поиска комментариев к опеделённому посту

}
