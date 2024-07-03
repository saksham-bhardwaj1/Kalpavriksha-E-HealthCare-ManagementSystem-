// api.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class ApiService {
  constructor(private http: HttpClient) {}

  fetchHTMLFromAPI(id: number): Observable<string> {
    const apiUrl = `http://localhost:8081/patient/api/v1/patient/patient/bill/${id}`;
    return this.http.get<string>(apiUrl, { responseType: 'text' as 'json' });
  }
}
