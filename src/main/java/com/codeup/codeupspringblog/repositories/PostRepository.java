package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    class PostController {
        private final PostRepository adDao;

        public PostController(PostRepository adDao) {
            this.adDao = adDao;
        }

        public PostRepository getAdDao() {
            return adDao;
        }
    }


}
