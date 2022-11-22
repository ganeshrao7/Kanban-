import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOfKanbansComponent } from './list-of-kanbans.component';

describe('ListOfKanbansComponent', () => {
  let component: ListOfKanbansComponent;
  let fixture: ComponentFixture<ListOfKanbansComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListOfKanbansComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListOfKanbansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
