CREATE TABLE Child (
ChildID INT AUTO_INCREMENT,
 ParentID INT NOT NULL,
 FirstName VARCHAR(20),
 LastName VARCHAR(20),
 PRIMARY KEY(ChildID),
 FOREIGN KEY (ParentID) REFERENCES Parent(ID));


-- CREATE TABLE location(
-- location_id varchar(5) NOT NULL,
-- location varchar(50) NOT NULL,
-- office_size int,
-- PRIMARY KEY(location_id),
-- FOREIGN KEY(location) REFERENCES dataflair(location));