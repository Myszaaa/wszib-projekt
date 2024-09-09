# Print3DControl

## Opis projektu

Print3DControl to aplikacja napisana w Javie z wykorzystaniem frameworka Spring Boot. 
Aplikacja integruje się z bazą danych Microsoft SQL Server i zawiera funkcje takie jak bezpieczeństwo, obsługa stron internetowych oraz silnik szablonów Thymeleaf do renderowania frontendu. 
Aplikacja służy do zarządzania i monitorowania drukarek 3D.
Na potrzeby monitorowania statusu drukarek, stworzyłem prostą dodatkową aplikację która "symuluje" zachowanie drukarki. 

## Technologie

- Java 17
- Spring Boot 3.3.2
  - Spring Data JPA
  - Spring Security
  - Spring Web
  - Thymeleaf z integracją Spring Security 6
  - Spring Boot DevTools
- Microsoft SQL Server (MSSQL) JDBC Driver

## Wymagania wstępne

Aby uruchomić ten projekt, musisz mieć zainstalowane:

- Java 17 lub nowszą
- Apache Maven 3.x
- Microsoft SQL Server (lub dostęp do działającej instancji MSSQL)
- Git (do klonowania repozytorium)

  1. **Sklonuj repozytorium**
       Repozytorium z projektem zarządzania drukarkami: https://github.com/Myszaaa/wszib-projekt
       Repozytorium z aplikacją która symuluje zachowanie drukarki: https://github.com/Myszaaa/Printer3DSimulator
     
  3. **Skonfiguruj połączenie z bazą danych**
       Aplikacje korzystają z bazy danych Microsoft SQL Server. Konfiguracja połączenia znajduje się w plikach `src/main/resources/application.properties` oraz `src/main/resources/db.template.properties`.
       W pliku `src/main/resources/db.template.properties` jest podana dalsza instrukcja do konfiguracji bazy danych w celu ochrony haseł. Dotyczy to wszystkich aplikacji które są potrzebne do zaprezentowania działania projektu.

  4. ** Uruchom aplikację**
        Uruchom jako pierwszą aplikację Print3DControl, a następnie Printer3DSimulator.
     
## Działanie aplikacji
  Wpisz w przeglądarkę w jednej karcie localhost:8080 (aplikacja Print3DControl), a w drugiej karcie localhost:8081/set_print_time (aplikacja Printer3DSimulator).
  
  -Print3DControl:
    ![image](https://github.com/user-attachments/assets/2f681e64-8aaf-4f34-960e-9053676c7e1a)

     
