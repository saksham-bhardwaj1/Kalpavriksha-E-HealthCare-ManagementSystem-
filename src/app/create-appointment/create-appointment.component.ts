import { Component, OnInit } from '@angular/core';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';

@Component({
  selector: 'app-create-appointment',
  templateUrl: './create-appointment.component.html',
  styleUrls: ['./create-appointment.component.css'],
})
export class CreateAppointmentComponent implements OnInit {
  appointment: Appointment = new Appointment();
  timeSlots: string[] = [];
  selectedDate: string;
  selectedTimeSlot: string; // Renamed to selectedTimeSlot for clarity
  timeSlotTable: string[][] = [];
  doctors: Patient[]; 
  constructor(
    private appointmentService: AppointmentService,
    private patientService: PatientService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getTimeSlots(); // Call getTimeSlots when component initializes
    this.patientService.getDoctorList().subscribe((data) =>{
      this.doctors = data;
    });
  }

  saveAppointment() {
    this.appointmentService.createAppointment(this.appointment).subscribe(
      (data) => {
        console.log(data);
        this.goToAppointmentList();
      },
      (error) => console.log(error)
    );
  }

  goToAppointmentList() {
    this.router.navigate(['/appointmentlist']);
  }

  onSubmit() {
    console.log(this.appointment);
    this.saveAppointment();
  }

  private getTimeSlots() {
    this.appointmentService.getTimeSlots().subscribe((data) => {
      this.timeSlots = data;
      this.generateTimeSlotTable();
    });
  }
  generateTimeSlotTable() {
    this.timeSlotTable = [];
    const rows = 5; // Example number of rows
    const cols = 10; // Example number of columns
    let index = 0;

    for (let i = 0; i < rows; i++) {
      let row: string[] = [];
      for (let j = 0; j < cols; j++) {
        if (index < this.timeSlots.length) {
          row.push(this.timeSlots[index]);
          index++;
        } else {
          row.push('');
        }
      }
      this.timeSlotTable.push(row);
    }
  }
  onDateChange() {
    if (this.selectedDate) {
      this.appointmentService
        .getAvailableTimeSlots(this.selectedDate)
        .subscribe((data) => {
          this.timeSlots = data;
          this.generateTimeSlotTable();
        });
      this.appointment.date = this.selectedDate;
    }
  }
  isTimeSlotAvailable(timeSlot: string): boolean {
    return this.timeSlots.includes(timeSlot);
  }
  selectTimeSlot(timeSlot: string) {
    if (this.isTimeSlotAvailable(timeSlot)) {
      this.selectedTimeSlot = timeSlot;
      this.appointment.timeSlot = timeSlot;
      console.log('Selected Time Slot:', this.selectedTimeSlot);
    }
  }
  isSelected(timeSlot: string): boolean {
    return timeSlot === this.selectedTimeSlot;
  }
  onCancel() {
    this.appointment = new Appointment();
    this.selectedDate = '';
    this.selectedTimeSlot = '';
  }
}
