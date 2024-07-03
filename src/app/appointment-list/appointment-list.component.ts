import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {
  isReceptionist: boolean = false;

  appointments: Appointment[];

  constructor(private appointmentService: AppointmentService,
    private router: Router) { }

  ngOnInit(): void { 
    const userType = localStorage.getItem('type');
  this.isReceptionist = userType === 'receptionist';

    this.getAppointments();
  }

  private getAppointments() {
    this.appointmentService.getAppointmentslist().subscribe(data => {this.appointments = data;
      });
  }

  deleteAppointment(id: number){ 
    this.appointmentService.deleteAppointment(id).subscribe( data => { 
      console.log(data);
      this.getAppointments();
    })
  }

}
