// path: src/app/models/article.ts
import { Comment } from './comment';

export interface Article {
  id: number;
  title: string;
  content: string;
  publicationDate: Date; 
  author: string;

  comments: Comment[];


}
