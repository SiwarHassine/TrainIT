import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ListTotalSessions } from 'src/app/model/list-total-sessions';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ListallsessionService {

  constructor(private http: HttpClient) {}

  getAllSessions() :  Observable<ListTotalSessions[]> {
    return this.http.get<ListTotalSessions[]>('http://localhost:9090/getAlltrainingSessionDetails');
  }

  getSessionById(idUser:number,idTrainingsession:number) {
    return this.http.get<ListTotalSessions>('http://localhost:9090/getSessionDetailstById?idUser='+idUser+'&idTrainingsession='+idTrainingsession);
   }

  updateStatus(idUser:number,idTrainingsession:number ,status:String){
    return this.http.get('http://localhost:9090/changeStatus?idUser='+idUser+'&idTrainingsession='+idTrainingsession+'&status='+status);
  }

getSessionByUser(idUser:number){
  return this.http.get<ListTotalSessions[]>('http://localhost:9090/getAllSessionDetailstById?idUser='+idUser);

}


getScore(idUser:number){
  return this.http.get<Number[]>('http://localhost:9090/getNumberSessionByuser?idUser='+idUser);
}
}
