CREATE TABLE CRT_CARTAO(
	CRT_ID INT(9) NOT NULL AUTO_INCREMENT,
	CRT_NUMERO INT(9) NOT NULL,
	CONSTRAINT CRT_CARTAO_PK PRIMARY KEY (CRT_ID),
	CONSTRAINT CRT_NUMERO_UK UNIQUE KEY (CRT_NUMERO)
);

CREATE TABLE USR_USUARIO(
	USR_ID INT(9) NOT NULL AUTO_INCREMENT,
	USR_NOME VARCHAR(20) NOT NULL,
	CRT_ID INT(9) NOT NULL,
	CONSTRAINT USR_USUARIO_PK PRIMARY KEY (USR_ID),
	CONSTRAINT USR_NOME_UK UNIQUE KEY (USR_NOME),
	FOREIGN KEY CRT_USUARIO_FK (CRT_ID) REFERENCES CRT_CARTAO (CRT_ID) ON DELETE CASCADE
);

CREATE TABLE ART_ARTIGO(
	ART_ID INT(9) NOT NULL AUTO_INCREMENT,
	ART_TITULO VARCHAR(50) NOT NULL,
	USR_ID INT (9) NOT NULL,
	ART_DESCRICAO VARCHAR(200) NOT NULL,
	FOREIGN KEY USR_ART_FK (USR_ID) REFERENCES USR_USUARIO (USR_ID) ON DELETE CASCADE,	
	CONSTRAINT ART_ARTIGO_PK PRIMARY KEY (ART_ID)
);

CREATE TABLE CAT_CATEGORIA(
	CAT_ID INT(9) NOT NULL AUTO_INCREMENT,
	CAT_CATEGORIA VARCHAR(20) NOT NULL,
	CONSTRAINT CAT_CATEGORIA_PK PRIMARY KEY (CAT_ID)
);

CREATE TABLE CATEGORIA_ARTIGO(
	CAT_ART_ID INT(9) NOT NULL,
	CAT_ID INT(9) NOT NULL,
	ART_ID INT(9) NOT NULL,
	PRIMARY KEY (CAT_ART_ID),
	FOREIGN KEY CA_CATEGORIA_FK (CAT_ID) REFERENCES CAT_CATEGORIA (CAT_ID),
	FOREIGN KEY CA_ARTIGO_FK (ART_ID) REFERENCES ART_ARTIGO (ART_ID)

);