// path: src/app/api/article-api.ts
import { API_BASE_URL } from './api-config';

export const ARTICLE_API_ROUTES = {
  base: `${API_BASE_URL}/api/article`,
  getAllArticles: ``,
  getArticleById: (id: number) => `/${id}`,
  createArticle: ``,
  updateArticle: (id: number) => `/${id}`,
  deleteArticle: (id: number) => `/${id}`,
};