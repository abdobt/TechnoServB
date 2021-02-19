import { Component } from '@angular/core';
import { JwtclientService } from '../jwtclient.service';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page {
  username:string='';
  phone:number;
  email:string='';
  ville:string='';
  constructor(private service:JwtclientService) {
    let resp=this.service.techinfos();
resp.subscribe(
 data => {
 /// data=JSON.stringify(data);
 var obj = JSON.parse(data.toString())
         console.log(obj['name']);
        this.username=obj['name'];
        this.ville=obj['ville'];
        this.email=obj['email'];
        this.phone=obj['phone_number'];
},
(error) => {                              //Error callback
  console.error('error caught in component')
  //throw error;   //You can also throw the error to a global error handler
}
  );
  }
  public logout()
  {
    this.service.logout();
  }

}
