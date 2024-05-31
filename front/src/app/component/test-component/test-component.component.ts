// path: src/app/component/test-component/test-component.component.ts
import { Component, OnInit } from '@angular/core';
import { TestService } from '../../services/testService';

@Component({
  selector: 'app-test-component',
  template: `
    <p>Response 1: {{ response1 }}</p>
    <p>Response 2: {{ response2 }}</p>
    <p>Response 3: {{ response3 }}</p>
  `
})
export class TestComponent implements OnInit {
  response1: string;
  response2: string;
  response3: string;

  constructor(private testService: TestService) {
    this.response1 = '';
    this.response2 = '';
    this.response3 = '';
  }

  ngOnInit() {
    this.testService.getRoute1().subscribe({
      next: data => {
        this.response1 = data.toString();
      },
      error: error => {
        console.error('Error fetching data: ', error);
      }
    });

    this.testService.getRoute2().subscribe({
      next: data => {
        this.response2 = data.toString();
      },
      error: error => {
        console.error('Error fetching data: ', error);
      }
    });

    this.testService.getRoute().subscribe({
      next: data => {
        this.response3 = data.toString();
      },
      error: error => {
        console.error('Error fetching data: ', error);
      }
    });
  }
}