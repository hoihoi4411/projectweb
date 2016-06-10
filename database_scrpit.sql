CREATE DATABASE PROJECT_G3;
USE  PROJECT_G3;
CREATE TABLE Pro_Users (
	uid int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	username nvarchar(30) NOT NULL UNIQUE,
	password nvarchar(65) NOT NULL,
	permission int DEFAULT(1) 	
) ; 
CREATE TABLE Pro_Lesson(
	lid int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	title  nvarchar(255) NOT NULL,
	uid int NOT NULL,
	share int DEFAULT(1) NOT NULL
);
CREATE TABLE Pro_Quiz(
	qid int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	question  nvarchar(max) NOT NULL,
	answer  nvarchar(max) NOT NULL,
	lid int NOT NULL,
);
CREATE TABLE Pro_Folder(
	fid int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	name  nvarchar(255) NOT NULL,
	uid int NOT NULL,
	sharefolder int DEFAULT(1) NOT NULL
);
CREATE TABLE Pro_Folder_PK_Pro_Lesson(
	fid int NOT NULL,
	lid int NOT NULL,
);
ALTER TABLE Pro_Quiz ADD CONSTRAINT Pro_Quiz_FK_Pro_Lesson FOREIGN KEY (lid) REFERENCES Pro_Lesson
GO
ALTER TABLE Pro_Lesson ADD CONSTRAINT Pro_Lesson_FK_Pro_Users FOREIGN KEY (uid) REFERENCES Pro_Users
GO
ALTER TABLE Pro_Folder ADD CONSTRAINT Pro_Folder_FK_Pro_Users FOREIGN KEY (uid) REFERENCES Pro_Users
GO
ALTER TABLE Pro_Folder_PK_Pro_Lesson ADD CONSTRAINT Pro_Folder_PK_Pro_Lesson_FK_Pro_Folder FOREIGN KEY (fid) REFERENCES Pro_Folder
GO
ALTER TABLE Pro_Folder_PK_Pro_Lesson ADD CONSTRAINT Pro_Folder_PK_Pro_Lesson_FK_Pro_Lesson FOREIGN KEY (lid) REFERENCES Pro_Lesson
GO
/*!--Insert table in Pro_Users */
INSERT INTO Pro_Users (username,password,permission) VALUES (N'dungnguyen','cd25f444d32e6d98ba7f7ed9c4bd8241ee64603d93993e901b1a4c172ac4b21b',2); 
INSERT INTO Pro_Users (username,password,permission) VALUES (N'hoatran','d8b663a8ad773c895e9aae849926320523c8f2fbf5a3913936fa5598a0ad12d0',2); 
INSERT INTO Pro_Users (username,password,permission) VALUES (N'hienle','929affbab50b0deae4d264104b30113109f5e7ba5d0c12e6ac449ebc2e58e846',2); 
INSERT INTO Pro_Users (username,password,permission) VALUES (N'huyngoc','dad39b943ec82d704ba487d27a3906930f3535de2f3d11e20085acd2d6be302b',2); 
INSERT INTO Pro_Users (username,password,permission) VALUES (N'hungly','cdba3d71ad055a77123337596246a5623cc95c60bc7ec2a831bbf13ed9eb2265',2); 

INSERT INTO Pro_Folder (name,sharefolder,uid) VALUES (N'Tiếng Nhật',1,2); 
INSERT INTO Pro_Folder (name,sharefolder,uid)  VALUES (N'Tiếng Anh',2,2); 
INSERT INTO Pro_Folder (name,sharefolder,uid)  VALUES (N'Introduction to Database',3,2); 
INSERT INTO Pro_Folder (name,sharefolder,uid)  VALUES (N'Java',1,2); 
INSERT INTO Pro_Folder (name,sharefolder,uid)  VALUES (N'Csharp',3,2);
INSERT INTO Pro_Folder (name,sharefolder,uid)  VALUES (N'Bảng Cửu Chương',1,2);
 

