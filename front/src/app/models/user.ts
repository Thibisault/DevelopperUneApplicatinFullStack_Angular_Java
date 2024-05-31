// path: src/app/models/user.ts
import { Theme } from './theme';

export interface User {
  id: number;
  username: string;
  password: string;
  role: string;
  subscribedThemes: Theme[];
}
