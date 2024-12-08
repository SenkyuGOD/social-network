create table message (
    id bigint auto_increment primary key ,
    chat_id bigint not null ,
    sender_id bigint not null ,
    content text not null ,
    sent_at timestamp default current_timestamp,
    foreign key (chat_id) references chat(id),
    foreign key (sender_id) references user_(id)
);