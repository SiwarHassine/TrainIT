import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ContactComponent } from './contact/contact.component';
import { GalleryComponent } from './gallery/gallery.component';
import { HomeComponent } from './home/home.component';
import { TrainingComponent } from './training/training.component';
import { AboutComponent } from './about/about.component';
import { SessionComponent } from './session/session.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { ListTotalSessionsComponent } from './list-total-sessions/list-total-sessions.component';
import { CollabComponent } from './collab/collab.component';
import { ProfilComponent } from './profil/profil.component';
const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'home',component:HomeComponent},
  {path:'gallery',component:GalleryComponent},
  {path:'contact',component:ContactComponent},
  {path:'training',component:TrainingComponent},
  {path:'about',component:AboutComponent},
  {path:'session',component:SessionComponent},
  {path:'user',component:UserComponent},
  {path:'listAllSession',component:ListTotalSessionsComponent},
  {path:'collab',component:CollabComponent},
  {path:'profil',component:ProfilComponent},




];

@NgModule({
  imports: [RouterModule.forRoot(routes),
  
  
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
