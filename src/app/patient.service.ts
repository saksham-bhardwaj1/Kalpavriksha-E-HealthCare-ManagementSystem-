import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './patient';
import { History } from './history';

@Injectable({
  providedIn: 'root',
})
export class PatientService {
  private baseUrl = 'http://localhost:8081/hospital/api/v1/admin';
  private historyUrl = 'http://localhost:8081/hospital/api/v1/patient-history';
  private medicineUrl = 'http://localhost:8081/medicine/api/v2/medicines';

  constructor(private httpClient: HttpClient) {}

  getPatientslist(): Observable<Patient[]> {
    return this.httpClient.get<Patient[]>(`${this.baseUrl}?type=user`);
  }

  createPatient(patient: Patient): Observable<Patient> {
    return this.httpClient.post<Patient>(`${this.baseUrl}`, patient);
  }

  getPatientById(id: number): Observable<Patient> {
    return this.httpClient.get<Patient>(`${this.baseUrl}/${id}`);
  }

  updatePatient(id: number, patient: Patient): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/${id}`, patient);
  }

  deletePatient(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }

  getHistory(id: number): Observable<History[]> {
    return this.httpClient.get<History[]>(`${this.historyUrl}/${id}`);
  }
  getMedicineName(id: number): Observable<any> {
    return this.httpClient.get<any>(`${this.medicineUrl}/${id}`);
  }
  getDoctorList(): Observable<Patient[]> {
    return this.httpClient.get<Patient[]>(`${this.baseUrl}?type=doctor`);
  }
}
 