INSERT INTO post (id, user_id, content, tags)
VALUES (
        '68299394-c544-4e61-955a-fba4b80f0eb3',
        'user1',
        'post1',
        '{}'
       );
INSERT INTO comment (id, user_id, post_id, comment)
VALUES (
           '33754fe6-80b2-4fee-a380-57ddefb1bfb0',
           'user1',
           '68299394-c544-4e61-955a-fba4b80f0eb3',
           'comment1'
       );
INSERT INTO comment (id, user_id, post_id, comment)
VALUES (
           'd57a206f-08c9-44c0-a28b-8878aa71a913',
           'user2',
           '68299394-c544-4e61-955a-fba4b80f0eb3',
           'comment2'
       );
INSERT INTO post (id, user_id, content, tags)
VALUES (
           'd462e821-1aa9-4fdc-89e9-37b90ecf6203',
           'user2',
           'post2',
           '{}'
       );
INSERT INTO comment (id, user_id, post_id, comment)
VALUES (
           '22555454-25dc-4b24-a1d0-a46234aafa6f',
           'user1',
           'd462e821-1aa9-4fdc-89e9-37b90ecf6203',
           'comment1'
       );
INSERT INTO comment (id, user_id, post_id, comment)
VALUES (
           '9aae72f6-9e33-470b-8a9b-c4453bee344b',
           'user2',
           'd462e821-1aa9-4fdc-89e9-37b90ecf6203',
           'comment2'
       );
INSERT INTO post (id, user_id, content, tags)
VALUES (
           'd99205b1-486b-4dba-8ab4-42ee25550fdd',
           'user3',
           'post3',
           '{}'
       );
INSERT INTO comment (id, user_id, post_id, comment)
VALUES (
           '93ef7f26-d981-48d0-a241-5e1076d16bd9',
           'user1',
           'd99205b1-486b-4dba-8ab4-42ee25550fdd',
           'comment1'
       );
INSERT INTO comment (id, user_id, post_id, comment)
VALUES (
           '415cd4a9-c875-4f5e-bd6d-6f1677347529',
           'user2',
           'd99205b1-486b-4dba-8ab4-42ee25550fdd',
           'comment2'
       );

