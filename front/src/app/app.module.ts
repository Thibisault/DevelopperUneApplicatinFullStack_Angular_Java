// path: src/app/app.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatRadioModule } from '@angular/material/radio';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { TestComponent } from './component/test-component/test-component.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RegisterComponent } from './component/register/register.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { NewsFeedComponent } from './component/news-feed-component/news-feed-component.component';
import { ThemeListComponent } from './component/theme-list-component/theme-list-component.component';
import { ArticleCreateComponent } from './component/article-create-component/article-create-component.component';
import { ArticleDetailComponent } from './component/article-detail-component/article-detail-component.component';
import { CommentListComponentComponent } from './component/comment-list-component/comment-list-component.component';
import { ProfileComponentComponent } from './component/profile-component/profile-component.component';

import { AuthInterceptor } from './interceptors/auth.interceptor';
import { ThemeDetailComponent  } from './component/theme-detail-component/theme-detail-component.component';
import { CommentCreateComponent } from './component/comment-create-component/comment-create-component.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TestComponent,
    RegisterComponent,
    NavbarComponent,
    NewsFeedComponent,
    ThemeListComponent,
    ArticleCreateComponent,
    ArticleDetailComponent,
    CommentListComponentComponent,
    ProfileComponentComponent,
    ThemeDetailComponent,
    CommentCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatToolbarModule,
    MatRadioModule,
    HttpClientModule,
    FormsModule,
    CommonModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
