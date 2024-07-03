import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Prescription } from './prescription';

@Injectable({
  providedIn: 'root',
})
export class PrescriptionService {
  private baseUrl = 'http://localhost:8081/hospital/api/v1/prescriptions';

  constructor(private httpClient: HttpClient) {}

  getPrescriptionslist(): Observable<Prescription[]> {
    return this.httpClient.get<Prescription[]>(`${this.baseUrl}`);
  }

  createPrescription(Prescription: Prescription): Observable<Prescription> {
    return this.httpClient.post<Prescription>(`${this.baseUrl}`, Prescription);
  }

  getPrescriptionById(id: number): Observable<Prescription> {
    return this.httpClient.get<Prescription>(`${this.baseUrl}/${id}`);
  }

  updatePrescription(
    id: number,
    Prescription: Prescription
  ): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/${id}`, Prescription);
  }

  deletePrescription(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
