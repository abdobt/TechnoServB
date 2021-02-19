import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InscriptionServiceService {

  constructor(private http: HttpClient) { }

  register(request) {
    return this.http.post("http://localhost:9091/authenticate/inscription", request, { responseType: 'text' as 'json' })
  }
}
