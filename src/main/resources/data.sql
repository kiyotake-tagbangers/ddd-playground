-- insert into "customer" ("id", "name") values ('8d9b6d9b-240d-4724-a36d-2036599951ca', '空条承太郎');

-- insert into "order" ("id", "order_no", "order_date", "customer_id") values ('a8f087f4-8ae8-4af7-bf41-c55c4b680fe6', 'O-12345', '2020-11-28', '8d9b6d9b-240d-4724-a36d-2036599951ca');

-- insert into "order_line" ("id", "name", "price", "quantity") values ('9d71880e-6c9d-4ad5-86df-59984ca41fcc', 'チョコモナカジャンボ' '140 JPY', 1);
-- insert into "order_line" ("id", "name", "price", "quantity") values ('a5f203bc-c9d7-49c5-ab6e-b4b6f4b725c4', 'バニラモナカジャンボ' '140 JPY', 1);
-- insert into "order_line" ("id", "name", "price", "quantity") values ('d702031b-ff17-44e7-aee7-2f3120bbb37b', '小豆バー' '100 JPY', 3);
-- insert into "order_lines" ("order_id", "lines_id") values ('a8f087f4-8ae8-4af7-bf41-c55c4b680fe6','9d71880e-6c9d-4ad5-86df-59984ca41fcc');
-- insert into "order_lines" ("order_id", "lines_id") values ('a8f087f4-8ae8-4af7-bf41-c55c4b680fe6','a5f203bc-c9d7-49c5-ab6e-b4b6f4b725c4');
-- insert into "order_lines" ("order_id", "lines_id") values ('a8f087f4-8ae8-4af7-bf41-c55c4b680fe6','d702031b-ff17-44e7-aee7-2f3120bbb37b');


insert into "customer" ("id", "name") values ('2fdb63e4-ee55-4740-9401-c6bff79cec45', '空条承太郎');
insert into "order" ("id", "order_no", "order_date", "customer_id") values ('bbb6f2f3-104b-489c-8048-ac08318a4898', 'O-12345', '2020-11-28', '2fdb63e4-ee55-4740-9401-c6bff79cec45');
insert into "order_line" ("id", "name", "price", "quantity") values ('425ed435-57bb-4c8d-bbbb-441564de1707', 'チョコモナカジャンボ', 'JPY 140', 1);
insert into "order_line" ("id", "name", "price", "quantity") values ('fa1fd84c-723e-4b19-987b-8fb0de337682', 'バニラモナカジャンボ', 'JPY 140', 1);
insert into "order_line" ("id", "name", "price", "quantity") values ('3202353a-479c-46da-bbb8-e1a3cf69c9e0', '小豆バー', 'JPY 100', 3);
insert into "order_lines" ("order_id", "lines_id") values ('bbb6f2f3-104b-489c-8048-ac08318a4898', '425ed435-57bb-4c8d-bbbb-441564de1707');
insert into "order_lines" ("order_id", "lines_id") values ('bbb6f2f3-104b-489c-8048-ac08318a4898', 'fa1fd84c-723e-4b19-987b-8fb0de337682');
insert into "order_lines" ("order_id", "lines_id") values ('bbb6f2f3-104b-489c-8048-ac08318a4898', '3202353a-479c-46da-bbb8-e1a3cf69c9e0');