import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { CounterComponent } from './counter/counter.component';
import { GalleryComponent } from './gallery/gallery.component';
import { ContactComponent } from './contact/contact.component';
import { FooterComponent } from './footer/footer.component';
import { BarRatingModule } from "ngx-bar-rating";
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { TrainingComponent } from './training/training.component';
import { AboutComponent } from './about/about.component';
import { SessionComponent } from './session/session.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { CommonModule } from '@angular/common';
import { ListTotalSessionsComponent } from './list-total-sessions/list-total-sessions.component';
import { CollabComponent } from './collab/collab.component';
import { ProfilComponent } from './profil/profil.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    CounterComponent,
    
    GalleryComponent,
         ContactComponent,
         FooterComponent,
         TrainingComponent,
         AboutComponent,
         SessionComponent,
         UserComponent,
         LoginComponent,
         ListTotalSessionsComponent,
         CollabComponent,
         ProfilComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BarRatingModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    

    
   
  ],
  providers: [ 
],
  bootstrap: [AppComponent]
})
export class AppModule { }
