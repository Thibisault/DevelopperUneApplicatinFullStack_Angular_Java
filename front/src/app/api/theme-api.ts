// path: src/app/api/theme-api.ts
import { API_BASE_URL } from './api-config';

export const THEME_API_ROUTES = {
  base: `${API_BASE_URL}/api/theme`,
  getAllThemes: '',
  getThemeById: (id: number) => `/${id}`,
  createTheme: '',
  updateTheme: (id: number) => `/${id}`,
  deleteTheme: (id: number) => `/${id}`,
  subscribe: (themeId: number) => `/subscribe/${themeId}`,
  unsubscribe: (themeId: number) => `/unsubscribe/${themeId}`,
};
