insert into "order" ("id", "order_no", "order_date", "customer_name") values ('bbb6f2f3-104b-489c-8048-ac08318a4898', 'O-12345', '2020-11-28', 'タグバンガーズ太郎');
insert into "order_line" ("id", "name", "price", "quantity", "product_id") values ('425ed435-57bb-4c8d-bbbb-441564de1707', 'チョコモナカジャンボ', 'JPY 140', 1, '2b305c7b-5809-4103-ba56-e7aa313aa88b');
insert into "order_line" ("id", "name", "price", "quantity", "product_id") values ('fa1fd84c-723e-4b19-987b-8fb0de337682', 'バニラモナカジャンボ', 'JPY 140', 1, '586b78a4-d999-48b7-938f-38691346b759');
insert into "order_line" ("id", "name", "price", "quantity", "product_id") values ('3202353a-479c-46da-bbb8-e1a3cf69c9e0', '小豆バー', 'JPY 100', 3, '33d9e8bd-b6d6-4d45-8445-509e872d86db');
insert into "order_lines" ("order_id", "lines_id") values ('bbb6f2f3-104b-489c-8048-ac08318a4898', '425ed435-57bb-4c8d-bbbb-441564de1707');
insert into "order_lines" ("order_id", "lines_id") values ('bbb6f2f3-104b-489c-8048-ac08318a4898', 'fa1fd84c-723e-4b19-987b-8fb0de337682');
insert into "order_lines" ("order_id", "lines_id") values ('bbb6f2f3-104b-489c-8048-ac08318a4898', '3202353a-479c-46da-bbb8-e1a3cf69c9e0');
insert into "product" ("id","product_no", "name", "stock") values ('2b305c7b-5809-4103-ba56-e7aa313aa88b','P-12345', 'チョコモナカジャンボ', 10);
insert into "product" ("id","product_no", "name", "stock") values ('586b78a4-d999-48b7-938f-38691346b759','P-12346', 'バニラモナカジャンボ', 10);
insert into "product" ("id","product_no", "name", "stock") values ('33d9e8bd-b6d6-4d45-8445-509e872d86db','P-12347', '小豆バー', 10);
