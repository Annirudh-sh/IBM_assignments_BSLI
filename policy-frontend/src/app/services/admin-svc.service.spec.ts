import { TestBed } from '@angular/core/testing';

import { AdminSvcService } from './admin-svc.service';

describe('AdminServiceService', () => {
  let service: AdminSvcService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminSvcService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
