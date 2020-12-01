package test.atl.atm.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomFilter extends OncePerRequestFilter {
  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
    String auth = httpServletRequest.getHeader("Authorization");
    if(auth!=null){
//      UsernamePasswordAuthenticationToken authenticationFilter = new UsernamePasswordAuthenticationToken(auth, auth);
//
//      SecurityContextHolder.getContext().setAuthentication(authenticationFilter);
    }
    filterChain.doFilter(httpServletRequest,httpServletResponse);
  }
}
