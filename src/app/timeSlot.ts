// time-slot.ts
export class TimeSlot {
  static readonly SLOT_0900 = new TimeSlot('9:00 AM');
  static readonly SLOT_0920 = new TimeSlot('9:20 AM');
  static readonly SLOT_0940 = new TimeSlot('9:40 AM');
  static readonly SLOT_1000 = new TimeSlot('10:00 AM');
  static readonly SLOT_1020 = new TimeSlot('10:20 AM');
  static readonly SLOT_1040 = new TimeSlot('10:40 AM');
  static readonly SLOT_1100 = new TimeSlot('11:00 AM');
  static readonly SLOT_1120 = new TimeSlot('11:20 AM');
  static readonly SLOT_1140 = new TimeSlot('11:40 AM');
  static readonly SLOT_1200 = new TimeSlot('12:00 PM');
  static readonly SLOT_1220 = new TimeSlot('12:20 PM');
  static readonly SLOT_1240 = new TimeSlot('12:40 PM');
  static readonly SLOT_0100 = new TimeSlot('1:00 PM');
  static readonly SLOT_0120 = new TimeSlot('1:20 PM');
  static readonly SLOT_0140 = new TimeSlot('1:40 PM');
  static readonly SLOT_0200 = new TimeSlot('2:00 PM');
  static readonly SLOT_0220 = new TimeSlot('2:20 PM');
  static readonly SLOT_0240 = new TimeSlot('2:40 PM');
  static readonly SLOT_0300 = new TimeSlot('3:00 PM');
  static readonly SLOT_0320 = new TimeSlot('3:20 PM');
  static readonly SLOT_0340 = new TimeSlot('3:40 PM');
  static readonly SLOT_0400 = new TimeSlot('4:00 PM');
  static readonly SLOT_0420 = new TimeSlot('4:20 PM');
  static readonly SLOT_0440 = new TimeSlot('4:40 PM');
  static readonly SLOT_0500 = new TimeSlot('5:00 PM');
  static readonly SLOT_0520 = new TimeSlot('5:20 PM');
  static readonly SLOT_0540 = new TimeSlot('5:40 PM');
  static readonly SLOT_0600 = new TimeSlot('6:00 PM');

  private constructor(public readonly time: string) {}
}
