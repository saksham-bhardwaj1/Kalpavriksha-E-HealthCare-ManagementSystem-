import { Prescription } from './prescription';

export class History {
  id: number;
  diagnosis: string;
  treatment: string;
  visitDate: string;
  doctorName: string;
  prescriptions: Prescription[];
}
