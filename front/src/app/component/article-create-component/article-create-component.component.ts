//path: src/app/component/article-create-component/article-create-component.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleService } from 'src/app/services/article-service.service';
import { Article } from 'src/app/models/article';
import { ThemeService } from 'src/app/services/theme-service.service';

@Component({
  selector: 'app-article-create',
  templateUrl: './article-create-component.component.html',
  styleUrls: ['./article-create-component.component.scss']
})
export class ArticleCreateComponent implements OnInit {
  article: Article = {
    id: 0, title: '', content: '', publicationDate: new Date(), author: '',
    comments: []
  };
  themeId: number | undefined;

  constructor(
    private articleService: ArticleService,
    private route: ActivatedRoute,
    private router: Router,
    private themeService: ThemeService
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.themeId = +params['themeId'];
    });
  }

  createArticle(): void {
    if (this.themeId) {
      this.article.publicationDate = new Date(); 
      this.articleService.createArticle(this.article).subscribe((createdArticle) => {
        if (this.themeId) {
          this.themeService.addArticleToTheme(this.themeId, createdArticle.id).subscribe(() => {
            this.router.navigate(['/theme', this.themeId]);
          });
        }
      });
    }
  }
}
