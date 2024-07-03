import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';
import { User } from './user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private baseUrl = 'http://localhost:8081/hospital/api/v1/admin';

  constructor(private httpClient: HttpClient) {}

  getUserList(): Observable<User[]> {
    return this.httpClient.get<User[]>(`${this.baseUrl}`);
  }

  createUser(appointment: User): Observable<User> {
    return this.httpClient.post<User>(`${this.baseUrl}`, appointment);
  }

  getUserById(id: number): Observable<User> {
    return this.httpClient.get<User>(`${this.baseUrl}/${id}`);
  }

  deleteUser(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
