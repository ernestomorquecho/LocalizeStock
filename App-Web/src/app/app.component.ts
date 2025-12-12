import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router'; // <--- 1. IMPORTANTE
import { ChatbotComponent } from './components/chatbot/chatbot.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ChatbotComponent], // <--- 2. AGRÉGALO AQUÍ
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'cliente-web-chatbot';
}

