package com.supercopo.chamado.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supercopo.chamado.service.ResetSenhaService;

@RestController
@RequestMapping(value = "/forgot")
public class ResetSenhaResource {
	@Autowired
	ResetSenhaService restsenhaService;

	
//	@RequestMapping(method = RequestMethod.PUT)
//	public ResponseEntity<?> resetSenha(@RequestBody String login){
//		EmailDTO obj = new EmailDTO();
//		obj.setEmail(email);
//		restsenhaService.sendNewPassword(obj);		
//		return ResponseEntity.ok().body(obj);
//	}
	

}
