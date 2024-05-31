// path: src/app/services/article-service.service.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { Article } from 'src/app/models/article';
import { ARTICLE_API_ROUTES } from '../api/article-api';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  constructor(private http: HttpClient) { }

  getAllArticles(): Observable<Article[]> {
    return this.http.get<Article[]>(ARTICLE_API_ROUTES.base + ARTICLE_API_ROUTES.getAllArticles);
  }

  getArticleById(id: number): Observable<Article> {
    return this.http.get<Article>(ARTICLE_API_ROUTES.base + ARTICLE_API_ROUTES.getArticleById(id));
  }

  createArticle(article: Article): Observable<Article> {
    return this.http.post<Article>(ARTICLE_API_ROUTES.base + ARTICLE_API_ROUTES.createArticle, article)
  }

  updateArticle(id: number, article: Article): Observable<Article> {
    return this.http.put<Article>(ARTICLE_API_ROUTES.base + ARTICLE_API_ROUTES.updateArticle(id), article);
  }

  deleteArticle(id: number): Observable<void> {
    return this.http.delete<void>(ARTICLE_API_ROUTES.base + ARTICLE_API_ROUTES.deleteArticle(id));
  }

  addCommentToArticle(articleId: number, commentId: number): Observable<any> {
    return this.http.post(`${ARTICLE_API_ROUTES.base}/addCommentToArticle`, { articleId, commentId });
  }

}