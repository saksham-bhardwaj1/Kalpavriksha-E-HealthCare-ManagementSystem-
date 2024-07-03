import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrescribePatientComponent } from './prescribe-patient.component';

describe('PrescribePatientComponent', () => {
  let component: PrescribePatientComponent;
  let fixture: ComponentFixture<PrescribePatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PrescribePatientComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(PrescribePatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
