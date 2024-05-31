// path: src/app/services/theme-service.service.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Theme } from 'src/app/models/theme';
import { THEME_API_ROUTES } from '../api/theme-api';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  constructor(private http: HttpClient) {}

  getAllThemes(): Observable<Theme[]> {
    return this.http.get<Theme[]>(`${THEME_API_ROUTES.base}${THEME_API_ROUTES.getAllThemes}`);
  }

  getThemeById(id: number): Observable<Theme> {
    return this.http.get<Theme>(`${THEME_API_ROUTES.base}${THEME_API_ROUTES.getThemeById(id)}`);
  }

  createTheme(theme: Theme): Observable<Theme> {
    return this.http.post<Theme>(`${THEME_API_ROUTES.base}${THEME_API_ROUTES.createTheme}`, theme);
  }

  updateTheme(id: number, theme: Theme): Observable<Theme> {
    return this.http.put<Theme>(`${THEME_API_ROUTES.base}${THEME_API_ROUTES.updateTheme(id)}`, theme);
  }

  deleteTheme(id: number): Observable<void> {
    return this.http.delete<void>(`${THEME_API_ROUTES.base}${THEME_API_ROUTES.deleteTheme(id)}`);
  }

  subscribeToTheme(themeId: number): Observable<any> {
    return this.http.post(`${THEME_API_ROUTES.base}${THEME_API_ROUTES.subscribe(themeId)}`, {});
  }

  unsubscribeFromTheme(themeId: number): Observable<any> {
    return this.http.post(`${THEME_API_ROUTES.base}${THEME_API_ROUTES.unsubscribe(themeId)}`, {});
  }

  addArticleToTheme(themeId: number, articleId: number): Observable<any> {
    return this.http.post(`${THEME_API_ROUTES.base}/addArticleToTheme`, { themeId, articleId });
  }
}
