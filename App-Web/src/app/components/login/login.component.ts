import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../../services/data.service';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  errorMsg = '';

  constructor(private router: Router, private dataService: DataService) {}

  // ESTA ES LA FUNCIÓN QUE FALTABA O ESTABA MAL ESCRITA
  onLogin(user: string, pass: string) {
    this.dataService.login(user, pass).subscribe((response: any) => {
      if (response.success) {
        this.router.navigate(['/app']); // Redirige al dashboard
      } else {
        this.errorMsg = response.message || 'Error';
      }
    });
  }
}