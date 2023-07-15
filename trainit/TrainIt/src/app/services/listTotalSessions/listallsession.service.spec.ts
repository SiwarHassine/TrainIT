import { TestBed } from '@angular/core/testing';

import { ListallsessionService } from './listallsession.service';

describe('ListallsessionService', () => {
  let service: ListallsessionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListallsessionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
