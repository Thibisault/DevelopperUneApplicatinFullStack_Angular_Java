import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Theme } from 'src/app/models/theme';
import { ThemeService } from 'src/app/services/theme-service.service';
import { UserService } from 'src/app/services/user-service.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-theme-list',
  templateUrl: './theme-list-component.component.html',
  styleUrls: ['./theme-list-component.component.scss']
})
export class ThemeListComponent implements OnInit {
  themes: Theme[] = [];
  user: User = { id: 0, username: '', password: '', role: '', subscribedThemes: [] };

  constructor(
    private themeService: ThemeService,
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.themeService.getAllThemes().subscribe((data: Theme[]) => {
      this.themes = data;
    });

    this.userService.getCurrentUser().subscribe((data: User) => {
      this.user = data;
    });
  }

  subscribe(themeId: number, event: Event): void {
    event.stopPropagation();
    event.preventDefault();
    this.themeService.subscribeToTheme(themeId).subscribe(() => {
      const theme = this.themes.find(theme => theme.id === themeId);
      if (theme) {
        this.user.subscribedThemes.push(theme);
      }
    });
  }

  unsubscribe(themeId: number, event: Event): void {
    event.stopPropagation();
    event.preventDefault();
    this.themeService.unsubscribeFromTheme(themeId).subscribe(() => {
      this.user.subscribedThemes = this.user.subscribedThemes.filter(theme => theme.id !== themeId);
    });
  }

  viewDetails(themeId: number): void {
    this.router.navigate(['/theme', themeId]); 
  }

  isSubscribed(themeId: number): boolean {
    return this.user?.subscribedThemes.some(theme => theme.id === themeId);
  }
}
