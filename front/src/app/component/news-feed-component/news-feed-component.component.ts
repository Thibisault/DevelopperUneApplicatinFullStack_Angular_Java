// path: src/app/component/news-feed-component/news-feed-component.component.ts
import { Component, OnInit } from '@angular/core';
import { FeedServiceService } from 'src/app/services/feed-service.service';
import { Article } from 'src/app/models/article';

interface ArticleWithTheme extends Article {
  themeName: string;
}

@Component({
  selector: 'app-news-feed',
  templateUrl: './news-feed-component.component.html',
  styleUrls: ['./news-feed-component.component.scss']
})
export class NewsFeedComponent implements OnInit {
  articles: ArticleWithTheme[] = [];

  constructor(private feedService: FeedServiceService) { }

  ngOnInit(): void {
    this.feedService.getAllFeeds().subscribe((data: Map<string, Article[]>) => {
      this.articles = [];
      for (let [themeName, articles] of Object.entries(data)) {
        for (let article of articles) {
          this.articles.push({ ...article, themeName });
        }
      }
      this.articles.sort((a, b) => new Date(b.publicationDate).getTime() - new Date(a.publicationDate).getTime());
    });
  }
}
