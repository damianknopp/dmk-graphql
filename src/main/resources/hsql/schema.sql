CREATE TABLE "USERS" (
    "USER_ID" varchar(37) NOT NULL,
    "FIRST" varchar(45) NOT NULL,
    "LAST" varchar(45) NOT NULL,
    PRIMARY KEY ("USER_ID")
);

 CREATE TABLE "ATTRIBUTES" (
    "ATTRIBUTE_ID" varchar(37) NOT NULL,
    "ROLE" varchar(45) NOT NULL,
    "USER_ID" varchar(37) DEFAULT NULL,
    PRIMARY KEY ("ATTRIBUTE_ID"),
    CONSTRAINT "USERS_ID_FK"
    FOREIGN KEY ("USER_ID")
    REFERENCES "USERS" ("USER_ID")
 );

--CREATE TABLE "USERS_ATTRIBUTES" (
--  "USER_ID" int(37),
--  "ATTRIBUTE_ID" int(37),
--  PRIMARY KEY ("USER_ID", "ATTRIBUTE_ID"),
--  CONSTRAINT "USERS_ID_FK"
--     FOREIGN KEY ("USER_ID")
--     REFERENCES "USERS" ("USER_ID"),
--  CONSTRAINT "ATTRIBUTES_ID_FK"
--     FOREIGN KEY ("ATTRIBUTE_ID")
--     REFERENCES "ATTRIBUTES" ("ATTRIBUTE_ID")
--);