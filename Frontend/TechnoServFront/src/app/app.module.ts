import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { TechgenerationComponent } from './component/techgeneration/techgeneration.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { DemandeComponent } from './component/demande/demande.component';
import { WorkercardComponent } from './component/workercard/workercard.component';
import { HttpClientModule } from '@angular/common/http';
import { WebSocketService } from '../app/services/websocket.service';
import { AppRoutingModule } from '../app-routing.module';
import { HomeComponent } from './component/home/home.component'; // Added here
import { AuthGuard } from './auth.guard';
import { AboutComponent } from './component/about/about.component';
import { CvComponent } from './component/cv/cv.component';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { RatingComponent } from './component/rating/rating.component';
import { TeamComponent } from './component/team/team.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TechgenerationComponent,
    InscriptionComponent,
    DemandeComponent,
    WorkercardComponent,
    HomeComponent,
    AboutComponent,
    CvComponent,
    NavBarComponent,
    RatingComponent,
    TeamComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule, HttpClientModule,
    AppRoutingModule,
  ],
  providers: [WebSocketService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
