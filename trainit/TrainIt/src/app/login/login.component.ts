import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login/login.service';
import { Router } from '@angular/router';
import { IdService } from '../services/id/id.service';
import { User } from '../model/user';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  model: any = {};
  getData: number=0;
iduser:number=0;
  constructor(private router: Router, private loginService: LoginService,private id: IdService) { }

  ngOnInit(): void {
 
  }

  userForm: User = {
    id: 0,
    name: '',
    password:"",
    role:"",
  };

    loginUser() {
    var user = this.model.name;
    var password = this.model.password;
    this.userForm.name=this.model.name;
    this.loginService.getUserData(user, password).subscribe((res) => {
        this.getData=<number>res;
        if (this.getData != -1) {

          this.id.getUserRole(user).subscribe((data) => {
            this.userForm.role=data[0];
            this.id.setUserData(this.userForm);
                   this.id.getUserId(user).subscribe((res) => {
                        this.userForm.id=parseInt(res[0]);
                        this.id.setUserData(this.userForm);
                        console.log(this.userForm)
              
                     });

          });
          
         this.router.navigate(["/home"])
        } 
        else {
         alert("Invalid user")
        }
      });

  
  }
}
