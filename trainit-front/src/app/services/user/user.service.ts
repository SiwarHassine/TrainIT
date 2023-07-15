import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/model/user';
@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private http: HttpClient) {}
  get() {
    return this.http.get<User[]>('http://localhost:9090/getAllusers');
  }
  create(payload: User) {
    return this.http.post<User>('http://localhost:9090/saveUser', payload);
  }
  getById(id: number) {
    return this.http.get<User>(`http://localhost:9090/getUser/${id}`);
   }
    
  update(payload:User){
    return this.http.put(`http://localhost:9090/updateUser`,payload);
   }
   delete(id:number){
   return this.http.delete<User>(`http://localhost:9090/deleteUser/${id}`);
}

  getByManager(Manager : String){
    return this.http.get<User[]>(`http://localhost:9090/getAllusersByManager/${Manager}`);
    
  }

}
