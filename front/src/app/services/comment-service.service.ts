//path: src/app/services/comment-service.service.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comment } from 'src/app/models/comment';
import { COMMENT_API_ROUTES } from '../api/comment-api';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  constructor(private http: HttpClient) { }

  getAllComments(): Observable<Comment[]> {
    return this.http.get<Comment[]>(COMMENT_API_ROUTES.base + COMMENT_API_ROUTES.getAllComments);
  }

  getCommentById(id: number): Observable<Comment> {
    return this.http.get<Comment>(COMMENT_API_ROUTES.base + COMMENT_API_ROUTES.getCommentById(id));
  }

  createComment(comment: Comment): Observable<Comment> {
    return this.http.post<Comment>(COMMENT_API_ROUTES.base + COMMENT_API_ROUTES.createComment, comment);
  }

  updateComment(id: number, comment: Comment): Observable<Comment> {
    return this.http.put<Comment>(COMMENT_API_ROUTES.base + COMMENT_API_ROUTES.updateComment(id), comment);
  }

  deleteComment(id: number): Observable<void> {
    return this.http.delete<void>(COMMENT_API_ROUTES.base + COMMENT_API_ROUTES.deleteComment(id));
  }
}
