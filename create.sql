create sequence hibernate_sequence start with 1 increment by 1
create table category (id varchar(255) not null, category_type varchar(255), has_products boolean not null, has_spare_parts boolean not null, name varchar(255), slogan varchar(255), primary key (id))
create table category_overviews (category_id varchar(255) not null, overviews_id bigint not null, primary key (category_id, overviews_id))
create table category_sub_categories (category_id varchar(255) not null, sub_categories_id varchar(255) not null, primary key (category_id, sub_categories_id))
create table image (key varchar(255) not null, orientation varchar(255), thumbnail varchar(255), primary key (key))
create table overview (id bigint not null, name varchar(255), url varchar(255), primary key (id))
alter table category_overviews add constraint UK_4w617iuihqr0uhfrpd3n91foo unique (overviews_id)
alter table category_sub_categories add constraint UK_bvsvfpcbk584cpyecc213hl3m unique (sub_categories_id)
alter table category_overviews add constraint FK1cd7ib2agc2np2k5iov3fr3nq foreign key (overviews_id) references overview
alter table category_overviews add constraint FKc44h6hxhgum22ced3lt3oomxl foreign key (category_id) references category
alter table category_sub_categories add constraint FKidcggyryld30a3y9ohv87sxa9 foreign key (sub_categories_id) references category
alter table category_sub_categories add constraint FKaibc0jhojq2mftuvidt462xsd foreign key (category_id) references category
create sequence hibernate_sequence start with 1 increment by 1
create table category (id varchar(255) not null, category_type varchar(255), has_products boolean not null, has_spare_parts boolean not null, name varchar(255), slogan varchar(255), primary key (id))
create table category_overviews (category_id varchar(255) not null, overviews_id bigint not null, primary key (category_id, overviews_id))
create table category_sub_categories (category_id varchar(255) not null, sub_categories_id varchar(255) not null, primary key (category_id, sub_categories_id))
create table image (key varchar(255) not null, orientation varchar(255), thumbnail varchar(255), primary key (key))
create table overview (id bigint not null, name varchar(255), url varchar(255), primary key (id))
alter table category_overviews add constraint UK_4w617iuihqr0uhfrpd3n91foo unique (overviews_id)
alter table category_sub_categories add constraint UK_bvsvfpcbk584cpyecc213hl3m unique (sub_categories_id)
alter table category_overviews add constraint FK1cd7ib2agc2np2k5iov3fr3nq foreign key (overviews_id) references overview
alter table category_overviews add constraint FKc44h6hxhgum22ced3lt3oomxl foreign key (category_id) references category
alter table category_sub_categories add constraint FKidcggyryld30a3y9ohv87sxa9 foreign key (sub_categories_id) references category
alter table category_sub_categories add constraint FKaibc0jhojq2mftuvidt462xsd foreign key (category_id) references category
