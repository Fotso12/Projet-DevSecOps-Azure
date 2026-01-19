# Projet 3 : Intégration des tests de sécurité dans les pipelines CI/CD

## 1. Plan de Test de Sécurité
L'objectif est d'automatiser la validation de la sécurité à chaque commit.

### Points Critiques à Tester :
- **Dépendances tierces** : Bibliothèques vulnérables.
- **Code source** : Injections (SQL, NoSQL), XSS, mauvaises configurations de sécurité.
- **Gestion des accès** : Forçage de routes sans authentification.
- **Secrets** : Présence de mots de passe ou clés API en clair.

## 2. Étapes du Processus de Test (Workflow CI/CD)

| Étape | Type de Test | Outil (Spring Boot) | Rôle |
| :--- | :--- | :--- | :--- |
| **Commit/Push** | Secret Scanning | Gitleaks / Husky | Empêcher le push de secrets. |
| **Build** | SCA (Composition) | OWASP Dependency-Check | Détecter les CVE dans les JARs. |
| **Static Analysis** | SAST (Source) | SonarQube / SpotBugs | Analyser la qualité et sécurité du code. |
| **Integration** | Test unitaire Sécu | JUnit + Spring Security | Vérifier les @PreAuthorize, etc. |
| **Deployment (Staging)** | DAST (Dynamique) | OWASP ZAP | Tester l'application en cours d'exécution. |

## 3. Mesures en cas de détection de vulnérabilités

1. **Seuils de Tolérance (Quality Gates)** :
   - Si une vulnérabilité de niveau **CRITICAL** ou **HIGH** est trouvée : Le pipeline s'arrête immédiatement et le déploiement est bloqué.
   - Si **MEDIUM** : Le build passe mais une alerte est générée pour traitement dans le prochain sprint.
2. **Workflow de Remédiation** :
   - Rapport automatique généré et attaché au build.
   - Création automatique d'un ticket (Jira/GitHub Issue) assigné au développeur concerné.
   - Validation par un "Security Review" avant de relancer le pipeline.

---

## Exemple de configuration Maven (Extrait de Plugins)
```xml
<!-- Plugin pour le scan des vulnérabilités des dépendances -->
<plugin>
    <groupId>org.owasp</groupId>
    <artifactId>dependency-check-maven</artifactId>
    <version>9.0.9</version>
    <executions>
        <execution>
            <goals>
                <goal>check</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
