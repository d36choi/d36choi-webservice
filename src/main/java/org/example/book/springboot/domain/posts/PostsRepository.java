package org.example.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("select p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
    /*Querydsl 를 조회용 프레임워크로 추천. 그 이유는 타입안정성, 이미 메이저, 많은 레퍼런스*/
}
