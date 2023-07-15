import { Component, OnInit } from '@angular/core';
import { IdService } from '../services/id/id.service';
import { Router } from '@angular/router';
import { ListallsessionService } from '../services/listTotalSessions/listallsession.service';
@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {

  score:Number[]= [];
  numDone:Number=0
  numWaiting:Number=0
  numProgress:Number=0
  numS:Number=0

  d:Number=0
  w:Number=0
  p:Number=0
  s:Number=0


  userName: string = "" ;
  iduser:number=0;
  userRole:string=""; 

  constructor(private idService: IdService,private sessionService:ListallsessionService ,private router: Router) { }

  ngOnInit(): void {

    const userDataStr = localStorage.getItem('userData');
    if (userDataStr) {
      const userData = JSON.parse(userDataStr);
      this.idService.setUserData(userData);
    }

    this.idService.getUserData().subscribe((data) => {
      this.iduser=data.id;
      this.userName = data.name;
      this.userRole=data.role;
      
    })
    this.sessionService.getScore(this.iduser).subscribe((data) => {
      this.s=data[0];
      this.w=data[1];
      this.p=data[2];
      this.d=data[3];
      this.numDone = ((this.d as number) * 100) / (this.s as number);
      this.numProgress = ((this.p as number) * 100) / (this.s as number);
      this.numWaiting = ((this.w as number) * 100) / (this.s as number);
     console.log(this.numDone,this.numProgress,this.numWaiting)
   
    })
   
        }





}
