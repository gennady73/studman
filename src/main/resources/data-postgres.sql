INSERT INTO student (id, age, first_name, last_name, email) VALUES
(1, 31, 'John', 'Doe', 'johndoe@gmail.com'),
(2, 33, 'Jane', 'Doe', 'janedoe@gmail.com'),
(3, 35, 'Jim', 'Smith', 'jimsmith@gmail.com');

INSERT INTO course (id, name) VALUES
(1, 'Math'),
(2, 'English'),
(3, 'History'),
(4, 'Biology'),
(5, 'Chemistry'),
(6, 'Physics'),
(7, 'Computer Science'),
(8, 'Art');

INSERT INTO enrollment (id, student_id, course_id, grade) VALUES
(1, 1, 1, 89),
(2, 1, 2, 92),
(3, 1, 3, 94),
(4, 2, 4, 82),
(5, 2, 5, 79),
(6, 2, 6, 80),
(7, 3, 7, 90),
(8, 3, 8, 93),
(9, 3, 1, 88),
(10, 3, 2, 84);
