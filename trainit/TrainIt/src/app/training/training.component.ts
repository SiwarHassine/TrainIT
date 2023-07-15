import { Component, OnInit,Input } from '@angular/core';
import { Training } from '../model/training';
import { TrainingService } from '../services/training/training.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Session } from '../model/session';
@Component({
  selector: 'app-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.scss']
})
export class TrainingComponent implements OnInit {

  id : number = 0;
  data : number=0;

  sessionForm: Session = {
    id: 0,
    name: '',
  };


  selectedTrainingId: number=0;
  showForm = false;
  allTrainings: Training[] = [];
  trainingForm: Training = {
    id: 0,
    thematic: '',
  };
  constructor(private route: ActivatedRoute,
    private router:Router,
    private trainingsService: TrainingService
  ) {}
 
  ngOnInit(): void {
    this.get();
    this.route.paramMap.subscribe((param) => {
      var id = Number(param.get('id'));
      this.getById(id);
    });
  }
 


openFirstModal(id: number) {
  this.selectedTrainingId = id;
}

openSecondModal() {
  this.getById(this.selectedTrainingId);
}
  create(){
    this.trainingsService.create(this.trainingForm)
    .subscribe({
      next: ()=> {
        this.router.navigate(["/training"]).then(() => {
          this.get();
          this.trainingForm.thematic = "";
      });
      },
      error:(err) => {
        console.log(err);
      }
    })
  }

  get() {
    this.trainingsService.get().subscribe((data) => {
      this.allTrainings = data;
    });
  }
  delete() {

    if (confirm("Do you want remove?: ")) {
      this.trainingsService.delete(this.selectedTrainingId).subscribe(result => {
        this.get();
      });
    }
}
getById(id: number) {
  this.trainingsService.getById(id).subscribe((data) => {
    this.trainingForm = data;
  });
}

update() {
  this.trainingsService.update(this.trainingForm).subscribe({
    next:() => { 
      this.router.navigate(["training"]).then(() => {

        location.reload();      this.trainingForm.thematic = "";
  });

    },
    error:(err) => {
      console.log(err);
    }
  })
}

editTraining(training: Training) {
  this.trainingForm = { ...training };
  this.showForm = true;
}

cancelEdit() {
  this.showForm = false;
}




openTs() {
  this.trainingsService.openTs(this.selectedTrainingId,this.sessionForm.name)
  .subscribe((res)=>{
    this.data=<number>res;
    if (this.data != -1) {
      this.router.navigate(["session"]);
      location.reload();      this.trainingForm.thematic = "";
    } else {
     alert("Invalid ")
     location.reload(); 
    }
  });
}



}