<?php
    require "conexao.php";

    $nome   = "Luis Santos";
    $usuario = "lcarlos";
    $senha = "123";

    $sql_query = "
        INSERT INTO acesso (nome, usuario, senha) values ('$nome', '$usuario', '$senha');
    ";

    if(mysqli_query($con, $sql_query)) {
        echo "Dados inseridos com sucesso!";
    }
    else {
        echo "Erro ao registrar dados ".mysqli_error($con);
    }

?>