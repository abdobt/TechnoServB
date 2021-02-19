import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpHeaders, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { EROFS } from 'constants';
@Injectable({
  providedIn: 'root'
})
export class JwtclientService {
  public usertoken: any = '';
  constructor(private http: HttpClient) { }
  // usertoken:any='';
  public generateToken(request) {
    return this.http.post("http://localhost:9091/authenticate", request, { responseType: 'text' as 'json' });
  }
  public verifytoken() {
    let tokenStr = 'Bearer ' + localStorage.getItem('token');
    const headers = new HttpHeaders().set("Authorization", tokenStr);
    return this.http.post("http://localhost:9091/authenticate/verify", null, {headers, responseType: 'text' as 'json'});
  }
  public welcome() {
    let tokenStr = 'Bearer ' + this.usertoken;
    const headers = new HttpHeaders().set("Authorization", tokenStr);
    return this.http.get("http://localhost:9091/authenticate", { headers, responseType: 'text' as 'json' })
  }
  loggedIn() {
    const _this = this;
    console.log("hello");
   /* let resp=this.verifytoken();
    resp.subscribe(
      // data=>console.log("Token : "+data)
      (data) => {                           //Next callback
        console.log(JSON.parse(data.toString()));
      },
      (err) => {
        console.log(err);                        //Error callback
        console.error('error caught in component')
        //throw error;   //You can also throw the error to a global error handler
      }
    );*/
    if(localStorage.getItem('token')==null)
      return false;
    else if (localStorage.getItem('token') == '')
      return false;
    else{
      return true
    }
      }

    upload(file: File): Observable<HttpEvent<any>> {
      const formData: FormData = new FormData();

      formData.append('file',file);

      const req = new HttpRequest('POST', `http://localhost:9091/service1/cv`, formData, {
        reportProgress: true,
        responseType: 'json'
      });

      return this.http.request(req);
    }
    logout()
    {
      localStorage.removeItem('token');
    }
}
