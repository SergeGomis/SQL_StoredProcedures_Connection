delimiter //

use practicaltest //

drop procedure if exists getX //
create procedure getX(IN x INT)

begin 

if x is NULL then
  select * from users;
else
  select * from users where id = x;
end if ;

end //

delimiter ;


