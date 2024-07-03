import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuperAdminDashComponent } from './superadmindash.component';

describe('DocdashComponent', () => {
  let component: SuperAdminDashComponent;
  let fixture: ComponentFixture<SuperAdminDashComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SuperAdminDashComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(SuperAdminDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
