Aplikacja na zaliczenie z Archtektury

Wymagana JAVA 8 SDK w wersji 1.8.0_172 lub nowsza (1.8.0_???).
Stawiacie bazę MYSQL na komputerze (u siebie lokalnie) i zmieniacie w pliku ..\spring-login\src\main\resources\application.properties
dane logowania na własne.
Apka sama stworzy potrzebne tabelki do logowania.

Jeżeli stworzycie jakąś nową tabele dodajcie skryptu tworzące/rozszerzające do pliku data.sql (jest on wykonywany przy każdym uruchomieniu apki i automatycznie skoryguje baze danych).



Rejestracja:
- http://localhost:8080/registration

Logowanie:
- http://localhost:8080/login
