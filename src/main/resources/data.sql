INSERT INTO public.company (comp_id, active, comp_name, create_date, domain, location, phone, revenue, update_date) VALUES (1, true, 'OYO Rooms', '2020-11-04 16:48:31.087109', 'www.oyorooms.com', 'Gurugram,Haryana,India', '987564332', '$10 Billion', '2020-11-04 16:48:31.087159');
INSERT INTO public.company (comp_id, active, comp_name, create_date, domain, location, phone, revenue, update_date) VALUES (2, true, 'Google', '2020-11-04 16:48:44.455611', 'www.google.com', 'Hyderabad,India', '787564332', '$40 Billion', '2020-11-04 16:48:44.455634');
INSERT INTO public.company (comp_id, active, comp_name, create_date, domain, location, phone, revenue, update_date) VALUES (3, true, 'Swiggy', '2020-11-04 16:49:13.832225', 'www.swiggy.com', 'Delhi,India', '987564332', '$2 Billion', '2020-11-04 16:49:13.832248');

INSERT INTO public.department (dept_id, active, create_date, dept_name, location, phone, update_date, comp_id) VALUES (1, true, '2020-11-04 17:10:35.980702', 'OYO HR', 'Gurugram,India', '787564311', '2020-11-04 17:10:35.980771', 1);
INSERT INTO public.department (dept_id, active, create_date, dept_name, location, phone, update_date, comp_id) VALUES (2, true, '2020-11-04 17:11:14.480628', 'OYO Finance', 'Gurugram,India', '787564311', '2020-11-04 17:11:14.480650', 1);
INSERT INTO public.department (dept_id, active, create_date, dept_name, location, phone, update_date, comp_id) VALUES (3, true, '2020-11-04 17:11:23.887504', 'OYO Supply', 'Gurugram,India', '787564311', '2020-11-04 17:11:23.887534', 1);
INSERT INTO public.department (dept_id, active, create_date, dept_name, location, phone, update_date, comp_id) VALUES (4, true, '2020-11-04 17:12:05.075063', 'Google Finance', 'Banglore,India', '8787564311', '2020-11-04 17:12:05.075087', 2);
INSERT INTO public.department (dept_id, active, create_date, dept_name, location, phone, update_date, comp_id) VALUES (5, true, '2020-11-04 17:12:15.813652', 'Google HR', 'Banglore,India', '8787564311', '2020-11-04 17:12:15.813674', 2);
INSERT INTO public.department (dept_id, active, create_date, dept_name, location, phone, update_date, comp_id) VALUES (6, true, '2020-11-04 17:12:23.646574', 'Google Supply', 'Banglore,India', '8787564311', '2020-11-04 17:12:23.646597', 2);
INSERT INTO public.department (dept_id, active, create_date, dept_name, location, phone, update_date, comp_id) VALUES (7, true, '2020-11-04 17:12:55.679167', 'Swiggy Finance', 'Hyderbad,India', '9787564311', '2020-11-04 17:12:55.679189', 3);
INSERT INTO public.department (dept_id, active, create_date, dept_name, location, phone, update_date, comp_id) VALUES (8, true, '2020-11-04 17:13:05.468803', 'Swiggy HR', 'Hyderbad,India', '9787564311', '2020-11-04 17:13:05.468825', 3);
INSERT INTO public.department (dept_id, active, create_date, dept_name, location, phone, update_date, comp_id) VALUES (9, true, '2020-11-04 17:13:18.340818', 'Swiggy CRM', 'Hyderbad,India', '9787564311', '2020-11-04 17:13:18.340877', 3);

INSERT INTO public.salary (salary_id, active, create_date, salary_amount, update_date) VALUES (1, true, '2020-11-04 20:43:43.719815', '75000', '2020-11-04 20:43:43.720109');
INSERT INTO public.salary (salary_id, active, create_date, salary_amount, update_date) VALUES (2, true, '2020-11-04 20:43:52.568130', '150000', '2020-11-04 20:43:52.568162');
INSERT INTO public.salary (salary_id, active, create_date, salary_amount, update_date) VALUES (3, true, '2020-11-04 20:44:03.798146', '250000', '2020-11-04 20:44:03.798167');
INSERT INTO public.salary (salary_id, active, create_date, salary_amount, update_date) VALUES (4, true, '2020-11-04 20:44:13.109302', '320000', '2020-11-04 20:44:13.109324');

INSERT INTO public.employee (emp_id, aadhar_number, active, address, bank_ifsc_code, bank_account_number, bank_name, create_date, designation, email, first_name, gender, image, last_name, pan_number, password, phone, update_date, dept_id, salary_id) VALUES (1, '0348671262223', true, 'Prayag,UP,India', 'SBIN7263', '73461026416123', 'SBI', '2020-11-05 10:03:45.903561', 'SDE', 'renish@oyo.com', 'Renish', 'male', null, 'singh', 'MR3ESD3E3', '1111', '97634272342', '2020-11-05 10:03:45.903605', 1, 1);
INSERT INTO public.employee (emp_id, aadhar_number, active, address, bank_ifsc_code, bank_account_number, bank_name, create_date, designation, email, first_name, gender, image, last_name, pan_number, password, phone, update_date, dept_id, salary_id) VALUES (2, '0348671262223', true, 'Prayag,UP,India', 'SBIN7263', '73461026416123', 'SBI', '2020-11-05 10:04:48.494026', 'SDE', 'vishal@gmail.com', 'Vishal', 'male', null, 'Shukla', 'MR3ESD3E3', '1111', '97634272342', '2020-11-05 10:04:48.494050', 4, 2);
INSERT INTO public.employee (emp_id, aadhar_number, active, address, bank_ifsc_code, bank_account_number, bank_name, create_date, designation, email, first_name, gender, image, last_name, pan_number, password, phone, update_date, dept_id, salary_id) VALUES (3, '0348671262223', true, 'Prayag,UP,India', 'SBIN7263', '73461026416123', 'SBI', '2020-11-05 10:05:50.572532', 'SDE', 'abhi@swiggy.com', 'Abhishek', 'male', null, 'Pandey', 'MR3ESD3E3', '1111', '97634272342', '2020-11-05 10:05:50.572555', 7, 1);

insert into countries values
(1,'America'),
(2,'Australia'),
(3,'Bangladesh'),
(4,'Canada'),
(5,'China'),
(6,'Germany'),
(7,'India'),
(8,'Nepal'),
(9,'Pakistan'),
(10,'Vietnam');


insert into states
values (1, 'Andhra Pradesh', 7);
insert into states
values (2, 'Bihar', 7);
insert into states
values (3, 'Haryana', 7);
insert into states
values (4, 'Jharkhand', 7);
insert into states
values (5, 'Kerala', 7);

insert into cities values
(1,'Visakhapatnam',1),
(2,'Tirupati',1),
(3,'Patna',2),
(4,'Gaya',2),
(5,'Gurugram',3),
(6,'Faridabad',3),
(7,'Ranchi',4),
(8,'Dhanbad',4),
(9,'Kochi',5),
(10,'Kannur',5);