INSERT INTO Pro_Folder (name,sharefolder,uid) VALUES (N'Tiếng Hàn',1,3); 
INSERT INTO Pro_Folder (name,sharefolder,uid)  VALUES (N'C cơ bản',2,3); 
INSERT INTO Pro_Folder (name,sharefolder,uid)  VALUES (N'Hệ Điều Hành',3,3); 
INSERT INTO Pro_Folder (name,sharefolder,uid)  VALUES (N'Core Java',1,3); 
INSERT INTO Pro_Folder (name,sharefolder,uid)  VALUES (N'OOP',3,3); 
INSERT INTO Pro_Folder (name,sharefolder,uid)  VALUES (N'Cấu trúc Dữ liệu',3,3); 
INSERT INTO Pro_Folder (name,sharefolder,uid)  VALUES (N'Bảng Cửu Chương',1,3);


INSERT INTO Pro_Lesson (title,uid,share)  VALUES (N'Progetest1',2,3); 
INSERT INTO Pro_Lesson (title,uid,share)  VALUES (N'Quiz Bank bài 1',2,3); 
INSERT INTO Pro_Lesson (title,uid,share)  VALUES (N'Quiz Bank bài 2',2,3); 
INSERT INTO Pro_Lesson (title,uid,share)  VALUES (N'Bang cuu chuong 1',2,3); 

INSERT INTO Pro_Lesson (title,uid,share)  VALUES (N'Progetest2',3,3); 
INSERT INTO Pro_Lesson (title,uid,share)  VALUES (N'Quiz Bank bài 1',3,3); 
INSERT INTO Pro_Lesson (title,uid,share)  VALUES (N'Quiz Bank bài 2',3,3); 
INSERT INTO Pro_Lesson (title,uid,share)  VALUES (N'Bang cuu chuong 2',3,3); 
INSERT INTO Pro_Lesson (title,uid,share)  VALUES (N'Bang cuu chuong 4',3,3); 

/*insert quiz*/

INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('na','na',1);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('ni','ni',1);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('nu','nu',1);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('ne','ne',1);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('no','no',1);

INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('hello','xin chao',2);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('i','toi',2);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('father','cha',2);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('mother','me',2);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('goodbye','tam biet',2);

INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('hello','xin chao',3);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('i','toi',3);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('father','cha',3);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('mother','me',3);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('goodbye','tam biet',3);


INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('1*1','1',4);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('1*2','2',4);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('1*3','3',4);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('1*4','4',4);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('1*5','5',4);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('1*6','6',4);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('1*7','7',4);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('1*8','8',4);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('1*9','9',4);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('1*10','10',4);

INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('ha','ha',5);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('hi','hi',5);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('fu','fu',5);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('he','he',5);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('ho','ho',5);

INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('%d','int',6);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('%c','char',6);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('char[]','string',6);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('%f','float',6);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('%lf','long',6);

INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('lenh in','printf',7);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('xuong dong','/n',7);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('tab','/t',7);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('nhan du lieu','scanf',7);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('xoa bo nho dem','fflush(stdin)',7);


INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('2*1','2',8);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('2*2','4',8);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('2*3','6',8);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('2*4','8',8);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('2*5','10',8);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('2*6','12',8);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('2*7','14',8);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('2*8','16',8);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('2*9','18',8);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('2*10','20',8);

INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('4*1','4',9);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('4*2','8',9);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('4*3','12',9);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('4*4','16',9);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('4*5','20',9);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('4*6','24',9);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('4*7','28',9);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('4*8','32',9);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('4*9','18',9);
INSERT INTO Pro_Quiz (question,answer,lid) VALUES ('4*10','20',9);


INSERT INTO Pro_Folder_PK_Pro_Lesson (fid, lid) VALUES ('1','1');
INSERT INTO Pro_Folder_PK_Pro_Lesson (fid, lid) VALUES ('2','2');
INSERT INTO Pro_Folder_PK_Pro_Lesson (fid, lid) VALUES ('2','3');
INSERT INTO Pro_Folder_PK_Pro_Lesson (fid, lid) VALUES ('6','4');


INSERT INTO Pro_Folder_PK_Pro_Lesson (fid, lid) VALUES ('7','5');
INSERT INTO Pro_Folder_PK_Pro_Lesson (fid, lid) VALUES ('8','6');
INSERT INTO Pro_Folder_PK_Pro_Lesson (fid, lid) VALUES ('8','7');
INSERT INTO Pro_Folder_PK_Pro_Lesson (fid, lid) VALUES ('13','8');
INSERT INTO Pro_Folder_PK_Pro_Lesson (fid, lid) VALUES ('13','9'); 





