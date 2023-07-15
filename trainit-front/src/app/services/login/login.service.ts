import { Injectable } from '@angular/core';
import { User } from 'src/app/model/user';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {}

  getById(id: number) {
    return this.http.get<User>(`http://localhost:9090/getUser/${id}`);
   }
  getUserData(name: string,password: string){
    return this.http.get('http://localhost:9090/verfUser/'+name+'/'+password);
  }

  getUserRole(name:string) {
    return this.http.get<string>(`http://localhost:9090/getUserRole/${name}`);
  }

  getUserId(name:string) {
    return this.http.get<string>(`http://localhost:9090/getUserId/${name}`);
  }
 

}
