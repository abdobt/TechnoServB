import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtclientService } from './jwtclient.service';

@Injectable({
  providedIn: 'root'
})
export class RatingServiceService {
  // private service2: JwtclientService;

  constructor(private http: HttpClient, private service2: JwtclientService) { }

  updateDemande(request) {
    // let usertoken = this.service2.currentUserToken;
    let usertoken = localStorage.getItem('token');
    let tokenStr = 'Bearer ' + usertoken;
    const headers = new HttpHeaders().set("Authorization", tokenStr);
    return this.http.post("http://localhost:9091/service5/rating", request, { headers, responseType: 'text' as 'json' })
  }
}
