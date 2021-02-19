import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JwtclientService {
usertoken:any='';
  constructor(private http:HttpClient) { }
  public generateToken(request){
    return this.http.post("http://localhost:9091/authenticate",request,{responseType: 'text' as 'json'});
  }
  public welcome()
  {
    let tokenStr='Bearer '+localStorage.getItem('token');
    const headers=new HttpHeaders().set("Authorization",tokenStr);
    return this.http.get("http://localhost:9091/service1/wc",{headers,responseType: 'text' as 'json'})
   }
   public updatelocation(loc)
   {
    let tokenStr='Bearer '+localStorage.getItem('token');
    const headers=new HttpHeaders().set("Authorization",tokenStr);
    return this.http.post("http://localhost:9091/service1/wc",loc,{headers,responseType: 'text' as 'json'})
   }
   public updatestate()
   {
    let tokenStr='Bearer '+localStorage.getItem('token');
    const headers=new HttpHeaders().set("Authorization",tokenStr);
    return this.http.post("http://localhost:9091/service1/update",null,{headers,responseType: 'text' as 'json'})
   }
   public techinfos()
   {
    let tokenStr='Bearer '+localStorage.getItem('token');
    const headers=new HttpHeaders().set("Authorization",tokenStr);
    return this.http.get("http://localhost:9091/service1/infos",{headers,responseType: 'text' as 'json'})
   }
   loggedIn() {
    if(localStorage.getItem('token')==null)
      return false;
    else if (localStorage.getItem('token') == '')
      return false;
    else{
      return true
    }
      }
      logout()
      {
        localStorage.removeItem('token');
      }
}
