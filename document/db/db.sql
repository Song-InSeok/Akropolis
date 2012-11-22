
CREATE TABLE Education_list
(
	education            VARCHAR(20) NULL,
	education_id         INTEGER NOT NULL
);



ALTER TABLE Education_list
ADD PRIMARY KEY (education_id);



CREATE TABLE Following_list
(
	e_mail               VARCHAR(50) NOT NULL,
	following            VARCHAR(50) NOT NULL
);



ALTER TABLE Following_list
ADD PRIMARY KEY (e_mail,following);



CREATE TABLE Interest_list
(
	interest             VARCHAR(20) NULL,
	interest_id          INTEGER NOT NULL
);



ALTER TABLE Interest_list
ADD PRIMARY KEY (interest_id);



CREATE TABLE MainTopic
(
	mt_title             VARCHAR(255) NOT NULL,
	agree                INTEGER NULL DEFAULT 0,
	disagree             INTEGER NULL DEFAULT 0,
	TIMESTAMP                 TIMESTAMP NOT NULL DEFAULT now(),
	m_close              CHAR(1) NULL CHECK ( m_close IN ('O', 'C') ),
	mt_id                INTEGER NOT NULL,
	e_mail               VARCHAR(50) NOT NULL
);



ALTER TABLE MainTopic
ADD PRIMARY KEY (mt_id);



CREATE TABLE MainTopic_TopicTag
(
	mt_id                INTEGER NOT NULL,
	tag_id               INTEGER NOT NULL
);



ALTER TABLE MainTopic_TopicTag
ADD PRIMARY KEY (mt_id,tag_id);



CREATE TABLE memo_list
(
	memo                 TEXT NULL,
	e_mail               VARCHAR(50) NOT NULL,
	o_mail               VARCHAR(50) NOT NULL CHECK ( e_mail != o_mail )
);



ALTER TABLE memo_list
ADD PRIMARY KEY (e_mail,o_mail);



CREATE TABLE Opinion
(
	content              TEXT NULL,
	mt_id                INTEGER NOT NULL,
	sub_id               INTEGER NOT NULL,
	opinion_id           INTEGER NOT NULL,
	e_mail               VARCHAR(50) NOT NULL,
	honor                INTEGER NULL DEFAULT 0
);



ALTER TABLE Opinion
ADD PRIMARY KEY (mt_id,sub_id,opinion_id);



CREATE TABLE Participant
(
	request              CHAR(1) NOT NULL CHECK ( request IN ('Y', 'D') ),
	report               INTEGER NULL DEFAULT 0,
	mt_id                INTEGER NOT NULL,
	e_mail               VARCHAR(50) NOT NULL,
	flag                 CHAR(1) NULL CHECK ( flag IN ('Y', 'N', 'C', 'NULL') )
);



ALTER TABLE Participant
ADD PRIMARY KEY (mt_id,e_mail);



CREATE TABLE SubTopic
(
	sub_title            VARCHAR(255) NOT NULL,
	start_time           TIMESTAMP NULL DEFAULT now(),
	end_time             TIMESTAMP NULL CHECK ( end_time > start_time ),
	sub_id               INTEGER NOT NULL,
	sub_close            CHAR(1) NULL CHECK ( sub_close IN ('O', 'C') ),
	mt_id                INTEGER NOT NULL
);



ALTER TABLE SubTopic
ADD PRIMARY KEY (sub_id,mt_id);



CREATE TABLE TopicTag
(
	tag                  VARCHAR(20) NULL,
	tag_id               INTEGER NOT NULL
);



ALTER TABLE TopicTag
ADD PRIMARY KEY (tag_id);



CREATE TABLE User
(
	e_mail               VARCHAR(50) NOT NULL,
	name                 VARCHAR(20) NOT NULL,
	say                  TEXT NULL,
	photo                VARCHAR(255) NOT NULL,
	honor                INTEGER NULL DEFAULT 0,
	dishonor             INTEGER NULL DEFAULT 0
);



ALTER TABLE User
ADD PRIMARY KEY (e_mail);



CREATE TABLE User_Education_list
(
	e_mail               VARCHAR(50) NOT NULL,
	education_id         INTEGER NOT NULL
);



ALTER TABLE User_Education_list
ADD PRIMARY KEY (e_mail,education_id);



CREATE TABLE User_Interest_list
(
	e_mail               VARCHAR(50) NOT NULL,
	interest_id          INTEGER NOT NULL
);



ALTER TABLE User_Interest_list
ADD PRIMARY KEY (e_mail,interest_id);



ALTER TABLE Following_list
ADD FOREIGN KEY R_29 (e_mail) REFERENCES User (e_mail);



ALTER TABLE Following_list
ADD FOREIGN KEY R_37 (following) REFERENCES User (e_mail);



ALTER TABLE MainTopic
ADD FOREIGN KEY R_10 (e_mail) REFERENCES User (e_mail);



ALTER TABLE MainTopic_TopicTag
ADD FOREIGN KEY R_34 (mt_id) REFERENCES MainTopic (mt_id);



ALTER TABLE MainTopic_TopicTag
ADD FOREIGN KEY R_43 (tag_id) REFERENCES TopicTag (tag_id);



ALTER TABLE memo_list
ADD FOREIGN KEY R_20 (e_mail) REFERENCES User (e_mail);



ALTER TABLE memo_list
ADD FOREIGN KEY R_24 (o_mail) REFERENCES User (e_mail);



ALTER TABLE Opinion
ADD FOREIGN KEY R_11 (sub_id, mt_id) REFERENCES SubTopic (sub_id, mt_id);



ALTER TABLE Opinion
ADD FOREIGN KEY R_15 (mt_id, e_mail) REFERENCES Participant (mt_id, e_mail);



ALTER TABLE Participant
ADD FOREIGN KEY R_13 (mt_id) REFERENCES MainTopic (mt_id);



ALTER TABLE Participant
ADD FOREIGN KEY R_14 (e_mail) REFERENCES User (e_mail);



ALTER TABLE SubTopic
ADD FOREIGN KEY R_9 (mt_id) REFERENCES MainTopic (mt_id);



ALTER TABLE User_Education_list
ADD FOREIGN KEY R_30 (e_mail) REFERENCES User (e_mail);



ALTER TABLE User_Education_list
ADD FOREIGN KEY R_41 (education_id) REFERENCES Education_list (education_id);



ALTER TABLE User_Interest_list
ADD FOREIGN KEY R_31 (e_mail) REFERENCES User (e_mail);



ALTER TABLE User_Interest_list
ADD FOREIGN KEY R_39 (interest_id) REFERENCES Interest_list (interest_id);


