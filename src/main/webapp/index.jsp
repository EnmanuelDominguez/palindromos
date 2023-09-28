<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Verificador de Palindromos</title>
    <link rel="preload" href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400&display=swap" as="style">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400&display=swap">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma-carousel@4.0.4/dist/css/bulma-carousel.min.css"/>
    <link rel="stylesheet" href="css/styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script defer src="https://cdn.jsdelivr.net/npm/bulma-carousel@4.0.4/dist/js/bulma-carousel.min.js"></script>


</head>
<body>

<div id="wrapper" class="has-text-centered-mobile">

    <section id="contact" class="section">
        <div class="container">
            <h3 class="is-size-3 has-text-centered">
                <strong>Palindromos</strong>
            </h3>

            <div class="box">
                <div class="columns">
                    <div class="column">
                        <img src="img/undraw_mobile_inbox_3h46.svg" style="height: 80%;">
                        <p class="has-text-black paragraph has-text-centered" style="padding-top: 10px;">
                            Verificaremos si tu frase o palabra es un palindromo  <i class="fa fa-heart" aria-hidden="true" style="color: red;"></i>

                        </p>
                    </div>

                    <form onsubmit="return verificarPalindromo()" method="post">
                        <div class="field">
                            <label class="label">Frase o palabra</label>
                            <div class="control">
                                <input class="input" type="text" id="inputText" placeholder="Text input" name="inputText">
                            </div>
                        </div>
                        <div class="field is-grouped">
                            <div class="control">
                                <button class="button is-link" type="submit">Submit</button>
                            </div>
                            <div class="control">
                                <button class="button is-link is-light">Cancel</button>
                            </div>
                        </div>
                    </form>

                </div>
                <table>
                    <tr>
                        <th style="border:1px solid black; padding: 1vh">Palindromo</th>
                        <th style="border:1px solid black; padding: 1vh">Resultado</th>
                    </tr>
                    <tr>
                        <td id="palindromeCell"></td>
                        <td id="result"></td>
                    </tr>
                </table>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section id="footer" class="section">
        <div class="container has-text-centered">
            <p class="has-text-black is-size-7">
                Built with <i class="fa fa-heart" aria-hidden="true" style="color: red;"></i> by restylianos
            </p>
            <a href="https://github.com/restylianos" class="is-size-4 social-link">
                <i class="fa fa-github" aria-hidden="true" style="color: black;"></i>
            </a>
            <a href="https://www.facebook.com/profile.php?id=100011674968506" class="is-size-4 social-link">
                <i class="fa fa-facebook-square" aria-hidden="true"></i>
            </a>
        </div>
    </section>
</div>
<script>
    function verificarPalindromo() {

        //Obtener texto del input
        var inputText = document.getElementById("inputText").value;

        //Reemplazar el texto del input por minusculas y eliminar espacios
        var defaultInput = inputText.toLowerCase().replace(/\s/g, '');

        console.log(defaultInput);
        //Invertir la frase
        var reversedInput = defaultInput.split('').reverse().join('');

        console.log(reversedInput);
        //Verificación entre el texto normal y el texto invertido
        var isPalindrome = (defaultInput === reversedInput)

        // Actualizar la tabla con el palindromo y el resultado
        document.getElementById("palindromeCell").innerHTML = inputText;
        document.getElementById("result").innerHTML = isPalindrome ? "Es un palíndromo" : "No es un palíndromo";

        return false;
    }
</script>
</body>
</html>
