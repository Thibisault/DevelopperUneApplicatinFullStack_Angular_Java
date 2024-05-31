// path: src/app/services/auth.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AUTH_API_ROUTES } from '../api/auth-api';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    return this.http.post(`${AUTH_API_ROUTES.base}${AUTH_API_ROUTES.login}`, { username, password });
  }

  register(username: string, password: string, role: string): Observable<any> {
    return this.http.post(`${AUTH_API_ROUTES.base}${AUTH_API_ROUTES.register}`, { username, password, role });
  }

  logout(): void {
    localStorage.removeItem('token');
  }

  setToken(token: string): void {
    localStorage.setItem('token', token);
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }
}
