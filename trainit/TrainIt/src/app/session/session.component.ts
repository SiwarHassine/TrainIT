import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Session } from '../model/session';
import { SessionService } from '../services/session/session.service';
import { IdService } from '../services/id/id.service';
@Component({
  selector: 'app-session',
  templateUrl: './session.component.html',
  styleUrls: ['./session.component.scss']
})
export class SessionComponent implements OnInit {
  userName: string = "" ;
  iduser:number=0;
  selectedTrainingId: number=0;
  allTrainingSession: Session[] = [];
  data : number=0;
  trainingSessionForm: Session = {
    id: 0,
    name: '',
  };
  constructor(private router: Router,private trainingSessionsService: SessionService,private idService: IdService) {}
 
  ngOnInit(): void {

    const userDataStr = localStorage.getItem('userData');
    if (userDataStr) {
      const userData = JSON.parse(userDataStr);
      this.idService.setUserData(userData);
    }

    this.idService.getUserData().subscribe((data) => {
      console.log(data)
      this.userName = data.name;
      this.iduser=data.id;
      console.log(this.iduser)
   
    })
    this.get();
  }
 
  openFirstModal(id: number) {
    this.selectedTrainingId = id;
  }
  
  openSecondModal() {
    this.getByIdSession(this.selectedTrainingId);
  }


  get() {
    this.trainingSessionsService.get().subscribe((data) => {
      this.allTrainingSession = data;
    });
  }

  delete() {

    if (confirm("Do you want remove?: ")) {
      this.trainingSessionsService.delete(this.selectedTrainingId).subscribe(result => {
        this.get();
      });
    }
}

getByIdSession(id: number) {
  this.trainingSessionsService.getByIdTrainingSession(id).subscribe((data) => {
    this.trainingSessionForm = data;
  });
}

update() {
  this.trainingSessionsService.update(this.trainingSessionForm).subscribe({
    next:() => {
      this.router.navigate(["session"]).then(() => {

        location.reload();      this.trainingSessionForm.name = "";
  });

    },
    error:(err) => {
      console.log(err);
    }
  })
}

subscribe(){

  this.trainingSessionsService.subscribeTraining(this.iduser,this.trainingSessionForm.id)
      .subscribe((res)=>{
        this.data=<number>res;
        if (this.data != -1) {
          this.router.navigate(["/session"]);
          location.reload(); 
        } else {
         alert("Invalid ")
        }
      });
}

}
