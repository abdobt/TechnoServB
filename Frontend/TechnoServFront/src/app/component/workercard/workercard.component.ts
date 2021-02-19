import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PickedtechService } from 'src/app/pickedtech.service';

@Component({
  selector: 'app-workercard',
  templateUrl: './workercard.component.html',
  styleUrls: ['./workercard.component.scss']
})
export class WorkercardComponent implements OnInit {
Nomc:string='';
phone:number;
email:string='';
specialite:string='';
  constructor(private ts:PickedtechService,private router:Router) {
    this.Nomc=ts.techdata['username'];
    this.phone=ts.techdata['phone'];
    this.email=ts.techdata['email'];
    this.specialite=ts.techdata['specialite'];
   }

  ngOnInit(): void {
  }
  rd()
  {
this.router.navigate(['/rating']);
  }

}
