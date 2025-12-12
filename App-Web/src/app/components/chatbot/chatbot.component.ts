import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common'; // Importante para que funcione todo

@Component({
  selector: 'app-chatbot',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './chatbot.component.html',
  styleUrl: './chatbot.component.css'
})
export class ChatbotComponent {
  // Signal para controlar el estado (abierto/cerrado)
  isOpen = signal(false);

  toggleChat() {
    // Invierte el valor actual (si es true pasa a false, y viceversa)
    this.isOpen.update(value => !value);
  }
}