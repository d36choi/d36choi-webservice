package org.example.book.springboot.domain.falsus;

import org.example.book.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FalsusRepository extends JpaRepository<Falsus, Long> {

    @Query("select f FROM Falsus f ORDER BY f.id")
    List<Falsus> findAllDesc();
}
