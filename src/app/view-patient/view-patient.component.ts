import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { Location } from '@angular/common';
import { History } from '../history';

@Component({
  selector: 'app-view-patient',
  templateUrl: './view-patient.component.html',
  styleUrls: ['./view-patient.component.css'],
})
export class ViewPatientComponent implements OnInit {
  id: number;
  patient: Patient;
  historylist: History[];
  medicineNames: { [key: number]: string } = {};
  constructor(
    private route: ActivatedRoute,
    private patientService: PatientService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.patient = new Patient();
    this.patientService.getHistory(this.id).subscribe(
      (data: History[]) => {
        this.historylist = data;
        this.fetchMedicineNames(data);
      },
      (error) => {
        console.error('Error fetching patient history:', error);
      }
    );
    this.patientService.getPatientById(this.id).subscribe((data) => {
      this.patient = data;
    });
  }
  goBack(): void {
    this.location.back();
  }
  isAdmin() {
    return localStorage.getItem('type') == 'admin';
  }
  isPatient() {
    return !(localStorage.getItem('type') == 'user');
  }
  fetchMedicineNames(visits: History[]): void {
    visits.forEach((visit) => {
      visit.prescriptions.forEach((prescription) => {
        if (
          prescription.medicineId &&
          !this.medicineNames[prescription.medicineId]
        ) {
          this.patientService
            .getMedicineName(prescription.medicineId)
            .subscribe(
              (response: any) => {
                this.medicineNames[prescription.medicineId] = response.drugName;
              },
              (error) => {
                console.error('Error fetching medicine name:', error);
              }
            );
        }
      });
    });
  }

  getMedicineName(id: number): string {
    return this.medicineNames[id] || 'Loading...';
  }
}
