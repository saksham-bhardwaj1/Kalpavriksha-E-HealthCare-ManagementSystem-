import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  constructor() {}

  authenticate(username: string, password: string) {
    if (username === 'receptionist' && password === 'password') {
      localStorage.setItem('username', username);
      return true;
    } else {
      return false;
    }
  }
  authenticateAdmin(username: string, password: string) {
    if (username === 'admin' && password === 'password') {
      localStorage.setItem('username', username);
      return true;
    } else {
      return false;
    }
  }

  isUserLoggedIn() {
    let user = localStorage.getItem('username');
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    localStorage.removeItem('username');
  }
}
