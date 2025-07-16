# SchoolManagementSystem
Applicazione Spring Boot per la gestione di corsi, insegnanti e studenti tramite API REST.
## Descrizione
SchoolManagementSystem è una piattaforma backend che consente la gestione di corsi, insegnanti e studenti. Offre funzionalità CRUD, filtri avanzati e gestione centralizzata degli errori tramite API REST.
## Requisiti
- Java 17+
- Maven
- Spring Boot
- PostgreSQL
- Postman (per testare le API)
- IntelliJ IDEA (o altro IDE Java)
- Git (per il controllo di versione)
## Installazione
  1. Clona il repository:
     ```sh
     git clone https://github.com/Baffo81/SchoolManagmentSystem.git
     cd SchoolManagmentSystem
      ```
  2. Configura il database PostgreSQL:
        - Crea un database chiamato `school_management`.
        - Modifica le credenziali nel file `application.properties`:
        ```properties
        spring.datasource.url=jdbc:postgresql://localhost:5432/school_management
        spring.datasource.username=tuo_username
        spring.datasource.password=tuo_password
        ```
  3.Esegui il progetto:
        ```sh
        mvn clean install
        mvn spring-boot:run
        ```
  4. Apri Postman e importa il file `SchoolManagementSystem.postman_collection.json` per testare le API.
   
## Funzionalità
- **Gestione Corsi**: CRUD per corsi, con filtri per nome e descrizione.
- **Gestione Insegnanti**: CRUD per insegnanti, con filtri per nome e cognome.
- **Gestione Studenti**: CRUD per studenti, con filtri per nome, cognome e email.
- **Gestione Errori**: Gestione centralizzata degli errori con risposte standardizzate.
- **Validazione**: Validazione dei dati di input con annotazioni JSR-303.
- **Documentazione API**: Documentazione delle API con Swagger all’indirizzo http://localhost:8080/swagger-ui.html.
- **Test**: Test delle API con Postman.
## Struttura del Progetto
```
src/
 └── main/
     ├── java/
     │   └── dev/archety/sms/
     │        ├── controllers/
     │        ├── models/
     │        ├── repositories/
     │        └── services/
     └── resources/
         └── application.properties
```
## Contributi
Contributi sono benvenuti! Per favore, apri un issue o una pull request per discutere le modifiche.
## Licenza
Questo progetto è concesso in licenza sotto la Licenza MIT. Vedi il file [LICENSE](LICENSE) per i dettagli.
## Autore
Vincenzo Figliolino
