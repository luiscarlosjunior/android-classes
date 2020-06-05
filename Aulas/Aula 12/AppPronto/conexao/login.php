<?php
    require "conexao.php";

    $usuario = $_GET['username'];
    $senha = $_GET['password'];

    $sql_query = "
        SELECT NOME FROM ACESSO WHERE USUARIO like '$usuario' 
        AND SENHA like '$senha';
    ";

    $result = mysqli_query($con, $sql_query);

    if(mysqli_num_rows($result) > 0) {
        $row = mysqli_fetch_assoc($result);

        $nome = $row["NOME"];

        echo $nome;
    }
    else {
        echo "Erro ao registrar dados ".mysqli_error($con);
    }

?>