package com.example.BackEnd_Gcm_Login.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackEnd_Gcm_Login.dto.LoginDto;
import com.example.BackEnd_Gcm_Login.dto.RetornoLoginDto;
import com.example.BackEnd_Gcm_Login.repository.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	UsuarioRepository repo;
	
	@PostMapping("/login")
	public ResponseEntity<?> validaLogin(@RequestBody LoginDto body){
		
		try {
			RetornoLoginDto retornoDto = repo.retornoLogin(body.getLogin(), body.getSenha());
			
			if(retornoDto != null) {
				return ResponseEntity.status(HttpStatus.OK).body(retornoDto);
			}else {
				return ResponseEntity.status(HttpStatus.OK).body("Usuário ou senha inválidos!");
			}
			
		} catch (Exception e) {
			throw e;
		}
	}

}
