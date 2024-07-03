import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';

@Injectable({
  providedIn: 'root',
})
export class AppointmentService {
  private baseUrl = 'http://localhost:8081/appointment/api/v3';

  constructor(private httpClient: HttpClient) {}

  getAppointmentslist(): Observable<Appointment[]> {
    return this.httpClient.get<Appointment[]>(`${this.baseUrl}/appointments`);
  }

  createAppointment(appointment: Appointment): Observable<Appointment> {
    return this.httpClient.post<Appointment>(
      `${this.baseUrl}/appointments`,
      appointment
    );
  }

  getAppointmentById(id: number): Observable<Appointment> {
    return this.httpClient.get<Appointment>(
      `${this.baseUrl}/appointments/${id}`
    );
  }

  deleteAppointment(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/appointments/${id}`);
  }

  getTimeSlots(): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.baseUrl}/timeSlots`);
  }

  getAvailableTimeSlots(date: string): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.baseUrl}/availableTimeSlots`, {
      params: { date },
    });
  }
}
