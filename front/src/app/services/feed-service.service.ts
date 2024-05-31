import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FEED_API_ROUTES } from '../api/feed-api';
import { Article } from 'src/app/models/article';

@Injectable({
  providedIn: 'root'
})
export class FeedServiceService {
  constructor(private http: HttpClient) { }

  getAllFeeds(): Observable<Map<string, Article[]>> {
    return this.http.get<Map<string, Article[]>>(FEED_API_ROUTES.base + FEED_API_ROUTES.all);
  }
}
