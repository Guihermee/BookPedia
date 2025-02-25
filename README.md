# BookPedia
Projeto com intuito de servir como aprendizado para ferramenta KMP.

## Como rodar no Desktop?
* Primeiro vá main.kt do `desktopMain` package que fica no caminho: `composeApp/src/desktopMain/kotlin/br/com/cerniauskas/bookpedia/main.kt`
* Depois clica no Play do lado da fun Main().
![image](https://github.com/user-attachments/assets/f2bba57d-7fb2-4dd5-b011-edd1afa46c15)
* Você provavelmente vai receber a Exception `Exception in thread "main" java.lang.ExceptionInInitializerError`
* Então abra o terminal do seu Android Studio e escreva o comando `./gradlew run`.
* Sempre veja se o arquivo lá em cima no play está o arquivo `Main.kt` antes de rodar. Por isso precisamos rodar na mão pela primeira vez pois ele não aparece por padrão
* ![image](https://github.com/user-attachments/assets/ec6b1156-48b9-4b96-82c9-6a2f81492e2e)
