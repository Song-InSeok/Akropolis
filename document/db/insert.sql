select * from User;
UPDATE User SET say="asdasd" WHERE e_mail = "pooingx2@gmail.com";

insert into User(e_mail,name,say,photo,honor,dishonor)
values("pooingx2@gmail.com","juyoung","Hello!!","http://",63,5);

select interest_id from Interest_list where interest= "music";

select * from Interest_list;
insert into Interest_list(interest, interest_id)
values("computer",0);

delete from Interest_list where interest_id=7;

select * from User_Interest_list;
insert into User_Interest_list(e_mail, interest_id)
values("pooingx2@gmail.com",2);

delete from User_Interest_list WHERE e_mail = "pooing@gmail.com";

select * from User natural join User_Education_list natural join Education_list
where e_mail = "pooingx2@gmail.com";


select interest from User natural join User_Interest_list natural join Interest_list
where e_mail = "pooingx2@gmail.com";

select * from User_Interest_list where e_mail = "pooingx2@gmail.com";
select * from User natural join User_Interest_list natural join Interest_list 
where e_mail = "pooingx2@gmail.com";

select interest, e_mail from User_Interest_list natural join Interest_list 
where e_mail = "pooingx2@gmail.com";

select *from Opinion;
UPDATE Opinion SET e_mail="pooing@gmail.com" WHERE e_mail = "pooingx2@gmail.com";
insert into Opinion(content, mt_id, sub_id, opinion_id, e_mail, honor)
values("yeah he is really good6",2,2,7,"pooingx2@gmail.com",100);

select *from Participant;
delete from Participant where e_mail="pooing@gmail.com";
insert into Participant(request, report, mt_id, e_mail, flag)
values("n",100,2,"pooingx2@gmail.com","n");

SET SQL_SAFE_UPDATES=0;

select *from memo_list;
select *from SubTopic;

select * from User;
SELECT * FROM User_Interest_list;

SELECT * FROM MainTopic;
SELECT COUNT(*) FROM MainTopic;

SELECT * FROM MainTopic;

SELECT * FROM MainTopic 
ORDER BY (agree+disagree) DESC;

