SELECT * FROM PESSOA P CROSS JOIN CONTATO C
SELECT * FROM PESSOA P INNER JOIN CONTATO C ON (P.ID_PESSOA = C.ID_PESSOA)
SELECT * FROM PESSOA P INNER JOIN PESSOA_X_PESSOA_ENDERECO PXPE ON (P.ID_PESSOA = PXPE.ID_PESSOA) INNER JOIN ENDERECO_PESSOA EP ON (PXPE.ID_ENDERECO = EP.ID_ENDERECO)
SELECT * FROM PESSOA P INNER JOIN CONTATO C ON (P.ID_PESSOA = C.ID_PESSOA) INNER JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (P.ID_PESSOA = PXPE.ID_PESSOA) INNER JOIN ENDERECO_PESSOA ep ON (ep.ID_ENDERECO = pxpe.ID_ENDERECO)
SELECT * FROM PESSOA P LEFT JOIN CONTATO C ON (P.ID_PESSOA = C.ID_PESSOA)
SELECT * FROM PESSOA P LEFT JOIN PESSOA_X_PESSOA_ENDERECO pxpe2 ON (P.ID_PESSOA = PXPE2.ID_PESSOA) INNER JOIN ENDERECO_PESSOA EP ON (PXPE2.ID_ENDERECO = ep.ID_ENDERECO)
SELECT * FROM PESSOA P LEFT JOIN CONTATO C ON (P.ID_PESSOA = C.ID_PESSOA) LEFT JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (P.ID_PESSOA = PXPE.ID_PESSOA) LEFT JOIN ENDERECO_PESSOA ep ON (ep.ID_ENDERECO = pxpe.ID_ENDERECO)