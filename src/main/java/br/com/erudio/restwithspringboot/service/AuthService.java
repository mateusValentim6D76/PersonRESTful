package br.com.erudio.restwithspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.erudio.restwithspringboot.repository.UserRepository;
import br.com.erudio.restwithspringboot.security.jwt.JwtTokenProvider;
import br.com.erudio.restwithspringboot.vo.v1.security.AccountCredentialsVO;
import br.com.erudio.restwithspringboot.vo.v1.security.TokenVO;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity signin(AccountCredentialsVO data) {
		try {
			var username = data.getUsername();
			var password = data.getPassword();
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password));
			var user = userRepository.findByUsername(username);
			
			var tokenResponse = new TokenVO();
			if(user != null) {
				tokenResponse = jwtTokenProvider.createAccessToken(username, user.getRoles());
			} else {
				throw new UsernameNotFoundException("Username" + username + "not found!");
			}
			return ResponseEntity.ok(tokenResponse);
		} catch (Exception e) {
			throw new BadCredentialsException("Invalid username/password");
		}
		
	}
	
}
