import { Component } from '@angular/core';
import { Geolocation } from '@ionic-native/geolocation/ngx';
import { ToastController } from '@ionic/angular';
import { JwtclientService } from '../jwtclient.service';
@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {
checked:boolean=false;
email:any='';
  password:any='';
timerId:any;
  lat;
  lng;

  constructor(private service:JwtclientService,private geo: Geolocation,public toastController: ToastController) {
  }
  async presentToast() {
    const toast = await this.toastController.create({
      message: 'Back to Search',
      duration: 2000
    });
    toast.present();
  }
  async presentToast1() {
    const toast = await this.toastController.create({
      message: 'Location updates turned off',
      duration: 2000
    });
    toast.present();
  }
locationupdates()
{
  if(!this.checked)
  {
    this.presentToast();
    let resp=this.service.updatestate();
resp.subscribe(
 // data=>console.log("Token : "+data)
 (data) => {                           //Next callback
  console.log("all is good");
  console.log(data);
},
(error) => {                              //Error callback
  console.error('error caught in component')
  //throw error;   //You can also throw the error to a global error handler
}
  );
    this.timerId = setInterval(() =>this.whereIam(), 2000);
  this.checked=true;
  }
  else
  {
    this.presentToast1();
    let resp=this.service.updatestate();
resp.subscribe(
 // data=>console.log("Token : "+data)
 (data) => {                           //Next callback
  console.log("all is good");
},
(error) => {                              //Error callback
  console.error('error caught in component')
  //throw error;   //You can also throw the error to a global error handler
}
  );
    this.checked=false;
    clearInterval(this.timerId)
  }
}
  whereIam() {
      this.geo.getCurrentPosition({
        timeout: 1000,
        enableHighAccuracy: true
      }).then((res) => {
        let loc:any={
          "lattitude":res.coords.latitude,
          "longitude":res.coords.longitude
        };
        let resp=this.service.updatelocation(loc);
resp.subscribe(
 (data) => {
  console.log(data);
},
(error) => {
  console.error('error caught in component')
}
  );
      }).catch((e) => {
        console.log(e);
      });
  }
  public wlc()
  {
    console.log(this.service.usertoken);
    let loc:any={
      "longitude":147,
      "lattitude":146
    };
    let resp=this.service.updatelocation(loc);
resp.subscribe(
 // data=>console.log("Token : "+data)
 (data) => {                           //Next callback
  console.log("all is good");
  console.log(data);
},
(error) => {                              //Error callback
  console.error('error caught in component')
  //throw error;   //You can also throw the error to a global error handler
}
  );
  }

}
