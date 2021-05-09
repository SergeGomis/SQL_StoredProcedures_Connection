create table users ( 
	id int not null primary key auto_increment, 
	modifieddate timestamp not null default now(),
   	firstname varchar(50) not null,
   	lastname varchar(50) not null,
    	email varchar(20) not null,
    	phonenumber varchar(15) not null
);

