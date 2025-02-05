INSERT INTO gym_clubs (name, location, discount, annual_revenue) VALUES
('Chanhassen', 'TX', 10, 100000),
('Minnetonka', 'NY', 0, 150000),
('Crosstown (Eden Prairie)', 'SF', 0, 120000),
('Eden Prairie Athletic', 'NY', 15, 150000),
('Oakdale Village Tennis', 'NY', 0, 150000),
('Plymouth', 'NY', 0, 150000),
('Bloomington South', 'NY', 0, 150000),
('Life Time Swim Maple Grove', 'NY', 0, 150000),
('Highland Park', 'NY', 0, 150000),
('Lakeville', 'NY', 0, 150000);

INSERT INTO facilities (name) VALUES
('Swimming'),
('Yoga'),
('Basketball'),
('Make up'),
('Tennis');

INSERT INTO gym_club_facilities (gym_club_id, facility_id) VALUES
(1, 1),  -- Chanhassen has Swimming
(8, 1),  -- Life Time Swim Maple Grove has Swimming
(9, 1),  -- Highland Park has Swimming

(1, 2),  -- Chanhassen has Yoga
(2, 2),  -- Minnetonka has Yoga
(3, 2),  -- Crosstown (Eden Prairie) has Yoga
(4, 2),  -- Eden Prairie Athletic has Yoga
(9, 2),  -- Highland Park has Yoga

(2, 3),  -- Minnetonka has Basketball

(3, 4),  -- Crosstown (Eden Prairie) has Make up
(5, 4),  -- Oakdale Village Tennis has Make up
(10, 4), -- Lakeville has Make up

(2, 5),  -- Minnetonka has Tennis
(4, 5),  -- Eden Prairie Athletic has Tennis
(5, 5),  -- Oakdale Village Tennis has Tennis
(9, 5);  -- Highland Park has Tennis