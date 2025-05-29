# Microservices Spring Boot – Architecture complète

Ce projet regroupe plusieurs microservices développés avec Spring Boot, orchestrés avec Docker Compose, et utilisant une configuration centralisée via Spring Cloud Config.

## 📦 Microservices inclus

- **config-service** : Service de configuration centralisée
- **eureka-discoveryservice** : Service de découverte Eureka
- **gatewayservice** : API Gateway (Spring Cloud Gateway)
- **produit-service** : Gestion des produits
- **client-service** : Gestion des clients
- **factureservice** : Gestion des factures
- **reglement-service** : Gestion des règlements
- **authentificationservice** : Service d’authentification

## 🗂️ Structure du projet

├── config-service/
├── eureka-discoveryservice/
├── gatewayservice/
├── produit-service/
├── client-service/
├── factureservice/
├── reglement-service/
├── authentificationservice/
├── docker-compose.yml
├── cloud-conf/ # Dossier de configuration centralisée
└── README.md

## ⚙️ Prérequis

- [Docker](https://www.docker.com/) et [Docker Compose](https://docs.docker.com/compose/)
- Java 17+ et Maven (pour développement local)
- Un compte GitHub/GitLab (pour versionner le projet)

---

## 🚀 Lancer l’architecture complète

1. **Cloner le projet**

   ```bash
   git clone <url-du-repo>
   cd <nom-du-dossier>
   ```

2. **Configurer les fichiers de configuration**

   - Place tes fichiers de configuration dans le dossier `cloud-conf/` (exemple : `application-produit-service.properties`, etc.)
   - Exemple pour `produit-service` :
     ```properties
     # cloud-conf/application-produit-service.properties
     globalParam=3333
     monParam=1234
     email=ton@email.com
     ```

3. **Construire et démarrer tous les services**

   ```bash
   docker-compose up --build
   ```

   > Les images Docker seront construites et tous les services démarrés automatiquement.

4. **Arrêter tous les services**
   ```bash
   docker-compose down
   ```

---

## 🔗 Points d’accès principaux

| Service                  | URL                                            |
| ------------------------ | ---------------------------------------------- |
| Config Server            | [http://localhost:5555](http://localhost:5555) |
| Eureka Discovery         | [http://localhost:8761](http://localhost:8761) |
| Gateway                  | [http://localhost:8888](http://localhost:8888) |
| Produit Service          | [http://localhost:8082](http://localhost:8082) |
| Client Service           | [http://localhost:8081](http://localhost:8081) |
| Facture Service          | [http://localhost:8083](http://localhost:8083) |
| Règlement Service        | [http://localhost:8084](http://localhost:8084) |
| Authentification Service | [http://localhost:8089](http://localhost:8089) |

---

## 📝 Exemple de configuration centralisée

Dans `cloud-conf/application-produit-service.properties` :
