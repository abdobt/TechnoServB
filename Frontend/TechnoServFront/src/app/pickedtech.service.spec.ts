import { TestBed } from '@angular/core/testing';

import { PickedtechService } from './pickedtech.service';

describe('PickedtechService', () => {
  let service: PickedtechService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PickedtechService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
