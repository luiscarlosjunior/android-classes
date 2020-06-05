<?php
    // Declarando variavéis para poder acessar o banco de dados
    $db_name    = "usuarios";
    $mysql_user = "root";
    $mysql_pass = "";
    $server_name = "localhost";

    // Texto de conexão
    $con = mysqli_connect($server_name, $mysql_user, $mysql_pass, $db_name);

    // Verifica se há conexão
    if (!$con) {
        echo "Erro na conexao".mysqli_connect_error();
    } else {
        //echo "Conexao criada com sucesso!";
    }

?>