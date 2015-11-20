CREATE TABLE tbl_user (
    "id" INT NOT NULL,
    "email" VARCHAR(100) NOT NULL,
    "password" VARCHAR(300) NOT NULL,
    "salt" CHAR(50) NOT NULL,
    "firstName" VARCHAR(100) NOT NULL,
    "lastName" VARCHAR(100) NOT NULL,
    "isActive" BOOLEAN DEFAULT (1),
    "autoLogin" BOOLEAN DEFAULT (1),
    "dateCreated" DATETIME NOT NULL,
    "avatarFileName" TEXT
);
CREATE TABLE sqlite_sequence(name,seq);
CREATE TABLE tbl_group (
    "id" INTEGER NOT NULL,
    "name" VARCHAR(150) NOT NULL,
    "description" VARCHAR(300) NOT NULL,
    "categoryId" INT NOT NULL,
    "createDate" DATETIME NOT NULL,
    "orgId" INT NOT NULL,
    "logoFileName" VARCHAR(75) NOT NULL,
    "isActive" BOOLEAN DEFAULT (1)
, "adminId" INTEGER  NOT NULL  DEFAULT (0));
CREATE TABLE tbl_organization (
    "id" INT NOT NULL,
    "name" VARCHAR(150) NOT NULL,
    "description" VARCHAR(300) NOT NULL,
    "createDate" DATETIME NOT NULL,
    "address1" VARCHAR(100),
    "address2" VARCHAR(100),
    "city" VARCHAR(50),
    "state" VARCHAR(2),
    "zipCode" VARCHAR(9) NOT NULL,
    "websiteLink" VARCHAR(150),
    "logoFileName" VARCHAR(75) NOT NULL,
    "isActive" BOOLEAN DEFAULT (1)
, "adminId" INTEGER  NOT NULL  DEFAULT (0));
CREATE TABLE "tbl_group_admins" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "groupId" INTEGER NOT NULL,
    "userId" INTEGER NOT NULL
);
CREATE TABLE "tbl_user_organizations" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "user_Id" INTEGER NOT NULL,
    "org_Id" INTEGER NOT NULL
);
CREATE TABLE "tbl_user_groups" (
    "Id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "user_Id" INTEGER NOT NULL,
    "group_Id" INTEGER NOT NULL
);
CREATE TABLE "tbl_organization_groups" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "org_Id" INTEGER NOT NULL,
    "group_Id" INTEGER NOT NULL
);
CREATE TABLE tbl_organization_admins (
    "id" INTEGER NOT NULL,
    "org_Id" INTEGER NOT NULL,
    "user_Id" INTEGER NOT NULL
);
CREATE TABLE "tbl_category" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "org_Id" INTEGER NOT NULL,
    "type" TEXT NOT NULL,
    "name" TEXT NOT NULL,
    "description" TEXT,
    "isActive" BOOLEAN true
);
CREATE TABLE "tbl_chat_messages" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "chat_Id" INTEGER NOT NULL DEFAULT (0),
    "user_Id" INTEGER NOT NULL DEFAULT (0),
    "posted_date" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "message" TEXT NOT NULL
);
CREATE TABLE tbl_chat (
    "id" INTEGER NOT NULL,
    "group_Id" INTEGER NOT NULL DEFAULT (0),
    "initiator_Id" INTEGER NOT NULL DEFAULT (0),
    "topic" TEXT NOT NULL,
    "createdDate" DATETIME NOT NULL DEFAULT ('CURRENT_TIMESTAMP'),
    "deleted" BOOLEAN NOT NULL DEFAULT ('FALSE')
);
