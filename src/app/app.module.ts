import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewsfeedComponent } from './newsfeed/newsfeed.component';
import { DocloginComponent } from './doclogin/doclogin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { DocdashComponent } from './docdash/docdash.component';
import { AdmindashComponent } from './admindash/admindash.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AuthGaurdService } from './auth-gaurd.service';
import { CreatepatientComponent } from './createpatient/createpatient.component';
import { AuthenticationService } from './authentication.service';
import { UpdatePatientComponent } from './update-patient/update-patient.component';
import { MedicineListComponent } from './medicine-list/medicine-list.component';
import { CreatemedicineComponent } from './createmedicine/createmedicine.component';
import { UpdateMedicineComponent } from './update-medicine/update-medicine.component';
import { AppointmentListComponent } from './appointment-list/appointment-list.component';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';
import { ViewPatientComponent } from './view-patient/view-patient.component';
// import { SuperAdminLoginComponent } from './superadminlogin/superadminlogin.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { TestimonialComponent } from './testimonial/testimonial.component';
import { TreatmentComponent } from './treatment/treatment.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { SuperAdminDashComponent } from './superadmindash/superadmindash.component';
import { DisplayHtmlComponent } from './display/display.component';
import { UserAgentInterceptor } from './UserAgentInterceptor';
import { PatientdashComponent } from './patientdash/patient.component';
import { PrescribePatientComponent } from './prescribe/prescribe-patient.component';
const routes: Routes = [
  { path: '', component: NewsfeedComponent },
  { path: 'doclogin', component: DocloginComponent },
  { path: 'adlogin', component: AdminloginComponent },
  { path: 'home', component: NewsfeedComponent },
  { path: 'about', component: AboutComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'testimonial', component: TestimonialComponent },
  { path: 'treatment', component: TreatmentComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'display-bill/:id', component: DisplayHtmlComponent },
  {
    path: 'createpatient',
    component: CreatepatientComponent,
    canActivate: [AuthGaurdService],
  },
  {
    path: 'docdash',
    component: DocdashComponent,
    canActivate: [AuthGaurdService],
  },
  {
    path: 'updatepatient/:id',
    component: UpdatePatientComponent,
    canActivate: [AuthGaurdService],
  },
  {
    path: 'admindash',
    component: AdmindashComponent,
    canActivate: [AuthGaurdService],
  },
  {
    path: 'medicinelist',
    component: MedicineListComponent,
    canActivate: [AuthGaurdService],
  },
  {
    path: 'createmedicine',
    component: CreatemedicineComponent,
    canActivate: [AuthGaurdService],
  },
  {
    path: 'updatemedicine/:id',
    component: UpdateMedicineComponent,
    canActivate: [AuthGaurdService],
  },
  {
    path: 'appointmentlist',
    component: AppointmentListComponent,
    canActivate: [AuthGaurdService],
  },
  {
    path: 'createappointment',
    component: CreateAppointmentComponent,
    canActivate: [AuthGaurdService],
  },
  { path: 'viewpatient/:id', component: ViewPatientComponent },
  // { path: 'superadminlogin', component: SuperAdminLoginComponent },
  { path: 'superadmindash', component: SuperAdminDashComponent },
  { path: 'patientdash', component: PatientdashComponent },
  {
    path: 'prescribe/:id',
    component: PrescribePatientComponent,
    canActivate: [AuthGaurdService],
  },
];

@NgModule({
  declarations: [
    AppComponent,
    NewsfeedComponent,
    DocloginComponent,
    AdminloginComponent,
    DocdashComponent,
    AdmindashComponent,
    CreatepatientComponent,
    UpdatePatientComponent,
    MedicineListComponent,
    CreatemedicineComponent,
    UpdateMedicineComponent,
    AppointmentListComponent,
    CreateAppointmentComponent,
    ViewPatientComponent,
    // SuperAdminLoginComponent,
    SignupComponent,
    LoginComponent,
    SuperAdminDashComponent,
    PrescribePatientComponent,
  ],
  imports: [
    RouterModule.forRoot(routes),
    FormsModule,
    BrowserModule,
    Ng2SearchPipeModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: UserAgentInterceptor,
      multi: true, // This is crucial to add if you have multiple interceptors
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
