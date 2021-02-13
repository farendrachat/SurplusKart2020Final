Insert into USER (USER_ID,USER_NAME,PASSWORD,ROLE) values (1,'Guest','Guest','GUEST');
Insert into USER (USER_ID,USER_NAME,PASSWORD,ROLE) values (2,'Admin','Admin','ADMIN');
Insert into USER (USER_ID,USER_NAME,PASSWORD,ROLE) values (3,'Seller1','Seller1','SELLER');
Insert into USER (USER_ID,USER_NAME,PASSWORD,ROLE) values (4,'Seller2','Seller2','SELLER');
Insert into USER (USER_ID,USER_NAME,PASSWORD,ROLE) values (5,'Buyer1','Buyer1','BUYER');
Insert into USER (USER_ID,USER_NAME,PASSWORD,ROLE) values (6,'Buyer2','Buyer2','BUYER');
Insert into USER (USER_ID,USER_NAME,PASSWORD,ROLE) values (7,'CSM','CSM','CSM');
insert into PRODUCT(pr_Id,name,category,identity,state,city,brand,qty_Expressed,seller_Id,buyer_Id,available_Packets,unit_Price,
pack_Size,remain_Packet,date_Manufacture,date_Expire,update_On,loaded_By,approved,approved_By)
values (1,'Sweets','Binders','','Kerala','Kottam','Amul','Litre',3,5,20,2,2,20,null,null,null,1,true,1);
--insert into product (id,name,price,quantity) values (1,'Product1',10.0,5);
--insert into product (id,name,price,quantity) values (2,'Product2',12.0,12);
--insert into product (id,name,price,quantity) values (3,'Product3',13.0,43);
--insert into product (id,name,price,quantity) values (4,'Product4',14.0,545);
--insert into product (id,name,price,quantity) values (5,'Product5',15.0,456);
--insert into product (id,name,price,quantity) values (6,'Product6',12.0,45);
--insert into product (id,name,price,quantity) values (7,'Product7',16.0,65);
--insert into product (id,name,price,quantity) values (8,'Product8',17.0,12);
--insert into product (id,name,price,quantity) values (9,'Product9',13.0,57);