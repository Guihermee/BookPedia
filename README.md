# BookPedia
Projeto com intuito de servir como aprendizado para ferramenta KMP. Coisas que eu aprendi:
- Remote API - Ktor
- Local database - Room
- Navigation
- Animation
- Injeção de dependência - Koin
- Clean architecture
- MVI em vez de MVVM

## Como rodar no Desktop?
* Primeiro vá main.kt do `desktopMain` package que fica no caminho: `composeApp/src/desktopMain/kotlin/br/com/cerniauskas/bookpedia/main.kt`
* Depois clica no Play do lado da fun Main().
* 
![image](https://github.com/user-attachments/assets/f2bba57d-7fb2-4dd5-b011-edd1afa46c15)

* Você provavelmente vai receber a Exception `Exception in thread "main" java.lang.ExceptionInInitializerError`
* Então abra o terminal do seu Android Studio e escreva o comando `./gradlew run`.
* Sempre veja se o arquivo lá em cima no play está o arquivo `Main.kt` antes de rodar. Por isso precisamos rodar na mão pela primeira vez pois ele não aparece por padrão

![image](https://github.com/user-attachments/assets/ec6b1156-48b9-4b96-82c9-6a2f81492e2e)

Depois disso provavelmente deve funcionar:

### Desktop
![image](https://github.com/user-attachments/assets/3522e11a-0fcc-45c4-b746-0c90e0c17129)

### Android:
![image](https://github.com/user-attachments/assets/9e097057-d0aa-479f-86bb-5c91aac86d04)
