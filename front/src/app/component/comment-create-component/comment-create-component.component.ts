//path: src/app/component/comment-create-component/comment-create-component.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommentService } from 'src/app/services/comment-service.service';
import { Comment } from 'src/app/models/comment';
import { ArticleService } from 'src/app/services/article-service.service';

@Component({
  selector: 'app-comment-create',
  templateUrl: './comment-create-component.component.html',
  styleUrls: ['./comment-create-component.component.scss']
})
export class CommentCreateComponent implements OnInit {
  comment: Comment = {
    id: 0, content: '', author: '', createdDate: new Date()
  };
  articleId: number | undefined;

  constructor(
    private commentService: CommentService,
    private route: ActivatedRoute,
    private router: Router,
    private articleService: ArticleService
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.articleId = +params['articleId'];
    });
  }

  createComment(): void {
    if (this.articleId) {
      this.commentService.createComment(this.comment).subscribe((createdComment) => {
        if (this.articleId) {
          this.articleService.addCommentToArticle(this.articleId, createdComment.id).subscribe(() => {
            this.router.navigate(['/article', this.articleId]);
          });
        } 
      });
    }
  }
}
