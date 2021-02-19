import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TechgenerationComponent } from './techgeneration.component';

describe('TechgenerationComponent', () => {
  let component: TechgenerationComponent;
  let fixture: ComponentFixture<TechgenerationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TechgenerationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TechgenerationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
