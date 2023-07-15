import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Session } from 'src/app/model/session';
@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private http: HttpClient) {}
  get() {
    return this.http.get<Session[]>('http://localhost:9090/getAlltrainingSessions');
  }
  //getById(id: number) {
    //return this.http.get<User>(`http://localhost:9090/getUser/${id}`);
  // }
  subscribeTraining(userId:number,trainingId:number){
    return this.http.get('http://localhost:9090/userTotrainingSession?userId='+userId+'&trainingId='+trainingId);
  }
  create(payload: Session) {
    return this.http.post<Session>('http://localhost:9090/saveTrainingSession', payload);
  }
  getByIdTrainingSession(id: number) {
    return this.http.get<Session>(`http://localhost:9090/getTrainingSession/${id}`);
   }
    
  update(payload:Session){
    return this.http.put(`http://localhost:9090/updateTrainingSession`,payload);
   }
   delete(id:number){
   return this.http.delete<Session>(`http://localhost:9090/deleteTrainingSession/${id}`);
}
 
}
