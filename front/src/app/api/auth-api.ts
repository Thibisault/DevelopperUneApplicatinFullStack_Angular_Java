// path: src/app/api/auth-api.ts
import { API_BASE_URL } from './api-config';

export const AUTH_API_ROUTES = {
  base: `${API_BASE_URL}/api/auth`,
  login: `/login`,
  register: `/register`,
};
