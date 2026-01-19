# Projet 2 : Sécurisation des pipelines CI/CD

## 1. Scénario : Détection d'une fuite de secret
Imaginez qu'un développeur pousse par mégarde un fichier de configuration contenant une **clé d'accès API AWS (Secret)** dans le dépôt Git. Le pipeline CI/CD détecte cette vulnérabilité lors de la phase de scan.

## 2. Plan d'Action Détaillé

### Étape 1 : Détection et Blocage (Immédiat)
- **Action** : Le scanner de secrets (ex: Gitleaks) échoue le build.
- **Acteur** : Pipeline Automatisé.
- **Impact** : Empêche le déploiement de la clé en production.

### Étape 2 : Communication et Alerte
- **Action** : Notification envoyée sur Slack/Email à l'équipe Sécurité et au Lead Dev.
- **Acteur** : Système de notification CI/CD.

### Étape 3 : Remédiation Technique (Urgent)
1. **Révocation** : Désactivation immédiate de la clé API sur le portail AWS pour la rendre inutile. (**Acteur : Cloud Ops**)
2. **Rotation** : Génération d'une nouvelle clé. (**Acteur : Cloud Ops**)
3. **Nettoyage Git** : Suppression définitive du secret de l'historique Git (utilisation de `git-filter-repo` ou `BFG Repo-Cleaner`). Un simple commit de suppression ne suffit pas ! (**Acteur : Développeur**)

### Étape 4 : Injection Sécurisée
- **Action** : Stocker la nouvelle clé dans un gestionnaire de secrets (ex: AWS Secrets Manager, HashiCorp Vault ou les secrets GitHub/GitLab chiffrés).
- **Acteur : DevSecOps Analyst**

### Étape 5 : Analyse Post-Mortem
- **Action** : Vérifier dans les journaux d'audit (CloudTrail) si la clé exposée a été utilisée par un tiers entre le commit et la révocation.
- **Acteur : Équipe Cyber-Sécurité**

## 3. Synthèse des Intervenants
- **Développeur** : Corrige le code et nettoie l'historique.
- **Ops/Cloud Admin** : Gère les identifiants et la rotation des clés.
- **Security Officer** : Supervise l'incident et valide la remédiation.
