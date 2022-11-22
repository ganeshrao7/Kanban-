import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColumnsOfTaskComponent } from './columns-of-task.component';

describe('ColumnsOfTaskComponent', () => {
  let component: ColumnsOfTaskComponent;
  let fixture: ComponentFixture<ColumnsOfTaskComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ColumnsOfTaskComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ColumnsOfTaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
