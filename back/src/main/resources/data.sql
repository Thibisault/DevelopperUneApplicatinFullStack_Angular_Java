-- Insertion des thèmes
INSERT INTO theme (id, name, description) VALUES
(1, 'Technology', 'All about the latest tech'),
(2, 'Health', 'Health and wellness tips');

INSERT INTO dbuser (username, password, role) VALUES ('dbuser', '$2y$10$.qkbukzzX21D.bqbI.B2R.tvWP90o/Y16QRWVLodw51BHft7ZWbc.', 'USER'),
('dbadmin', '$2y$10$kp1V7UYDEWn17WSK16UcmOnFd1mPFVF6UkLrOOCGtf24HOYt8p1iC', 'ADMIN');

