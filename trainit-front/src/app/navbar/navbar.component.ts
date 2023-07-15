import { Component, OnInit } from '@angular/core';
import { IdService } from '../services/id/id.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
 


  userName: string = "" ;

  iduser:number=0;
  userRole:string=""; 
  constructor(private idService: IdService, private router: Router) { }

  ngOnInit(): void {

    const userDataStr = localStorage.getItem('userData');
    if (userDataStr) {
      const userData = JSON.parse(userDataStr);
      this.idService.setUserData(userData);
    }

    this.idService.getUserData().subscribe((data) => {
      
      this.userName = data.name;
      this.userRole=data.role;
   
    })

    

        }

    logout() {
      this.idService.logout();
      this.router.navigate([""]).then(() => {

        location.reload();    
  });
    }


    
  }


 
