drop table highscore;
create table highScore (
    jugador varchar2(10) primary key,
    puntaje number(5,0) not null check (puntaje>=0)
);

insert into highscore values('Pacho', 10);
insert into highscore values('Master', 20);
insert into highscore values ('noob', 1);

commit;
