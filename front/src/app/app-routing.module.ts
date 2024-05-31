// path: src/app/app-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { TestComponent } from './component/test-component/test-component.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import { AuthGuard } from './services/auth.guard';
import { ThemeListComponent } from './component/theme-list-component/theme-list-component.component';
import { ThemeDetailComponent } from './component/theme-detail-component/theme-detail-component.component';
import { ArticleCreateComponent } from './component/article-create-component/article-create-component.component';
import { ArticleDetailComponent } from './component/article-detail-component/article-detail-component.component';
import { CommentListComponentComponent } from './component/comment-list-component/comment-list-component.component';
import { CommentCreateComponent } from './component/comment-create-component/comment-create-component.component';
import { NewsFeedComponent } from './component/news-feed-component/news-feed-component.component';
import { ProfileComponentComponent } from './component/profile-component/profile-component.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'test', component: TestComponent, canActivate: [AuthGuard] },
  { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'theme', component: ThemeListComponent, canActivate: [AuthGuard] },
  { path: 'theme/:id', component: ThemeDetailComponent, canActivate: [AuthGuard] }, 
  { path: 'article-create', component: ArticleCreateComponent, canActivate: [AuthGuard] },
  { path: 'article/:id', component: ArticleDetailComponent, canActivate: [AuthGuard] },
  { path: 'comment-list', component: CommentListComponentComponent, canActivate: [AuthGuard] },
  { path: 'comment-create', component: CommentCreateComponent, canActivate: [AuthGuard] },
  { path: 'feed', component: NewsFeedComponent, canActivate: [AuthGuard] },
  { path: 'profile', component: ProfileComponentComponent, canActivate: [AuthGuard] },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', redirectTo: '/login' }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
