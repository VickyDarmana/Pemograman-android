<?php
    $link = mysqli_connect("localhost", "root", "", "cinema_db");

    if(isset($_POST['submit'])) {
        $username = mysqli_real_escape_string($link, $_POST["username"]);
        $password = password_hash($_POST["password"], PASSWORD_BCRYPT);

        $insert_query = "INSERT INTO userlogin (userGmail, userPassword) VALUES ('$username', '$password')";

        if (mysqli_query($link, $insert_query)) {
            header("Location: index.php");
            exit();
        } else {
            echo "Error: " . $insert_query . "<br>" . mysqli_error($link);
        }
    }
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style/styles.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
        integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <title>CineTix</title>
    <link rel="icon" type="image/png" href="img/cinetix.png">
</head>

<body>
    <header></header>
    <div class="login-container">
        <form class="login-form" action="" method="post">
            <input type="varchar" name="username" placeholder="Email or Phone Number" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="password" name="password" placeholder="Confirm Password" required>
            <button type="submit" name="submit">Register</button>
        </form>
    </div>
    <br>
    <br>
    <br>
    <footer></footer>

    <script src="scripts/jquery-3.3.1.min.js"></script>
    <script src="scripts/script.js"></script>

    <script>
        function redirectToCreateAccount() {
            window.location.href = "createaccount.php";
        }
    </script>
</body>

</html>
