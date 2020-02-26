package org.example.book.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.example.book.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * csrf().disable().headers().frameOptions().disable() : h2console 사용위해 옵션 disable
     * authorizeRequests : url 별 권한 관리 설정옵션의 시작
     * antMatchers : 권한 관리 대상을 지정하는 옵션 URL HTTP 메소드별 관리 가능
     * "/" 등 URL 은 전체 열람 권한 줌
     * POST 메소드면서 /api/v1/** 주소 가진 API 는 USER 권한을 가진 사람만 가능
     * .logout().logoutSuccessUrl("/") : 로그아웃 성공시 / 주소로 이동
     */
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/","/css/**","/images/**",
                        "/js/**","/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}
