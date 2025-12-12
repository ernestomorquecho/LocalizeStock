import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ProductosComponent } from './components/productos/productos.component';
import { TiendasComponent } from './components/tiendas/tiendas.component';
import { HistorialComponent } from './components/historial/historial.component';
import { EstadoSistemaComponent } from './components/estado-sistema/estado-sistema.component';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' }, // Redirigir a login al entrar
  { path: 'login', component: LoginComponent },
  { 
    path: 'app', 
    component: DashboardComponent, // El dashboard contiene el menú lateral
    children: [
      { path: 'productos', component: ProductosComponent },
      { path: 'tiendas', component: TiendasComponent },
      { path: 'historial', component: HistorialComponent },
      { path: 'estado', component: EstadoSistemaComponent },
      { path: '', redirectTo: 'productos', pathMatch: 'full' }
    ]
  }
];