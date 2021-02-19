import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DemandeServiceService } from 'src/app/demande-service.service';

@Component({
  selector: 'app-demande',
  templateUrl: './demande.component.html',
  styleUrls: ['./demande.component.css']
})
export class DemandeComponent implements OnInit {

  adresse: any = '';
  // longitude: any = 0;
  // lattitude: any = 0;
  operation: any = '';
  constructor(private service: DemandeServiceService, private router: Router) { }

  ngOnInit(): void {
  }
  public getLocation() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position) => {
        // this.longitude = position.coords.longitude;
        // this.lattitude = position.coords.latitude;
        // console.log(this.longitude);
        // console.log(this.lattitude);
        // console.log(this.adresse);
        // console.log(this.operation);
        let demandeRequest: any = {
          "adresse": this.adresse,
          "lattitude": position.coords.longitude,
          "longitude": position.coords.latitude,
          "specialite":
          {
            "name": this.operation
          }
        };
        console.log(demandeRequest);
        let resp = this.service.addDemande(demandeRequest);
        resp.subscribe();
        this.router.navigate(['/techgeneration']);
      });
    } else {
      console.log("No support for geolocation")
    }
  }
}
