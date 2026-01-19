# Choix des Outils DevSecOps (Contexte Azure Etudiant)

Compte tenu de votre environnement **Azure Etudiant** et de l'utilisation de **Spring Boot**, voici la sélection optimale pour couvrir tout le cycle DevSecOps sans épuiser inutilement vos crédits Azure.

## 🛠 La Stack Sélectionnée

| Outil | Type | Pourquoi ce choix ? |
| :--- | :--- | :--- |
| **GitLeaks** | Secrets | **CRITIQUE** pour Azure. Empêche de pousser vos clés d'abonnement Azure ou secrets Spring (DB, API) sur GitHub/Git Lab. |
| **Dependency-Check** | SCA | Incontournable pour Java/Spring Boot. S'intègre directement dans Maven (`pom.xml`). |
| **Semgrep** | SAST | Plus léger et rapide que SonarQube pour un étudiant. Pas de serveur à gérer (s'exécute en CLI dans le pipeline). |
| **Trivy** | Containers | Idéal si vous déployez via Docker sur **Azure App Service** ou **Azure Container Registry (ACR)**. |
| **OWASP ZAP** | DAST | Pour scanner l'application une fois déployée sur Azure (URL publique). |

## 🚀 Scénario d'intégration Azure

Avec un compte Azure Etudiant, vous avez accès à **Azure DevOps** ou **GitHub Actions**. Voici comment nous allons les orchestrer :

1. **Phase de Code (Local)** : 
   - **GitLeaks** en pré-commit pour bloquer les secrets.
2. **Phase de Build (CI - Azure Pipelines/GitHub Actions)** :
   - Exécution de **Semgrep** pour le scan du code source.
   - Exécution de **Dependency-Check** via Maven pour les bibliothèques.
   - Build de l'image Docker et scan par **Trivy**.
3. **Phase de Déploiement (CD)** :
   - Déploiement sur **Azure App Service** (Plan Gratuit F1).
4. **Phase de Test (Post-Déploiement)** :
   - Lancement d'un scan **OWASP ZAP** contre l'URL `*.azurewebsites.net`.

## 💡 Pourquoi écarter SonarQube Community ?
Bien que puissant, SonarQube nécessite une machine virtuelle (VM) avec au moins 4Go de RAM et une base de données SQL. Sur un compte Azure Etudiant, cela consommerait vos crédits rapidement. **Semgrep** offre une alternative gratuite et "Serverless" très efficace.

---

### Prochaines étapes :
1. Générer le fichier `pom.xml` Spring Boot avec `dependency-check`.
2. Créer un script simple pour lancer `Semgrep` et `GitLeaks` en local.
3. Préparer le fichier de configuration Docker (Dockerfile) pour le scan `Trivy`.
