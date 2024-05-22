//package com.toy.bookstore.infrastructure.jpa;
//
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.util.StringUtils;
//
//import java.util.Optional;
//
//public class AuditorAwareImpl implements AuditorAware<Long> {
//
//    @Override
//    public Optional<Long> getCurrentAuditor() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if(null == authentication || !authentication.isAuthenticated()) {
//            return null;
//        }
//
//        //사용자 환경에 맞게 로그인한 사용자의 정보를 불러온다.
//        CustomUserDetails userDetails = (CustomUserDetails)authentication.getPrincipal();
//
//        return Optional.of(userDetails.getId());
//    }
//
//}