MySql's timezone deafault was "SYSTEM", somtimes it will error when u start the project
change the timezone with :

show global variables like '%time_zone%';

set global time_zone ='+8:00';

set time_zone ='+8:00';

flush privileges;
