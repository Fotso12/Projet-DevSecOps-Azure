# Projet 1 : Importance de la sécurité dans le processus de développement

## 1. Contexte et Enjeux
La sécurité ne doit plus être une étape finale ("Security at the end") mais intégrée dès le début (approche **Shift Left**). Une négligence peut avoir des conséquences dévastatrices.

## 2. Exemple Concret : La Faille Log4Shell (CVE-2021-44228)
- **Description** : Une vulnérabilité critique dans la bibliothèque de journalisation Java `log4j`.
- **Mécanisme** : Permettait à un attaquant d'exécuter du code arbitraire à distance en envoyant simplement une chaîne de caractères spécifique (ex: dans un en-tête HTTP).

### Impact d'une négligence :
- **Technique** : Prise de contrôle totale des serveurs (RCE).
- **Financier** : Des milliards de dollars dépensés globalement pour le patch management et la réponse aux incidents.
- **Réputationnel** : Perte de confiance des clients (ex: Equifax en 2017, bien que lié à une autre faille, illustre l'impact sur la valeur boursière).

## 3. Mesures Préventives
Pour éviter ces situations, voici les mesures à instaurer :

| Mesure | Description | Outil suggéré |
| :--- | :--- | :--- |
| **SCA** | Analyse automatique des dépendances pour détecter les bibliothèques obsolètes ou vulnérables. | OWASP Dependency-Check, Snyk |
| **SAST** | Analyse statique du code source pour identifier les failles (SQLi, XSS) durant le développement. | SonarQube, Semgrep |
| **Culture DevSecOps** | Formation continue des développeurs sur les risques (OWASP Top 10). | Ateliers, Security Champions |
| **IAST/DAST** | Tests de sécurité dynamiques en environnement de staging. | OWASP ZAP |
