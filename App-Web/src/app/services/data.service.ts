import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs'; // <--- Importamos 'of' para la simulación

@Injectable({
  providedIn: 'root'
})
export class DataService {
  // La URL de tu compañero (Backend)
  private apiUrl = 'http://10.251.232.62:8080/LocalizeStock/api/productos';

  constructor(private http: HttpClient) { }

  // ----------------------------------------------------
  // 1. LOGIN SIMULADO (Para que puedas entrar YA)
  // ----------------------------------------------------
  login(user: string, pass: string): Observable<any> {
    // Si es admin/1234, te deja pasar
    if (user === 'admin' && pass === '1234') {
      return of({ success: true, token: 'token-falso-acceso' });
    }
    return of({ success: false, message: 'Credenciales incorrectas' });
  }

  // ----------------------------------------------------
  // 2. PRODUCTOS REALES (Conectado al Backend)
  // ----------------------------------------------------
  getProductos(): Observable<any> {
    // Esto sí va a buscar los datos a la computadora de tu compañero
    return this.http.get(`${this.apiUrl}/productos`);
  }

  // Chatbot (Por ahora simulado hasta que tengas la URL real)
  enviarMensajeChat(mensaje: string): Observable<any> {
    // return this.http.post(`${this.apiUrl}/chatbot`, { mensaje }); // <--- Descomentar cuando esté listo
    return of({ respuesta: "Soy un bot simulado. El backend aún no conecta la IA." });
  }
}