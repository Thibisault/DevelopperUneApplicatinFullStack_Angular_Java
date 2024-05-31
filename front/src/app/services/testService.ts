//path: src/app/services/testService.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TEST_API_ROUTES } from '../api/test-api';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private http: HttpClient) { }

  getRoute() {
    return this.http.get(`${TEST_API_ROUTES.base}${TEST_API_ROUTES.route}`);
  }

  getRoute1() {
    return this.http.get(`${TEST_API_ROUTES.base}${TEST_API_ROUTES.route1}`);
  }

  getRoute2() {
    return this.http.get(`${TEST_API_ROUTES.base}${TEST_API_ROUTES.route2}`);
  }
}
