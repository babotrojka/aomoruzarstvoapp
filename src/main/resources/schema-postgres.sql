--DROP TABLE Posudba;
--DROP TABLE Oprema;
--DROP TABLE Racun;
--DROP TABLE Osoba;


CREATE TABLE IF NOT EXISTS Oprema
(
    Sifra VARCHAR(20) NOT NULL,
    Grupa_opreme VARCHAR(50) NOT NULL,
    Proizvodac VARCHAR(50),
    Model VARCHAR(50),
    Naziv VARCHAR(50) NOT NULL,
    JM VARCHAR(5) NOT NULL,
    Kolicina INT NOT NULL,
    Pobrojano INT,
    Godina INT,
    Napomena VARCHAR(50),
    PRIMARY KEY (Sifra)
);

CREATE TABLE IF NOT EXISTS Osoba
(
    Username VARCHAR(20) NOT NULL,
    Ime VARCHAR(20) NOT NULL,
    Prezime VARCHAR(20) NOT NULL,
    Datum_rodenja DATE,
    PRIMARY KEY (Username)
);

CREATE TABLE IF NOT EXISTS Racun
(
    Username VARCHAR(20) NOT NULL,
    Lozinka VARCHAR(20) NOT NULL,
    PRIMARY KEY (Username),
    FOREIGN KEY (Username) REFERENCES Osoba(Username)
);

CREATE TABLE IF NOT EXISTS Posudba
(
    Username VARCHAR(20) NOT NULL,
    Sifra VARCHAR(20),
    DatumPosudbe DATE NOT NULL,
    DatumPovratka DATE NOT NULL,
    Kolicina INTEGER NOT NULL,
    FOREIGN KEY (Username) REFERENCES Racun(Username),
    FOREIGN KEY (Sifra) REFERENCES Oprema(Sifra)
);

--insert into osoba values('isabolic', 'Ivan', 'Sabolic');
--insert into racun values ('isabolic', 'sifra');
--insert into osoba values('imedic', 'Iva', 'Medic');
--insert into racun values ('imedic', 'sifra');

--insert into oprema values('Č01', 'Čokovi', 'Kong', null, 'Set čokova', 'kom', 7, 8, null, null);
--insert into oprema values('C01', 'Cepin', 'Cassin', 'X-Dream', 'X-Dream Cassin', 'par', 1, null, null, null);
--insert into oprema values('F01', 'Frend', 'Black Diamond', 'Friend .75', 'Friend.75', 'kom', 2, 1, null, null);
