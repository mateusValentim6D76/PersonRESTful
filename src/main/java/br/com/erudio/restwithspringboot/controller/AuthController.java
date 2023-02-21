package br.com.erudio.restwithspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.restwithspringboot.service.AuthService;
import br.com.erudio.restwithspringboot.vo.v1.security.AccountCredentialsVO;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Authentication Endpoint")
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	public ResponseEntity signin(AccountCredentialsVO data) {
		if (checkParamsIsNotNull(data))
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
		var token = authService.signin(data);
		if (token == null)
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
		return token;
	}

	private boolean checkParamsIsNotNull(AccountCredentialsVO data) {
		return data.getUsername() == null || data.getUsername().isBlank() || data.getUsername().isEmpty()
				|| data.getPassword() == null || data.getPassword().isBlank() || data.getPassword().isEmpty();
	}
}
