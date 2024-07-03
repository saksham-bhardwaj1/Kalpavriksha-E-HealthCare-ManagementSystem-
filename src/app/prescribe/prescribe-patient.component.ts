import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
import { Location } from '@angular/common';
import { Prescription } from '../prescription';
import { PrescriptionService } from '../prescription.service';
import { MedicineService } from '../medicine.service';
import { Medicine } from '../medicine';

@Component({
  selector: 'app-update-patient',
  templateUrl: './prescribe-patient.component.html',
  styleUrls: ['./prescribe-patient.component.css'],
})
export class PrescribePatientComponent implements OnInit {
  prescription: Prescription = new Prescription();
  medicines: Medicine[];
  constructor(
    private prescriptionService: PrescriptionService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    private medicineService: MedicineService
  ) {}

  ngOnInit(): void {
    this.getMedicines();
  }

  onSubmit() {
    this.prescription.patientId = this.route.snapshot.params['id'];
    this.prescription.doctorId = Number(localStorage.getItem('id'));

    this.prescriptionService.createPrescription(this.prescription).subscribe(
      (data) => {
        this.goToPatientlist();
        alert('Prescription added successfully !');
      },
      (error) => {
        alert(`Something Went Wrong : ${console.log(error)}`);
      }
    );
  }
  getMedicines() {
    this.medicineService.getMedicinesList().subscribe((data) => {
      this.medicines = data;
    });
  }

  goToPatientlist() {
    this.router.navigate(['/admindash']);
  }
  goBack(): void {
    this.location.back();
  }
}
