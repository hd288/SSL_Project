create table category
(
    category_id   varchar(255) not null
        primary key,
    category_name varchar(255) null,
    description   varchar(255) not null,
    constraint UK_lroeo5fvfdeg4hpicn4lw7x9b
        unique (category_name)
);

create table course
(
    course_id   varchar(255) not null
        primary key,
    course_desc varchar(255) not null,
    course_name varchar(255) null,
    duration    int          not null,
    is_actived  bit          not null,
    category_id varchar(255) null,
    constraint UK_9dll001xc2cip6hug6axoab0p
        unique (course_name),
    constraint FKkyes7515s3ypoovxrput029bh
        foreign key (category_id) references category (category_id)
);

create table lesson
(
    lesson_id    bigint auto_increment
        primary key,
    content_link varchar(255) not null,
    unit_score   double       null,
    course_id    varchar(255) null,
    constraint FKjs3c7skmg8bvdddok5lc7s807
        foreign key (course_id) references course (course_id)
);

create table question
(
    question_id   bigint auto_increment
        primary key,
    answer        int          not null,
    question_text varchar(255) not null,
    lesson_id     bigint       null,
    constraint FK1sbknhfhhug49n0elkvgk38vs
        foreign key (lesson_id) references lesson (lesson_id)
);

create table roles
(
    role_id   bigint auto_increment
        primary key,
    role_name enum ('ROLE_ADMIN', 'ROLE_MENTOR', 'ROLE_STUDENT') null
);

create table user
(
    user_id      binary(16)   not null
        primary key,
    address      varchar(255) not null,
    birth_day    date         not null,
    email        varchar(255) not null,
    enable       bit          not null,
    first_name   varchar(255) not null,
    gender       bit          not null,
    image        varchar(255) null,
    last_name    varchar(255) not null,
    password     varchar(255) not null,
    phone_number varchar(255) not null,
    constraint UK_4bgmpi98dylab6qdvf9xyaxu4
        unique (phone_number),
    constraint UK_ob8kqyqqgmefl0aco34akdtpe
        unique (email)
);

create table mentor
(
    user_id    binary(16)   not null
        primary key,
    degree     varchar(255) not null,
    experience int          not null,
    constraint FKdijfp61kxqiqesthe4vwud31a
        foreign key (user_id) references user (user_id)
);

create table mentor_course
(
    course_id varchar(255) not null,
    user_id   binary(16)   not null,
    primary key (course_id, user_id),
    constraint FKqg3421pir9c67dos2tqwo58ty
        foreign key (course_id) references course (course_id),
    constraint FKr9c7obsc118rwh37f4yhqmudm
        foreign key (user_id) references mentor (user_id)
);

create table student
(
    user_id     binary(16)   not null
        primary key,
    performance varchar(255) null,
    constraint FKk5m148xqefonqw7bgnpm0snwj
        foreign key (user_id) references user (user_id)
);

create table student_course
(
    student_course_id bigint auto_increment
        primary key,
    course_score      int          null,
    register_date     date         null,
    course_id         varchar(255) null,
    user_id           binary(16)   null,
    constraint FKejrkh4gv8iqgmspsanaji90ws
        foreign key (course_id) references course (course_id),
    constraint FKkxgvdcdcr91p0767889qrbs7v
        foreign key (user_id) references student (user_id)
);

create table student_question
(
    student_answer int        not null,
    question_id    bigint     not null,
    user_id        binary(16) not null,
    primary key (question_id, user_id),
    constraint FKe04feteq21spb5rns431qvuxq
        foreign key (user_id) references student (user_id),
    constraint FKe8umv4156emxavp70fw9176m2
        foreign key (question_id) references question (question_id)
);

create table user_role
(
    user_id binary(16) not null,
    role_id bigint     not null,
    primary key (user_id, role_id),
    constraint FK859n2jvi8ivhui0rl0esws6o
        foreign key (user_id) references user (user_id),
    constraint FKt7e7djp752sqn6w22i6ocqy6q
        foreign key (role_id) references roles (role_id)
);


