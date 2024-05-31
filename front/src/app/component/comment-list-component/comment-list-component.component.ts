//path: src/app/component/comment-list-component/comment-list-component.component.ts
import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommentService } from 'src/app/services/comment-service.service';
import { Comment } from 'src/app/models/comment';

@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list-component.component.html',
  styleUrls: ['./comment-list-component.component.scss']
})
export class CommentListComponentComponent implements OnInit {
  comment: Comment | undefined;

  constructor(
    private route: ActivatedRoute,
    private commentService: CommentService,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    this.commentService.getCommentById(id).subscribe(data => {
      this.comment = data;
      this.cdr.detectChanges(); 
    });
  }
}
