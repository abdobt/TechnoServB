import { Component, OnInit } from '@angular/core';
import { JwtclientService } from 'src/app/jwtclient.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
f:boolean=false;
  constructor(private service:JwtclientService) { }

  ngOnInit(): void {
    this.f=this.service.loggedIn();
    console.log("th "+this.service.loggedIn());
  }
  public logout()
  {
    this.service.logout();
  }
}
