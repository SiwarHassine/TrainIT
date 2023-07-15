import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../services/user/user.service';
import { Router } from '@angular/router';
import { IdService } from '../services/id/id.service';
import { ListTotalSessions } from '../model/list-total-sessions';
import { ListallsessionService } from '../services/listTotalSessions/listallsession.service';
@Component({
  selector: 'app-collab',
  templateUrl: './collab.component.html',
  styleUrls: ['./collab.component.scss']
})
export class CollabComponent implements OnInit {

  constructor(private listTotalSessions: ListallsessionService,private idService: IdService,private userService: UserService, private router:Router) { }


  allUsers: User[] = [];
  userForm: User = {
    id: 0,
    name: '',
    password:"",
    role:"",
  };

  AllDetail: ListTotalSessions[] = [];


  listTotalSessionsForm: ListTotalSessions = {
    idUser: 0,
    idTrainingsession : 0,
    nameUser : "",
    nameSession : "",
    dateOfSession : new Date(),
    status : ""
  };


  userName: string = "" ;

  NameCollab:string='';
  selectedTrainingId: number=0;

  iduser:number=0;
  userRole:string=""; 
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
      this.userService.getByManager(this.userName ).subscribe((data) => {
        this.allUsers = data;
      
      });

     
    })
    
  }

  getById(id: number) {
    this.userService.getById(id).subscribe((data) => {
      this.userForm = data;
  
    });
  }


  showDetails(id:number){
    this.listTotalSessions.getSessionByUser(id).subscribe((data) => {
      this.AllDetail = data;
      console.log(this.AllDetail)
    });
  }
}
