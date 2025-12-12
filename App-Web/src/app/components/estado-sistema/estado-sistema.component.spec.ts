import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstadoSistemaComponent } from './estado-sistema.component';

describe('EstadoSistemaComponent', () => {
  let component: EstadoSistemaComponent;
  let fixture: ComponentFixture<EstadoSistemaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EstadoSistemaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EstadoSistemaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
