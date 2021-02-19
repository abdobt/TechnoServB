import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RatingServiceService } from 'src/app/rating-service.service';
import { JwtclientService } from '../../jwtclient.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: any = '';
  password: any = '';
  constructor(private service: JwtclientService,private router:Router) { }

  ngOnInit(): void {
  }
  public register()
  {
this.router.navigateByUrl['/register'];
  }
  public clc() {
    console.log("username : " + this.email);
    console.log("password : " + this.password);
    let authRequest: any = {
      "email": this.email,
      "password": this.password
    };
    console.log(authRequest);
    let resp = this.service.generateToken(authRequest);
    resp.subscribe(
      // data=>console.log("Token : "+data)
      (data) => {                           //Next callback
        console.log("good");
        this.service.usertoken = data;
        localStorage.setItem('token', data.toString());
        console.log(this.service.usertoken);
        this.router.navigate(['/demander']);
      },
      (error) => {                                //Error callback
        console.error('error caught in component')
        //throw error;   //You can also throw the error to a global error handler
      }
    );
    }
}
