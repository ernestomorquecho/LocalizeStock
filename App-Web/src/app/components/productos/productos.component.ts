import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; 
import { DataService } from '../../services/data.service';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {
  productos: any[] = []; // <--- AQUÍ SE GUARDAN LOS DATOS

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.dataService.getProductos().subscribe(
      (data: any) => {
        console.log('📦 DATOS RECIBIDOS DEL BACKEND:', data); // <--- MIRA ESTO EN LA CONSOLA (F12)
        this.productos = data; // Guardamos lo que llegó en la variable
      },
      (error) => {
        console.error('❌ Error al pedir productos:', error);
      }
    );
  }
}