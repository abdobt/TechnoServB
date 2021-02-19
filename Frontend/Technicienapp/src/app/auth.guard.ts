import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { JwtclientService } from './jwtclient.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private _authService:JwtclientService,private router:Router)
  {

  }
  canActivate():boolean{
    console.log("hello guard");
    if(this._authService.loggedIn()) {
      return true
    }
    else {
      this.router.navigate(['/']);
      return false
    }
  }
}
