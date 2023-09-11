INSERT INTO contest_edition (id, edition_year, submission_deadline, phase1voting_deadline, phase2voting_deadline)
VALUES  (1, 1824, '1824-01-01', '1824-02-01', '1824-03-01'),
        (2, 2024, '2024-01-01', '2024-02-01', '2024-03-01');

INSERT INTO juror (id, handle)
VALUES  (1, 'Alice'),
        (2, 'Bob'),
        (3, 'Cynthia'),
        (4, 'David');

INSERT INTO contest_jury (contest_id, juror_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (2, 3),
       (2, 4);

INSERT INTO rpg (id, system, version)
VALUES (1, 'Dungeons & Dragons', 'ADnD'),
       (2, 'Dungeons & Dragons', '5E'),
       (3, 'Warhammer', '4E'),
       (4, 'Call of Cthulhu', '7E'),
       (5, 'City of Mist', NULL);

INSERT INTO submission (title, description, author, rpg_id, edition_id)
VALUES ('Submission #1', 'Some description', 'Author #1', 1, 1),
       ('Submission #2', ':D', 'Author #2', 1, 1),
       ('Submission #3', NULL, 'Author #3', 4, 1),
       ('Submission #4', NULL, 'Author #4', 5, 2);