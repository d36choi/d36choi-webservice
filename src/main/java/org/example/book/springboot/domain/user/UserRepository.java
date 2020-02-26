package org.example.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * @param email
     * 소셜로그인 반환 값중 이메일 통해 이미 생성된 사용자인지 처음 사용자인지를 판단하기 위한 메소드임.
     */
    Optional<User> findByEmail(String email);
}
