# Projet 4 : Étude de cas - Gestion des vulnérabilités

## 1. Cas Pratique : Application Spring Boot e-Commerce
Imaginez une application de vente en ligne utilisant **Spring Boot 2.5.x**. Lors d'un scan de routine, deux vulnérabilités sont identifiées.

## 2. Analyse Approfondie

### Vulnérabilité A : Spring Cloud Function RCE (CVE-2022-22963)
- **Type** : Remote Code Execution (RCE).
- **Gravité** : Critique (Score CVSS: 9.8).
- **Analyse** : Permet à un attaquant de forger des en-têtes HTTP pour exécuter du code sur le serveur. Risque de vol de base de données client.

### Vulnérabilité B : Utilisation de HTTP à la place de HTTPS
- **Type** : Mauvaise configuration TLS.
- **Gravité** : Moyenne.
- **Analyse** : Risque d'attaque Man-in-the-Middle (MITM) sur les réseaux non sécurisés.

## 3. Stratégies de Remédiation Adaptées

| Vulnérabilité | Stratégie de Remédiation | Meilleure Pratique |
| :--- | :--- | :--- |
| **CVE-2022-22963** | **Patching immédiat** : Monter la version de Spring Cloud à 3.1.7+ ou 3.2.3+. | **Vulnerability Shielding** : Utiliser un WAF (Web Application Firewall) pour bloquer les requêtes malveillantes en attendant le patch. |
| **HTTP non sécu** | **Configuration** : Activer `server.ssl.enabled=true` et forcer HSTS. | **Enforcement** : Utiliser "Security by Default" dans les templates de config. |

## 4. Meilleures Pratiques de Gestion
1. **Inventaire Asset** : Savoir exactement quelles versions tournent où (SBOM - Software Bill of Materials).
2. **Priorisation** : Utiliser le score CVSS combiné à l'exposition (Ex: une faille critique sur un outil interne non exposé est moins prioritaire qu'une faille moyenne sur le portail client).
3. **Automatisation** : Intégrer les patchs dans le cycle de vie normal des sprints.
