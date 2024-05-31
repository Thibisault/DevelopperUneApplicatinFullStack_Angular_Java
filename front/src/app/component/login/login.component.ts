// path: src/app/component/login/login.component.ts
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { AuthService } from '../../services/auth.service';
import { CommonModule } from '@angular/common';  

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    CommonModule  
  ],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private router: Router, private authService: AuthService) {}

  onSubmit() {
    if (!this.password) {
      this.errorMessage = 'Password cannot be empty';
      return;
    }

    this.authService.login(this.username, this.password).subscribe(
      response => {
        if (response.status === 'success') {
          this.authService.setToken(response.token);
          this.router.navigate(['/home']);
        } else {
          this.errorMessage = 'Login failed';
        }
      },
      error => this.errorMessage = 'An error occurred'
    );
  }

  navigateToRegister() {
    this.router.navigate(['/register']);
  }
}
