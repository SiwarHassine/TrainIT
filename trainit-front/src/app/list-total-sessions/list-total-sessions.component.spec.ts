import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListTotalSessionsComponent } from './list-total-sessions.component';

describe('ListTotalSessionsComponent', () => {
  let component: ListTotalSessionsComponent;
  let fixture: ComponentFixture<ListTotalSessionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListTotalSessionsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListTotalSessionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
