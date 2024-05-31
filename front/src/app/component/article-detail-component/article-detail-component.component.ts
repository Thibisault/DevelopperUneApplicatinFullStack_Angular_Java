//path: src/app/component/article-detail-component/article-detail-component.component.ts
import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ArticleService } from 'src/app/services/article-service.service';
import { Article } from 'src/app/models/article';

@Component({
  selector: 'app-article-detail',
  templateUrl: './article-detail-component.component.html',
  styleUrls: ['./article-detail-component.component.scss']
})
export class ArticleDetailComponent implements OnInit {
  article: Article | undefined;

  constructor(
    private route: ActivatedRoute,
    private articleService: ArticleService,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];

    this.articleService.getArticleById(id).subscribe(data => {
      if (data && data.publicationDate) {
        data.publicationDate = new Date(data.publicationDate);
      }
      this.article = data;
      this.cdr.detectChanges();
    });
  }
}
