//path: src/app/component/theme-detail-component/theme-detail-component.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Theme } from 'src/app/models/theme';
import { ThemeService } from 'src/app/services/theme-service.service';

@Component({
  selector: 'app-theme-detail',
  templateUrl: './theme-detail-component.component.html',
  styleUrls: ['./theme-detail-component.component.scss']
})
export class ThemeDetailComponent implements OnInit {
  theme: Theme | undefined;

  constructor(private route: ActivatedRoute, private themeService: ThemeService) { }

  ngOnInit(): void {
    const themeId = +this.route.snapshot.paramMap.get('id')!;
    this.themeService.getThemeById(themeId).subscribe((data: Theme) => {
      this.theme = data;
    });
  }
}
