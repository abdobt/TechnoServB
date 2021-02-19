import { Component, OnInit } from '@angular/core';
import { JwtclientService } from '../jwtclient.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  email:any='';
  password:any='';
  constructor(private service:JwtclientService,private router: Router) { }

  ngOnInit() {}
  public getAccesstoken(authRequest)
  {
let resp=this.service.generateToken(authRequest);
resp.subscribe(data=>console.log("Token : "+data));
  }
  public clc()
  {
    console.log("username : "+this.email);
    console.log("password : "+this.password);
    let authRequest:any={
      "email":this.email,
      "password":this.password
    };
    console.log(authRequest);
    let resp=this.service.generateToken(authRequest);
resp.subscribe(
 // data=>console.log("Token : "+data)
 (data) => {                           //Next callback
  this.service.usertoken=data;
  localStorage.setItem('token',data.toString());
  this.router.navigate(['/tabs/tab1']);
},
(error) => {                              //Error callback
  console.error('error caught in component')
  //throw error;   //You can also throw the error to a global error handler
}
  );
  }

}
