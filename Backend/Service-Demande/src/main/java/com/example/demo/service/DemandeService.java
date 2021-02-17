package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Client;
import com.example.demo.entity.Demande;
import com.example.demo.entity.RDV;
import com.example.demo.entity.Specialite;
import com.example.demo.entity.Technicien;
import com.example.demo.entity.User;
import com.example.demo.metier.Clientmetier;
import com.example.demo.metier.Demandemetier;
import com.example.demo.metier.RDVmetier;
import com.example.demo.metier.Specialitemetier;
import com.example.demo.metier.Technicienmetier;
import com.example.demo.metier.Usermetier;

@RestController
public class DemandeService {
	
	@Autowired
	private Demandemetier demandeMetier;
	@Autowired
	private RDVmetier rdvMetier;
	@Autowired
	private Specialitemetier specialiteMetier;
	@Autowired
	private Technicienmetier technicienMetier;
	@Autowired
	private Usermetier userMetier;
	@Autowired
	private Clientmetier clientMetier;
	@Autowired
    private RestTemplate restTemplate;
	@RequestMapping(value="/addDemande",method=RequestMethod.POST)
	public Demande saveDemande(@RequestBody Demande demandeRequest) {
		System.out.println("hello");
//		System.out.println(demandeRequest.getEmail()+","+registerRequest.getPassword()+","+registerRequest.getAdresse());
	return demandeMetier.add(demandeRequest);
	}
	
	public double getDistanceFromLatLonInKm(double lat1,double lon1,double lat2,double lon2) {
		  int R = 6371; // Radius of the earth in km
		  double dLat = deg2rad(lat2-lat1);  // deg2rad below
		  double dLon = deg2rad(lon2-lon1); 
		  double a = 
		    Math.sin(dLat/2) * Math.sin(dLat/2) +
		    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
		    Math.sin(dLon/2) * Math.sin(dLon/2)
		    ; 
		  double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		  double d = R * c; // Distance 
		  return d;
		}

		public double deg2rad(double deg) {
		  return deg * (Math.PI/180);
		}
	
	public Technicien recherche(double latitude, double longitude,String h)
	{
		System.out.println(clientMetier.findbyemail("Client@gmail.com"));
		UserDetails principal =  (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(principal.getUsername());

		Client t=clientMetier.findbyemail(principal.getUsername());
//		Client 
		System.out.println(t.getVille());
		List<Technicien> tc = technicienMetier.findByVille(t.getVille());
		System.out.print(tc);
		System.out.print(t.getVille());
		ArrayList<Double> distances = new ArrayList<>();
		for(int i =0 ; i< tc.size(); i++)
		{
			System.out.println(tc.get(i).getSpecialite().getId()+" , "+h+" "+tc.get(i).isDisponible());
		   if(tc.get(i).getSpecialite().getName().equals(h) && tc.get(i).isDisponible())
		   {
			double d= getDistanceFromLatLonInKm(latitude, longitude, tc.get(i).getLattitude(), tc.get(i).getLongitude());
			distances.add(d);
			System.out.print(d + "\n");
		   }
		}
		System.out.println(distances);
		int i = distances.indexOf(Collections.min(distances));
		return tc.get(i);
	}
	
	@PostMapping("/service5/distance")
	public void distance(@RequestBody Demande demandeRequest) throws JSONException
	{ 
			UserDetails principal =  (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Client c=clientMetier.findbyemail(principal.getUsername());
			String sname=demandeRequest.getSpecialite().getName();
			Technicien t=recherche(demandeRequest.getLattitude(), demandeRequest.getLongitude(),sname);
			  String spec = demandeRequest.getSpecialite().getName();
			  Specialite s = specialiteMetier.findByName(spec);
			  demandeRequest.setSpecialite(s);
			  demandeRequest.setClient(c);
			  demandeRequest.setRating(0.0);
			  demandeMetier.add(demandeRequest);
			  RDV rdv = new RDV();
			  rdv.setDemande(demandeRequest);
			  rdv.setTechnicien(t);
			  rdvMetier.add(rdv);
			  System.out.print("----------helloooooo------------\n");
			  System.out.print("Demande: "+ demandeRequest.getAdresse()+ demandeRequest.getSpecialite().getName());
			  System.out.print("RDV: " + rdv.getDemande().getAdresse()+ rdv.getTechnicien().getName());
			  JSONObject request = new JSONObject();
			  request.put("username", t.getName());
			  request.put("phone", t.getPhone_number());
			  request.put("email", t.getEmail());
			  request.put("specialite", t.getSpecialite().getName());
			  JSONObject request2 = new JSONObject();
			  
			  request2.put("username", c.getName());
			  request2.put("phone", c.getPhone_num());
			  request2.put("adresse",demandeRequest.getAdresse() );
			  // set headers
			  HttpHeaders headers = new HttpHeaders();
			  headers.setContentType(MediaType.APPLICATION_JSON);
			  HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);
			  HttpEntity<String> entity2 = new HttpEntity<String>(request2.toString(), headers);
			  // send request and parse result
			  restTemplate
			    .exchange("http://localhost:8080/websocket-backend/notifyclient", HttpMethod.POST, entity, String.class);
			  restTemplate
			    .exchange("http://localhost:8080/websocket-backend/notifytechnicien", HttpMethod.POST, entity2, String.class);
			//res=restTemplate.postForObject("http://localhost:8080/websocket-backend/notify",t, res.getClass());
			//System.out.println(res);
	}
	@GetMapping("/service5/ville")
	public void ville()
	{ 
			
			System.out.println(technicienMetier.findByVille("Tanger"));
	}
	@PostMapping("/service5/rating")
	public void rating(@RequestBody Demande feedback)
	{ 
			UserDetails principal =  (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Client c=clientMetier.findbyemail(principal.getUsername());
			Demande d = c.getLdemande().get( c.getLdemande().size() - 1);
			Double fb = feedback.getRating();
			d.setRating(fb);
			demandeMetier.update(d);
			
	}

}
