//path: src/app/api/comment-api.ts
import { API_BASE_URL } from './api-config';

export const COMMENT_API_ROUTES = {
  base: `${API_BASE_URL}/api/comment`,
  getAllComments: ``,
  getCommentById: (id: number) => `/${id}`,
  createComment: ``,
  updateComment: (id: number) => `/${id}`,
  deleteComment: (id: number) => `/${id}`,
};
