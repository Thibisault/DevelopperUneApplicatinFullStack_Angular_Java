// path: src/app/component/navbar/navbar.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  constructor(private router: Router, private authService: AuthService) {}

  navigateToHome() {
    this.router.navigate(['/home']);
  }

  navigateToTheme() {
    this.router.navigate(['/theme']);
  }

  navigateToArticleCreate() {
    this.router.navigate(['/article-create']);
  }

  navigateToArticleDetail() {
    this.router.navigate(['/article-detail']);
  }

  navigateToCommentList() {
    this.router.navigate(['/comment-list']);
  }

  navigateToFeed() {
    this.router.navigate(['/feed']);
  }

  navigateToProfile() {
    this.router.navigate(['/profile']);
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
