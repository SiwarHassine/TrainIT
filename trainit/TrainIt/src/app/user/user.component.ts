import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../services/user/user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  allUsers: User[] = [];
  deleteModal: any;
  idTodelete: number = 0;
  userForm: User = {
    id: 0,
    name: '',
    password:"",
    role:"",
  };
  selectedTrainingId: number=0;

  searchText: string = '';
  filteredUsers: any[] = [];

  constructor(private userService: UserService, private router:Router) {
    this.filteredUsers = this.allUsers;
  }

  filterUsers() {
    this.filteredUsers = this.allUsers.filter((user) => {
      return user.name.toLowerCase().indexOf(this.searchText.toLowerCase()) !== -1;
    });
  }
 
  ngOnInit(): void {
    this.get();
  }
 
  openFirstModal(id: number) {
    this.selectedTrainingId = id;
  }
  
  openSecondModal() {
    this.getById(this.selectedTrainingId);
  }

  get() {
    this.userService.get().subscribe((data) => {
      this.allUsers = data;
    });
  }
  delete() {
    if (confirm("Do you want remove?")) {
      this.userService.delete(this.selectedTrainingId).subscribe(result => {
        this.get();
      });
    }
}


create(){
  this.userService.create(this.userForm)
  .subscribe({
    next:() => {
      this.router.navigate(["/user"]).then(() => {
        this.get();
        this.userForm.name = "";
    });
    },
    error:(err) => {
      console.log(err);
    }
  })
}

getById(id: number) {
  this.userService.getById(id).subscribe((data) => {
    this.userForm = data;
  });
}

update() {
  this.userService.update(this.userForm).subscribe({
    next:() => {
      this.router.navigate(["user"]).then(() => {

        location.reload();      this.userForm.name = "";
  });
    },
    error:(err) => {
      console.log(err);
    }
  })
}
}
