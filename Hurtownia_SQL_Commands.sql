create login pabhurtownia with password='aaaaaa'
create database hurtownia

use hurtownia
go

create user pabhurtownia for login pabhurtownia

create table users(nip_pesel varchar(30) primary key not null, nazwa varchar(100) not null, miasto varchar(200) not null, 
adres varchar(200) not null, kod_pocztowy varchar(6) not null)

deny all on users to pabhurtownia
grant select, insert, alter on users to pabhurtownia

create table produkty(id int primary key identity(1,1) not null, nazwa varchar(200) not null, cena money not null, ilosc int not null)

deny all on produkty to pabhurtownia
grant select, insert, alter on produkty to pabhurtownia

create table zamowienia(id int primary key identity(1,1) not null, nip_pesel varchar(30) not null foreign key references users(nip_pesel),
product_id int not null foreign key references produkty(id), ilosc int not null, cena money not null, dzien date not null, status_zamowienia varchar(50) not null)
deny all on zamowienia to pabhurtownia
grant select, insert, alter on zamowienia to pabhurtownia

create procedure loguj
@nip_pesel varchar(30)
as
begin
	select * from users where nip_pesel = @nip_pesel
end

create procedure rejestruj
@nip_pesel varchar(30), @nazwa varchar(100), @miasto varchar(200), @adres varchar(200), @kod_pocztowy varchar(6)
as
begin
	insert into users values (@nip_pesel, @nazwa, @miasto, @adres, @kod_pocztowy)
end

create procedure pokaz_zamowienia
@nip_pesel varchar(30)
as
begin
	select * from zamowienia where nip_pesel = @nip_pesel
end

create procedure zloz_zamowienie
@nip_pesel varchar(30), @product_id int, @ilosc int
as
begin
	if @ilosc <= (select ilosc from produkty where id = @product_id)
	begin
		declare @cena money, @dzien date;
		set @dzien = GETDATE();
		set @cena = @ilosc * (select cena from produkty where id = @product_id)
		insert into zamowienia values (@nip_pesel, @product_id, @ilosc, @cena, @dzien, 'OCZEKUJE')
		update produkty set ilosc = ilosc - @ilosc where id = @product_id
		select 1;
	end
	else
		select 0;
end

exec zloz_zamowienie '00112233445', 2, 42

drop procedure zloz_zamowienie

create procedure pokaz_produkty
as
begin
	select * from produkty where ilosc > 0
end

create procedure edytuj_usera
@nip_pesel varchar(30), @nazwa varchar(100), @miasto varchar(200), @adres varchar(200), @kod_pocztowy varchar(6)
as
begin
	update users set nazwa = @nazwa, miasto = @miasto, adres = @adres, kod_pocztowy = @kod_pocztowy where nip_pesel = @nip_pesel
end

grant exec on loguj to pabhurtownia
grant exec on rejestruj to pabhurtownia
grant exec on pokaz_zamowienia to pabhurtownia
grant exec on zloz_zamowienie to pabhurtownia
grant exec on pokaz_produkty to pabhurtownia
grant exec on edytuj_usera to pabhurtownia

insert into users values ('98011400418', 'Kuba Posadzy', 'Bydgoszcz', 'Glinki 85/21', '85-861')
insert into users values ('90112233445', 'Jan Kowalski', 'Bydgoszcz', 'Chemiczna 24', '85-855')
insert into users values ('80223344556', 'Arkadiusz Nowak', 'Osielsko', 'Bydgoska 12', '83-001')

insert into produkty values('Mleko 2%', '2.5', 100)
insert into produkty values('Bu³ka pszenna', '0.3', 50)
insert into produkty values('Dro¿d¿ówka z wiœni¹', '1.7', 32)
insert into produkty values('Jogurt naturalny', '1.99', 231)
insert into produkty values('Baton Mars', '3', 63)

exec zloz_zamowienie '98011400418', 1, 20
exec zloz_zamowienie '98011400418', 2, 9

exec zloz_zamowienie '00112233445', 1, 90

create procedure sprawdz
@nip_pesel varchar(30)
as
begin
	declare @i int
	set @i = (select  count(nip_pesel) from users where nip_pesel = @nip_pesel)
	if @i > 0
		select 1
	else
		select 0
end

drop procedure sprawdz

select * from users

select * from zamowienia

select * from produkty

grant exec on sprawdz to pabhurtownia


