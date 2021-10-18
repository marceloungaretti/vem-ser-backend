CREATE TABLE VEM_SER.ESTUDANTE (
    id NUMBER,
    nome VARCHAR2(200) NOT NULL,
    data_de_nascimento DATE NOT NULL,
    nr_matricula NUMBER(10) NOT NULL,
    ativo CHAR(1) NOT NULL,
    PRIMARY KEY(id)
);

CREATE SEQUENCE seq_estudante;

INSERT INTO VEM_SER.ESTUDANTE
(ID, NOME, DATA_DE_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(SEQ_ESTUDANTE.nextval, 'Marcelo Cainelli Ungaretti', TO_DATE('01-05-1994', 'dd-mm-yyyy'), '1010101010', 'S');
VALUES(SEQ_ESTUDANTE.nextval, 'João da Silva', TO_DATE('12-01-1992', 'dd-mm-yyyy'), '2020202020', 'S');
VALUES(SEQ_ESTUDANTE.nextval, 'Maria da Silva', TO_DATE('11-02-1996', 'dd-mm-yyyy'), '3030303030', 'S');
VALUES(SEQ_ESTUDANTE.nextval, 'José da Silva', TO_DATE('02-05-1990', 'dd-mm-yyyy'), '4040404040', 'N');
VALUES(SEQ_ESTUDANTE.nextval, 'Bruno da Silva', TO_DATE('25-07-1998', 'dd-mm-yyyy'), '5050505050', 'S');
VALUES(SEQ_ESTUDANTE.nextval, 'Ana da Silva', TO_DATE('11-12-1999', 'dd-mm-yyyy'), '6060606060', 'N');
VALUES(SEQ_ESTUDANTE.nextval, 'Julia da Silva', TO_DATE('30-05-1992', 'dd-mm-yyyy'), '7070707070', 'N');
VALUES(SEQ_ESTUDANTE.nextval, 'Diogo da Silva', TO_DATE('11-12-1993', 'dd-mm-yyyy'), '8080808080', 'S');
VALUES(SEQ_ESTUDANTE.nextval, 'Felipe da Silva', TO_DATE('12-12-1993', 'dd-mm-yyyy'), '9090909090', 'S');
VALUES(SEQ_ESTUDANTE.nextval, 'Antonia da Silva', TO_DATE('03-04-1994', 'dd-mm-yyyy'), '1111111111', 'S');

SELECT * FROM VEM_SER.ESTUDANTE