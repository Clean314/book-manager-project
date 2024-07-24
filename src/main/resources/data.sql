-- call next value for hibernate_sequence; -- 이 문장을 넣어 수동으로 ID 값을 자동으로 증가시킴. sequence 사용 (member 말고도 공용으로 사용하게 되는 문제가 있다)
insert into member (`id`, `name`, `email`, `created_at`, `updated_at`) values (1, 'martin', 'martin@fastemail.com', now(), now());

-- call next value for hibernate_sequence;
insert into member (`id`, `name`, `email`, `created_at`, `updated_at`) values (2, 'dennis', 'dennis@fastemail.com', now(), now());

-- call next value for hibernate_sequence;
insert into member (`id`, `name`, `email`, `created_at`, `updated_at`) values (3, 'sophia', 'sophia@slowemail.com', now(), now());

-- call next value for hibernate_sequence;
insert into member (`id`, `name`, `email`, `created_at`, `updated_at`) values (4, 'james', 'james@slowemail.com', now(), now());

-- call next value for hibernate_sequence;
insert into member (`id`, `name`, `email`, `created_at`, `updated_at`) values (5, 'martin', 'martin@another.com', now(), now());