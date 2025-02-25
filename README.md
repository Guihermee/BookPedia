# BookPedia
A project aimed at learning KMP (Kotlin Multiplatform). Things I learned:

- Remote API - Ktor
- Local database - Room
- Navigation
- Animation
- Dependency Injection - Koin
- Clean Architecture
- MVI instead of MVVM

## How to run it on Desktop?
1. First, go to `main.kt` inside the `desktopMain` package, located at:  
   `composeApp/src/desktopMain/kotlin/br/com/cerniauskas/bookpedia/main.kt`
2. Then, click the **Play** button next to the `fun main()`.

![image](https://github.com/user-attachments/assets/f2bba57d-7fb2-4dd5-b011-edd1afa46c15)

3. You will probably get the following exception:  
   **`Exception in thread "main" java.lang.ExceptionInInitializerError`**
4. To fix this, open the **Android Studio terminal** and run the command:
   ```sh
   ./gradlew run


After that, it should work properly.

### Desktop
![image](https://github.com/user-attachments/assets/3522e11a-0fcc-45c4-b746-0c90e0c17129)

### Android:
![image](https://github.com/user-attachments/assets/9e097057-d0aa-479f-86bb-5c91aac86d04)
