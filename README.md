# 🏥 Application de Gestion des Patients

Cette application web JEE est basée sur Spring MVC, Thymeleaf et Spring Data JPA. Elle permet de gérer efficacement les informations des patients avec diverses fonctionnalités.

# 📋 Partie 1

## ⭐ Fonctionnalités principales

- 📊 Affichage de la liste des patients
- 📑 Pagination des résultats
- 🔍 Recherche des patients par nom
- 🗑️ Suppression d'un patient
- ➕ Ajout de nouveaux patients

## 🛠️ Technologies utilisées

- 🔧 Spring Boot
- 🌐 Spring MVC
- 💾 Spring Data JPA
- 🎨 Thymeleaf
- 📱 Bootstrap 5
- 🗄️ Base de données : H2 (développement) et MySQL (production)
- 📦 Maven

## Configuration et déploiement

### Configuration de la base de données H2 (développement)

L'application utilise initialement la base de données H2 en mémoire pour le développement. La console H2 est accessible à l'adresse suivante après démarrage de l'application :

```
http://localhost:8084/h2-console
```

![image](https://github.com/user-attachments/assets/d48ccdc6-4ce7-45bf-8aef-f9914ffe60fa)

![image](https://github.com/user-attachments/assets/803155b2-4d5e-4c33-99cb-3550f7424dba)

Configuration dans `application.properties` :

```properties
server.port=8084
spring.datasource.url=jdbc:h2:mem:patients-db
spring.h2.console.enabled=true
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

### Migration de H2 vers MySQL

Pour passer de H2 à MySQL, modifiez le fichier `application.properties` comme suit :

```properties
server.port=8084
spring.datasource.url=jdbc:mysql://localhost:3306/hopital?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
```

![image](https://github.com/user-attachments/assets/4b9075b2-9c64-42be-b578-d1bca8e70c44)

PhpMyAdmin peut être utilisé pour administrer la base de données MySQL.

## Interface utilisateur

### Affichage des patients

![image](https://github.com/user-attachments/assets/0603da09-a560-4101-975c-8b15c037ef29)

L'interface d'affichage des patients utilise Thymeleaf pour le rendu HTML côté serveur :

- Tableau avec pagination
- Colonnes : ID, Nom, Date de naissance, Statut de la maladie, Score

### Intégration de Bootstrap

![image](https://github.com/user-attachments/assets/e6a7c564-a6f5-4ede-b375-05a77a66ef81)

L'application utilise Bootstrap 5 pour une interface responsive et moderne :

- Navigation intuitive
- Tableaux stylisés
- Formulaires élégants
- Boutons d'action

### Pagination

![image](https://github.com/user-attachments/assets/19342b82-c7c2-4a8f-af8b-fa05df28d841)

La pagination est implémentée avec :

- Contrôle du nombre d'éléments par page
- Navigation entre les pages
- Affichage du nombre total de pages

### Recherche des patients

![image](https://github.com/user-attachments/assets/180126cf-28cf-4b27-bba5-293e100029e7)

Un formulaire de recherche permet de filtrer les patients par nom :

- Recherche en temps réel
- Résultats paginés

### Suppression des patients

![image](https://github.com/user-attachments/assets/3d9b78eb-a053-42da-b813-2f44b7e109e9)

La fonctionnalité de suppression inclut :

- Bouton de suppression pour chaque patient
- Confirmation avant suppression
- Notification après suppression réussie

# 🔧 Partie 2: Templates et Validation

![image](https://github.com/user-attachments/assets/86a6c3ae-b2f3-4f00-8fd4-386e3a2ef3ab)


## 📝 Création du Template Layout

![image](https://github.com/user-attachments/assets/49c82cc9-1795-4446-a437-7fdd491149da)

Un template global a été créé pour maintenir une cohérence visuelle à travers l'application :

- 📱 Navigation responsive avec Bootstrap
- 📑 Menu déroulant pour les actions patients
- 🎨 Zone de contenu dynamique avec Thymeleaf Layout Dialect
- 🎯 Support pour les icônes Bootstrap

## ✅ Validation des Formulaires

![image](https://github.com/user-attachments/assets/89806dfa-fd16-49cd-b3b7-eb2ae35f4bf4)

### 🔒 Validation Côté Serveur

Les données patient sont validées avec Jakarta Validation :

- 📝 Nom : 4-40 caractères, obligatoire
- 📅 Date de naissance : obligatoire, date passée
- 📊 Score : minimum 100
- 🏥 Statut santé : booléen

## 📁 Structure du Projet

```
src/
├── 📂 main/
│   ├── 📂 java/ma/enset/hopital/
│   │   ├── 📂 entities/
│   │   │   └── 📄 Patient.java         # Entité JPA avec validations
│   │   ├── 📂 repository/
│   │   │   └── 📄 PatientRepository.java # Interface Repository
│   │   ├── 📂 web/
│   │   │   └── 📄 PatientController.java # Contrôleur MVC
│   │   └── 📄 HopitalApplication.java   # Class principale
│   └── 📂 resources/
│       ├── 📂 templates/
│       │   ├── 📄 template1.html        # Template layout principal
│       │   ├── 📄 patients.html         # Liste des patients
│       │   └── 📄 formPatients.html     # Formulaire patient
│       ├── 📂 static/
│       │   └── 📂 css/                  # Styles personnalisés
│       └── 📄 application.properties    # Configuration
```
