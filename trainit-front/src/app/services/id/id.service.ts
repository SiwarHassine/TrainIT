import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class IdService {
  constructor(private http: HttpClient) {}
  private userData = new BehaviorSubject<any>(null);

  setUserData(data: any) {
    localStorage.setItem('userData', JSON.stringify(data));
    this.userData.next(data);
  }

  getUserData() {
    return this.userData.asObservable();
  }


  logout() {
    localStorage.removeItem('userData');
    this.userData.next(null);
  }


  getUserRole(name:string)  {
    return this.http.get<String[]>(`http://localhost:9090/getUserRole/${name}`);
  }

  getUserId(name:string) {
    return this.http.get<string>(`http://localhost:9090/getUserId/${name}`);
  }
}
