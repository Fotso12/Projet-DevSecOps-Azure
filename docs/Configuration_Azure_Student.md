# ☁️ Guide DevSecOps - Configuration Azure (Compte Etudiant)

Avec votre compte Azure Etudiant, vous disposez d'outils puissants pour automatiser et sécuriser votre application Spring Boot. Voici comment les paramétrer.

## 1. Sécuriser vos Secrets (Azure Key Vault)
Au lieu de mettre vos clés en clair dans le code (comme nous l'avons vu dans le scan GitLeaks), utilisez **Azure Key Vault**.

- **Configuration :**
  1. Créez un **Key Vault** dans le portail Azure.
  2. Ajoutez vos secrets (ex: `AZURE-STUDENT-KEY`).
  3. Dans Spring Boot, ajoutez la dépendance `azure-spring-boot-starter-keyvault-secrets`.
  4. L'application récupérera les clés automatiquement au démarrage sans qu'elles n'apparaissent dans Git.

## 2. Automatiser les Scans (GitHub Actions ou Azure Pipelines)
Comme vous êtes étudiant, **GitHub Actions** est souvent le plus simple car il offre 2000 minutes gratuites par mois.

- **Paramétrage :**
  - Allez dans l'onglet **Actions** de votre dépôt GitHub.
  - Utilisez le fichier `pipeline-example.yml` que je vous ai préparé.
  - **Secrets GitHub :** Allez dans `Settings > Secrets and variables > Actions` pour ajouter vos identifiants Azure ici. Ils seront utilisés pour déployer l'application après les scans de sécurité.

## 3. Hébergement Sécurisé (Azure App Service)
Utilisez le plan **F1 Free** (Gratuit) pour héberger votre application.

- **Sécurité à activer :**
  - **HTTPS Only** : Force la connexion sécurisée (Projet 4).
  - **Authentication** : Vous pouvez activer l'authentification "Easy Auth" via Microsoft/Google sans écrire une seule ligne de code.

## 4. Surveillance (Microsoft Defender for Cloud)
Même sur un compte gratuit, vous pouvez voir des recommandations de sécurité basiques.
- Allez dans **Defender for Cloud** pour voir si votre App Service a des ports ouverts ou des configurations vulnérables.

---

### 💡 Pourquoi ça ne marche pas toujours en local ?
Comme vous l'avez vu, certains outils (SCA, SAST) sont capricieux en local sous Windows (chemins Python, bases de données CVE à télécharger). 
**L'avantage majeur du Cloud (Azure/GitHub)** est que l'environnement est "propre" à chaque fois, ce qui rend ces outils beaucoup plus fiables et rapides.
