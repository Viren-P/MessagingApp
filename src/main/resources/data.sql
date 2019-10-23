insert into credentials_table values("pass", "user1");
insert into credentials_table values("pass", "user2");
insert into credentials_table values("pass", "user3");
insert into credentials_table values("pass", "admin");

insert into user_table values(101,"role-user", 1);
insert into user_table values(102,"role-user", 2);
insert into user_table values(103,"role-user", 3);
insert into user_table values(104,"role-admin", 4);

insert into message_table values (1001, "Hello, how are you?", "Hello", 102, 101);
insert into message_table values (1002, "I am fine, Thank you!", "Hi", 101, 102);
insert into message_table values (1003, "Greetings! Good day, isn't it?", "Greetings", 103, 105);