import { Component, OnInit } from '@angular/core';
import { ListallsessionService } from '../services/listTotalSessions/listallsession.service';
import { ListTotalSessions } from '../model/list-total-sessions';
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-total-sessions',
  templateUrl: './list-total-sessions.component.html',
  styleUrls: ['./list-total-sessions.component.scss']
})
export class ListTotalSessionsComponent implements OnInit {
  AllDetail: ListTotalSessions[] = [];
  listTotalSessionsForm: ListTotalSessions = {
    idUser: 0,
    idTrainingsession : 0,
    nameUser : "",
    nameSession : "",
    dateOfSession : new Date(),
    status : ""
  };



  constructor(private listTotalSessions: ListallsessionService,private router:Router) {}

  ngOnInit(): void {
    this.getAll();

  }

  getAll() {
    this.listTotalSessions.getAllSessions().subscribe((data) => {
      this.AllDetail = data;
      console.log(data);

    });
  }

  getById(iduser:number,idTrainingsession:number) {
    this.listTotalSessions.getSessionById(iduser,idTrainingsession).subscribe((data) => {
      this.listTotalSessionsForm = data;
    });
  }

  

  updateStatus(iduser:number,idTrainingsession:number,status : String){
    this.listTotalSessions.updateStatus(iduser,idTrainingsession,status).subscribe((data) => {
      this.router.navigate(["listAllSession"]);
    });

  }

}
