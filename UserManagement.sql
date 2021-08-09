CREATE DATABASE UserManagement

USE UserManagement

CREATE TABLE RoleUser(  Id int  NOT NULL PRIMARY KEY,
         RoleName nvarchar(50),
		 RoleStatus int
		 )

CREATE TABLE tblUser( UserId int NOT NULL PRIMARY KEY,
         UserName nvarchar(50),
         Password nvarchar(50),
         DisplayName nvarchar(50),
         Email nvarchar(50),
		 Phone nvarchar(20),
		 Address nvarchar(50),
		 Photo nvarchar(50),
         CreateDate date,
         UserStatus int,
  
         RoleId int FOREIGN KEY
                                        REFERENCES RoleUser(Id))

CREATE TABLE tblPromotion( PromotionId nvarchar(50) NOT NULL PRIMARY KEY,
		 Photo nvarchar(50),
		 RankPromotion float,
         CreateDate date,
         PromotionStatus int,
  
         UserId int FOREIGN KEY
                                        REFERENCES tblUser(UserId))

CREATE TABLE History( HistoryId nvarchar(50) NOT NULL PRIMARY KEY,
		 UserId int,
		 Description nvarchar(50),
         CreateDate date,
  
         PromotionId nvarchar(50) FOREIGN KEY
                                        REFERENCES tblPromotion(PromotionId))