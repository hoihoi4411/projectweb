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
	question  text NOT NULL,
	answer  text NOT NULL,
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
INSERT INTO Pro_Users (username,password,permission) VALUES ('dungnguyen','cd25f444d32e6d98ba7f7ed9c4bd8241ee64603d93993e901b1a4c172ac4b21b',2); 
INSERT INTO Pro_Users (username,password,permission) VALUES ('hoatran','d8b663a8ad773c895e9aae849926320523c8f2fbf5a3913936fa5598a0ad12d0',2); 
INSERT INTO Pro_Users (username,password,permission) VALUES ('hienle','929affbab50b0deae4d264104b30113109f5e7ba5d0c12e6ac449ebc2e58e846',2); 
INSERT INTO Pro_Users (username,password,permission) VALUES ('huyngoc','dad39b943ec82d704ba487d27a3906930f3535de2f3d11e20085acd2d6be302b',2); 
INSERT INTO Pro_Users (username,password,permission) VALUES ('hungly','cdba3d71ad055a77123337596246a5623cc95c60bc7ec2a831bbf13ed9eb2265',2); 