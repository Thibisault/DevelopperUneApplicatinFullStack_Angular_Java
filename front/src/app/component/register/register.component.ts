// path: src/app/component/register/register.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  username: string = '';
  password: string = '';
  role: string = '';
  errorMessage: string = '';

  constructor(private router: Router, private authService: AuthService) {}

  onSubmit() {
    if (!this.username) {
      this.errorMessage = 'Username cannot be empty';
      return;
    }

    if (!this.password) {
      this.errorMessage = 'Password cannot be empty';
      return;
    }

    if (!this.role) {
      this.errorMessage = 'Please select a role';
      return;
    }

    this.authService.register(this.username, this.password, this.role).subscribe(
      response => {
        if (response.status === 'success') {
          localStorage.setItem('token', response.token);
          this.router.navigate(['/home']); 
        } else {
          this.errorMessage = response.message;
        }
      },
      error => {
        this.errorMessage = 'An error occurred';
      }
    );
  }

  navigateToLogin() {
    this.router.navigate(['/login']);
  }
}
