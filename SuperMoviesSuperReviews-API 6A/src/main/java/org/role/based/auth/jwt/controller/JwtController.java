package org.role.based.auth.jwt.controller;

import org.role.based.auth.jwt.entity.JwtRequest;
import org.role.based.auth.jwt.entity.JwtResponse;
import org.role.based.auth.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4203")
public class JwtController {

    @Autowired
    private JwtService jwtService;
   
    
    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
    
   
}
