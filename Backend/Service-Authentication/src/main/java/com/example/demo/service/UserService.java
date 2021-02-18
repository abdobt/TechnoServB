package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Client;
import com.example.demo.entity.User;
import com.example.demo.metier.Clientmetier;
import com.example.demo.util.JwtUtil;


//@CrossOrigin(origins = "*")
@RestController
public class UserService {
	@Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
	private Clientmetier clientMetier;
	@GetMapping("/authenticate/wc")
	public String welcome()
	{ 
		String res="";
		res=restTemplate.getForObject("http://localhost:8080/websocket-backend/notify", res.getClass());
		System.out.println(res);
		return "Welcome to abdo's page";
	}
	@PostMapping("/authenticate")
    public String generateToken(@RequestBody User authRequest) throws Exception {
		System.out.println("hello");
		System.out.println(authRequest.getEmail()+","+authRequest.getPassword());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getEmail());
    }

	@PostMapping("/authenticate/verify")
    public String verify() throws Exception {
		return "verified";
	}
	
	@PostMapping("/authenticate/inscription")
	public Client saveClient(@RequestBody Client registerRequest) {
		System.out.println("hello");
//		registerRequest.setId((long) 15);
		System.out.println(registerRequest.getEmail()+","+registerRequest.getPassword()+","+registerRequest.getVille());
	return clientMetier.add(registerRequest);
	}
}
