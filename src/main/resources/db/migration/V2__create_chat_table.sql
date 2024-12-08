create table chat (
    id bigint auto_increment primary key,
    user_one_id bigint not null,
    user_two_id bigint not null ,
    created_at timestamp default current_timestamp,
    foreign key (user_one_id) references user_(id),
    foreign key (user_two_id) references user_(id)
);