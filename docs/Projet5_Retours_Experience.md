# Projet 5 : Retours d'expérience et bonnes pratiques

## 1. Expérience Réelle : Intégration de SonarQube et Snyk
Dans un projet précédent, nous avons intégré **Snyk** pour le scan des vulnérabilités de dépendances et **SonarQube** pour la qualité du code.

### Enseignements Tirés :
- **Le déluge d'alertes** : Au début, nous avons eu plus de 200 vulnérabilités détectées. La plupart étaient des bibliothèques transitives (dépendances de dépendances).
- **Le besoin de priorisation** : On ne peut pas tout corriger en un jour. Il a fallu définir une règle : "Pas de déploiement si une nouvelle vulnérabilité HIGH est introduite".
- **L'importance des faux positifs** : Certains outils signalent des vulnérabilités qui ne sont pas exploitables dans notre contexte précis.

## 2. Recommandations pour l'optimisation

1. **Intégration dans l'IDE** : Installer les plugins (ex: SonarLint, Snyk) pour que le développeur voit les failles **avant** de commiter son code.
2. **Scan au Pull Request** : Les résultats doivent apparaître directement dans la discussion de la PR. Si le développeur doit aller sur un site tiers pour voir ses erreurs, il ne le fera pas.
3. **Mise à jour régulière** : Automatiser la montée de version des dépendances avec des outils comme **Dependabot** ou **Renovate**.
4. **Gestion du "Legacy"** : Ne pas essayer de corriger 10 ans de dettes techniques de sécurité d'un coup. Fixer le "New Code" d'abord, puis assainir l'existant progressivement.

---

# 🏁 Synthèse Globale du Plan d'Action

Pour mettre en œuvre ces 5 projets, l'approche technique retenue est :
1. **Socle** : Application Spring Boot 3.x.
2. **Sécurité Application** : Spring Security pour l'AuthN/AuthZ.
3. **Pipeline (Simulation)** : 
   - Utilisation de Maven pour orchestrer les scans.
   - Utilisation de `dependency-check-maven` pour le SCA.
   - Utilisation de `spotbugs-maven-plugin` pour le SAST simple.
