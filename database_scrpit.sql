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