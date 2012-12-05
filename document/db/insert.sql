select * from User;
UPDATE User SET say="" WHERE e_mail = "pooingx2@gmail.com";

select interest_id from Interest_list where interest= "music";

select * from Interest_list;
insert into Interest_list(interest, interest_id)
values("computer",0);


select * from User_Interest_list;
insert into User_Interest_list(e_mail, interest_id)
values("pooingx2@gmail.com",2);

select * from User natural join User_Interest_list natural join Interest_list
where e_mail = "pooingx2@gmail.com";

select * from User natural join User_Interest_list natural join Interest_list;
insert into User_Interest_list (e_mail, interest_id)
value ("pooingx2@gmail.com", 14);

delete from User_Interest_list
where e_mail="pooingx2@gmail.com";

select * from User_Interest_list where e_mail = "pooingx2@gmail.com";
select * from User natural join User_Interest_list natural join Interest_list 
where e_mail = "pooingx2@gmail.com";

select interest, e_mail from User_Interest_list natural join Interest_list 
where e_mail = "pooingx2@gmail.com";

select *from Opinion;
insert into Opinion(content, mt_id, sub_id, opinion_id, e_mail, honor)
values("yeah he is really good6",2,2,7,"pooingx2@gmail.com",100);

select *from Participant;
insert into Participant(request, report, mt_id, e_mail, flag)
values("n",100,2,"pooingx2@gmail.com","n");



select *from memo_list;
select *from SubTopic;

select * from User;
SELECT * FROM User_Interest_list;

SELECT * FROM MainTopic;
SELECT COUNT(*) FROM MainTopic;

SELECT * FROM MainTopic;

SELECT * FROM MainTopic 
ORDER BY (agree+disagree) DESC;

SELECT * FROM Following_list;
SELECT u.e_mail, u.name, u.photo FROM User u, Following_list f
where  u.e_mail = f.e_mail and f.following = "pooingx2@gmail.com" ;

INSERT INTO Following_list(e_mail,following)
VALUES("dongseop@gmail.com","pooingx2@gmail.com");

SELECT * FROM MainTopic
WHERE mt_title LIKE CONCAT('%',"topic1",'%');

SELECT * FROM MainTopic 
WHERE mt_title LIKE '%'"topic1"'%'
LIMIT 0, 2;

SELECT COUNT(DISTINCT mt_id)
FROM MainTopic natural join MainTopic_TopicTag natural join TopicTag
WHERE tag LIKE CONCAT('%',"music",'%');

SELECT COUNT(mt_id)
FROM MainTopic natural join MainTopic_TopicTag natural join TopicTag
WHERE tag LIKE CONCAT('%',"music",'%');

SELECT DISTINCT mt_title,agree,disagree,date,m_close,mt_id,e_mail 
FROM MainTopic natural join MainTopic_TopicTag natural join TopicTag
WHERE tag LIKE CONCAT('%',"music",'%')
LIMIT 0, 2;

SELECT *
FROM MainTopic natural join MainTopic_TopicTag natural join TopicTag
WHERE tag LIKE CONCAT('%',"music",'%');


SELECT mt_title,agree,disagree,date,m_close,mt_id,e_mail
FROM MainTopic;

SELECT *
FROM MainTopic;