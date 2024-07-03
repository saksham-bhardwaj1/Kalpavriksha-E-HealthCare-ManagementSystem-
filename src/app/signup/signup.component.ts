import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  user: User = new User();

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {}
  saveUser() {
    this.userService.createUser(this.user).subscribe(
      (data) => {
        console.log(data);
        alert('User created successfully!');
        this.router.navigate(['/login']);
      },
      (error) => {
        console.log(error);
        alert('User with username already exists !');
      }
    );
  }

  onSubmit() {
    console.log(this.user);
    this.saveUser();
  }
}
