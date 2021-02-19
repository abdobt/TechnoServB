import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RatingServiceService } from 'src/app/rating-service.service';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {

  constructor(private service: RatingServiceService,private router:Router) { }

  ngOnInit(): void {
  }

  public setradio(feedback) {
    console.log(feedback);
    // this.service.usertoken = this.service2.usertoken;
    // let feedbackRequest: any = feedback;
    // feedback:{
    //   rating:
    // }
    let resp = this.service.updateDemande({ rating: feedback });
    resp.subscribe();
    this.router.navigateByUrl['/'];
  }

}
