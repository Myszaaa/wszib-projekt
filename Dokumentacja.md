# Print3DControl

## Opis projektu

Print3DControl to aplikacja napisana w Javie z wykorzystaniem frameworka Spring Boot. 
Aplikacja integruje się z bazą danych Microsoft SQL Server.
Aplikacja służy do zarządzania i monitorowania drukarek 3D.
Na potrzeby monitorowania statusu drukarek, stworzyłem prostą dodatkową aplikację która "symuluje" zachowanie drukarki. 

## Technologie

- Java 17
- Spring Boot 3.3.2
  - Spring Data JPA
  - Spring Security
  - Spring Web
  - Thymeleaf
  - Spring Boot DevTools
- Microsoft SQL Server (MSSQL) JDBC Driver

## Wymagania wstępne

Aby uruchomić ten projekt, musisz mieć zainstalowane:

- Java 17 lub nowszą
- Apache Maven 3.x
- Microsoft SQL Server 
- Git (do klonowania repozytorium)

  1. **Sklonuj repozytorium**
       Repozytorium z projektem zarządzania drukarkami: https://github.com/Myszaaa/wszib-projekt
       Repozytorium z aplikacją która symuluje zachowanie drukarki: https://github.com/Myszaaa/Printer3DSimulator
     
  3. **Skonfiguruj połączenie z bazą danych**
       Aplikacje korzystają z bazy danych Microsoft SQL Server. Konfiguracja połączenia znajduje się w plikach `src/main/resources/application.properties` oraz `src/main/resources/db.template.properties`.
       W pliku `src/main/resources/db.template.properties` jest podana dalsza instrukcja do konfiguracji bazy danych w celu ochrony haseł. Dotyczy to wszystkich aplikacji które są potrzebne do zaprezentowania działania projektu.

  4. **Uruchom aplikację**
     Przed uruchomieniem prosze o przeładowanie maven'a.
        Uruchom jako pierwszą aplikację Print3DControl, a następnie Printer3DSimulator.
     
## Działanie aplikacji
  Wpisz w przeglądarkę w jednej karcie localhost:8080 (aplikacja Print3DControl), a w drugiej karcie localhost:8081/set_print_time (aplikacja Printer3DSimulator).
  
  -Print3DControl:
  
  1. Pokarze Ci się możliwość rejestracji oraz zalogowania już do istniejącego konta:
    ![image](https://github.com/user-attachments/assets/2f681e64-8aaf-4f34-960e-9053676c7e1a)

  2. Po Zarejestrowaniu i logowaniu zobaczysz listę z drukarkami. 
  ![image](https://github.com/user-attachments/assets/be3aa880-4f1f-489b-b18b-342a8b8fe913)

  3. Można je swobodnie dodawać do bazy danych przyciskiem Add New Printer. Podając wymagane dane drukarki.
  ![image](https://github.com/user-attachments/assets/83de9531-32da-4b96-a5a7-cb7d4e0519d6)

  4. Edytować przyciskiem Edit. Gdzie można uaktualnić oraz usunąć drukarkę z bazy. 
  ![image](https://github.com/user-attachments/assets/41d86609-ec3d-4001-b53c-c34b1e3d8f6c)

  5. Jest możliwość wylogowania użytkownika co spowoduje powrót do głównej strony.
  ![image](https://github.com/user-attachments/assets/3e6614e8-c416-4139-acd4-36c8c3381475)

  6. Aby zaprezentować monitorowanie danej drukarki musimy wykorzystać drugą aplikację Printer3DSimulator.
     W drugiej karcie localhost:8081/set_print_time powinno się pokazać możliwość wybrania ID drukarki oraz czas jaki ma nasz fantomowy wydruk.
     
       ![image](https://github.com/user-attachments/assets/093aa331-c075-4adf-af6b-f5f54e935d05)

  7. ID drukarki zobaczymy w bazie danych.
     Aby zobaczyć tabele z informacjami jakie szukamy musimy: stworzyć query.
     
     Następnie użyć naszej bazy danych: use [nazwa naszej bazy danych]
     
     Używając select * from printerUnits.Printers; wyświetlimy tablicę z drukarkami.
     
     Zobaczymy tabelę z drukarkami gdzie mozemy znaleźć informację id drukarki jaką chcemy zasymulować.
     
     ![image](https://github.com/user-attachments/assets/9edd2f86-fa87-4397-8cb2-e2f1c39dcf32)

  8. Jak wiemy jakie id ma nasza drukarka wpisujemy numer id oraz czas druku w odpowiednie miejsca i klikamy Start Printing
    
     ![image](https://github.com/user-attachments/assets/dea7ea74-7363-4e61-8788-b90def0d3abe)

   9. Co powinno się zdarzyć?
      Po wystartowaniu fantomowego wydruku Status drukarki powinien się zmienić na in progress. Następnie możemy monitorować czas jaki został do końca wydruku. Gdy osiągnie 0, status powinien się zmienić na wartość Completed.
      
      ![image](https://github.com/user-attachments/assets/44209912-1fc9-403b-875d-183ca69ce6e7)

            

     





     
