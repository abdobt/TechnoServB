import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './app/auth.guard';
import { DemandeComponent } from './app/component/demande/demande.component';
import { HomeComponent } from './app/component/home/home.component';
import { InscriptionComponent } from './app/component/inscription/inscription.component';
import { LoginComponent } from './app/component/login/login.component';
import { TechgenerationComponent } from './app/component/techgeneration/techgeneration.component';
import { WorkercardComponent } from './app/component/workercard/workercard.component';
import { RatingComponent } from './app/component/rating/rating.component';
import { AboutComponent } from './app/component/about/about.component';
import { CvComponent } from './app/component/cv/cv.component';
import { TeamComponent } from './app/component/team/team.component';



//This is my case
const routes: Routes = [

  {
    path: 'demander',
    component: DemandeComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'rating',
    component: RatingComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'register',
    component: InscriptionComponent
  },
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'about',
    component: AboutComponent
  },
  {
    path: 'pickedtech',
    component: WorkercardComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'techgeneration',
    component: TechgenerationComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'cv',
    component: CvComponent
  },
  {
    path: 'team',
    component: TeamComponent
  },
  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
