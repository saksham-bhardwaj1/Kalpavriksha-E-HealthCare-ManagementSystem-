import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-about',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  user: User = new User();

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {}
  saveUser() {
    this.loginService.userLogin(this.user).subscribe(
      (data) => {
        console.log(data);
        localStorage.setItem('username', data.username);
        localStorage.setItem('type', data.type);
        localStorage.setItem('id', data.id.toString());

        if (data.type.toLowerCase() == 'doctor') {
          this.router.navigate(['/admindash']);
        }
        if (data.type.toLowerCase() == 'receptionist') {
          this.router.navigate(['/docdash']);
        }
        if (data.type.toLowerCase() == 'admin') {
          this.router.navigate(['/superadmindash']);
        }
        if (data.type.toLowerCase() == 'user') {
          this.router.navigate(['viewpatient', data.id]);
        }
      },
      (error) => console.log(error)
    );
  }

  onSubmit() {
    console.log(this.user);
    this.saveUser();
  }
}
