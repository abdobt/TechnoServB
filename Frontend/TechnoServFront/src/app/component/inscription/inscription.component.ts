import { Component, OnInit } from '@angular/core';
import { InscriptionServiceService } from 'src/app/inscription-service.service';
import { JwtclientService } from '../../jwtclient.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  fullname: any = '';
  email: any = '';
  password: any = '';
  ville: any = '';
  phonenum: any = '';

  constructor(private service: InscriptionServiceService) { }

  ngOnInit(): void {
  }
  public registerbtn() {
    console.log("fullname : " + this.fullname);
    console.log("email : " + this.email);
    console.log("password : " + this.password);
    console.log("ville : " + this.ville);
    console.log("phonenum : " + this.phonenum);
    let registerRequest: any = {
      "name": this.fullname,
      "email": this.email,
      "password": this.password,
      "phone_num": this.phonenum,
      "ville": this.ville
    };
    console.log(registerRequest);
    let resp = this.service.register(registerRequest);
    resp.subscribe();
  }

}
