import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DemandeServiceService {

  constructor(private http: HttpClient) { }

  addDemande(request) {
    let usertoken = localStorage.getItem('token');
    let tokenStr = 'Bearer ' + usertoken;
    const headers = new HttpHeaders().set("Authorization", tokenStr);
    return this.http.post("http://localhost:9091/service5/distance", request, { headers, responseType: 'text' as 'json' })
  }
}
