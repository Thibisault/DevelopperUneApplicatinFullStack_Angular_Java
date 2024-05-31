import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user-service.service';
import { ThemeService } from 'src/app/services/theme-service.service';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile-component.component.html',
  styleUrls: ['./profile-component.component.scss']
})
export class ProfileComponentComponent implements OnInit {
  user: User = {
    id: 0,
    username: '',
    password: '',
    role: '',
    subscribedThemes: []
  };
  errorMessage: string = '';

  constructor(private userService: UserService, private themeService: ThemeService, private authService: AuthService) { }

  ngOnInit(): void {
    this.userService.getCurrentUser().subscribe(
      data => {
        this.user = data;
      },
      error => {
        this.errorMessage = 'Failed to load user data';
      }
    );
  }

  updateProfile(): void {
    this.userService.updateUserProfile(this.user).subscribe(
      response => {
        if (response.status === 'success') {
          this.authService.setToken(response.token);
          alert('Profil mis à jour avec succès');
        } else {
          this.errorMessage = 'Profile update failed';
        }
      },
      error => {
        this.errorMessage = 'An error occurred';
      }
    );
  }

  unsubscribe(themeId: number): void {
    this.themeService.unsubscribeFromTheme(themeId).subscribe(() => {
      this.user.subscribedThemes = this.user.subscribedThemes.filter(theme => theme.id !== themeId);
    });
  }
}
