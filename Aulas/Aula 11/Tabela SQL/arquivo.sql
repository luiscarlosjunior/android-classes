/* Vamos criar um banco de dados com o nome USUARIO,
   o IF NOT EXISTS faz a verificar se não há algum bd com o mesmo nome
   evitando conflito.
*/
CREATE DATABASE IF NOT EXISTS USUARIO;

# O comando USE nos garante que vamos usar o bd USUARIO a partir de agora
USE USUARIO;

# Utilizando o comando CREATE, iremos criar a nossa tabela
# o comando if not exists serve com o mesmo propósito visto acima
CREATE TABLE IF NOT EXISTS USUARIOS (
	CODIGO 	INT AUTO_INCREMENT PRIMARY KEY,
    NOME	VARCHAR(50) NOT NULL,
    SENHA	VARCHAR(50) NOT NULL,
    EMAIL	VARCHAR(50)
)

# Faz uma busca para observar o que há nessa tabela
SELECT * FROM USUARIOS