package com.codeup.codeupspringblog.repository;

import com.codeup.codeupspringblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

public interface PostRepository extends JpaRepository<Post, Long> {
    class PostController {
        // ...
        private final PostRepository adDao;

        public PostController(PostRepository adDao) {
            this.adDao = adDao;
        }
    }


}
