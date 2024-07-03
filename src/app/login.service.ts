import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private baseUrl = 'http://localhost:8081/hospital/api/v1/login';

  constructor(private httpClient: HttpClient) {}

  userLogin(user: User): Observable<User> {
    return this.httpClient.post<User>(`${this.baseUrl}`, user);
  }
}
