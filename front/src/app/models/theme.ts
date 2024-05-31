//path: src/app/models/theme.ts
import { Article } from './article';

export interface Theme {
  id: number;
  name: string;
  description: string;
  articles: Article[];

}
