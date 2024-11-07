CREATE TABLE Piese_Auto (
  id_piesa INT PRIMARY KEY,
  cod_piesa VARCHAR(50) UNIQUE NOT NULL,
  denumire VARCHAR(100) NOT NULL,
  producator VARCHAR(50) NOT NULL,
  model_compatibil VARCHAR(100) NOT NULL,
  an_fabricatie INT NOT NULL,
  pret DECIMAL(10,2) NOT NULL,
  stoc INT NOT NULL,
  locatie_depozit VARCHAR(50) NOT NULL,
  garantie_luni INT NOT NULL,
  certificari VARCHAR(200),
  descriere_tehnica TEXT
);

CREATE TABLE Clienti (
  id_client INT PRIMARY KEY,
  nume VARCHAR(50) NOT NULL,
  prenume VARCHAR(50) NOT NULL, 
  telefon VARCHAR(20),
  email VARCHAR(100),
  tip_client ENUM('Persoana Fizica', 'Service Auto') NOT NULL,
  adresa VARCHAR(200),
  istoric_comenzi TEXT
);

CREATE TABLE Comenzi (
  id_comanda INT PRIMARY KEY,
  id_client INT NOT NULL,
  data_comanda DATE NOT NULL,
  valoare_totala DECIMAL(10,2) NOT NULL,
  status_comanda ENUM('Noua', 'In Procesare', 'Livrata', 'Returnata') NOT NULL,
  detalii_livrare VARCHAR(200),
  documente_asociate VARCHAR(100),
  FOREIGN KEY (id_client) REFERENCES Clienti(id_client)
);

CREATE TABLE Comenzi_Produse (
  id_comanda INT NOT NULL,
  id_piesa INT NOT NULL,
  cantitate INT NOT NULL,
  PRIMARY KEY (id_comanda, id_piesa),
  FOREIGN KEY (id_comanda) REFERENCES Comenzi(id_comanda),
  FOREIGN KEY (id_piesa) REFERENCES Piese_Auto(id_piesa)
);

CREATE TABLE Furnizori (
  id_furnizor INT PRIMARY KEY,
  nume_firma VARCHAR(100) NOT NULL,
  persoana_contact VARCHAR(100) NOT NULL,
  telefon VARCHAR(20),
  email VARCHAR(100),
  adresa VARCHAR(200),
  categorie_produse VARCHAR(100) NOT NULL,
  termeni_colaborare TEXT
);

CREATE TABLE Angajati (
  id_angajat INT PRIMARY KEY,
  nume VARCHAR(50) NOT NULL,
  prenume VARCHAR(50) NOT NULL,
  functie VARCHAR(50) NOT NULL,
  departament VARCHAR(50) NOT NULL, 
  telefon VARCHAR(20),
  email VARCHAR(100)
);

CREATE TABLE Comenzi_Angajati (
  id_comanda INT NOT NULL,
  id_angajat INT NOT NULL,
  PRIMARY KEY (id_comanda, id_angajat),
  FOREIGN KEY (id_comanda) REFERENCES Comenzi(id_comanda),
  FOREIGN KEY (id_angajat) REFERENCES Angajati(id_angajat)
);

CREATE TABLE Furnizori_Piese (
  id_furnizor INT NOT NULL,
  id_piesa INT NOT NULL,
  PRIMARY KEY (id_furnizor, id_piesa),
  FOREIGN KEY (id_furnizor) REFERENCES Furnizori(id_furnizor),
  FOREIGN KEY (id_piesa) REFERENCES Piese_Auto(id_piesa)
);

CREATE TABLE Istoric_Comenzi (
  id_istoric INT PRIMARY KEY,
  id_comanda INT NOT NULL,
  data_eveniment DATE NOT NULL,
  eveniment VARCHAR(100) NOT NULL,
  detalii TEXT,
  FOREIGN KEY (id_comanda) REFERENCES Comenzi(id_comanda)
);

CREATE TABLE Reclamatii (
  id_reclamatie INT PRIMARY KEY, 
  id_comanda INT NOT NULL,
  id_piesa INT NOT NULL,
  data_reclamatie DATE NOT NULL,
  motiv VARCHAR(200) NOT NULL,
  rezolutie VARCHAR(200),
  FOREIGN KEY (id_comanda) REFERENCES Comenzi(id_comanda),
  FOREIGN KEY (id_piesa) REFERENCES Piese_Auto(id_piesa)
);

CREATE TABLE Interactiuni_Client_Angajat (
  id_interactiune INT PRIMARY KEY,
  id_client INT NOT NULL,
  id_angajat INT NOT NULL, 
  data_interactiune DATE NOT NULL,
  tip_interactiune VARCHAR(50) NOT NULL,
  detalii TEXT,
  FOREIGN KEY (id_client) REFERENCES Clienti(id_client),
  FOREIGN KEY (id_angajat) REFERENCES Angajati(id_angajat)
);

CREATE TABLE Users (
    id_user INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,  -- 255 pentru hash-ul parolei
    id_angajat INT,
    id_client INT,
    role ENUM('ADMIN', 'MANAGER', 'EMPLOYEE', 'CLIENT') NOT NULL,
    last_login DATETIME,
    account_created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    account_active BOOLEAN DEFAULT true,
    reset_token VARCHAR(100),
    reset_token_expiry DATETIME,
    failed_login_attempts INT DEFAULT 0,
    account_locked BOOLEAN DEFAULT false,
    login_history TEXT,
    FOREIGN KEY (id_angajat) REFERENCES Angajati(id_angajat),
    FOREIGN KEY (id_client) REFERENCES Clienti(id_client),
    CONSTRAINT check_single_role CHECK (
        (id_angajat IS NOT NULL AND id_client IS NULL AND role IN ('ADMIN', 'MANAGER', 'EMPLOYEE')) OR
        (id_client IS NOT NULL AND id_angajat IS NULL AND role = 'CLIENT')
    )
);
