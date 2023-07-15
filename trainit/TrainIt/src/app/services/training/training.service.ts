import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Training } from 'src/app/model/training';
@Injectable({
  providedIn: 'root'
})
export class TrainingService {

 
  constructor(private http: HttpClient) {}
  get() {
    return this.http.get<Training[]>('http://localhost:9090/getAlltraining');
  }
  create(payload: Training) {
    return this.http.post<Training>('http://localhost:9090/saveTraining', payload);
  }
  getById(id: number) {
    return this.http.get<Training>(`http://localhost:9090/getTraining/${id}`);
   }
    
  update(payload:Training){
    return this.http.put(`http://localhost:9090/updateTraining`,payload);
   }
  delete(id:number){
   return this.http.delete<Training>(`http://localhost:9090/deleteTraining/${id}`);
}
openTs(trainingId:number,name:String){
  return this.http.get('http://localhost:9090/trainingToTrainingSession?trainingId='+trainingId+'&name='+name);
}
}
