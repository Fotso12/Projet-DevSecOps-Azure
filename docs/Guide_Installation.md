# Guide d'installation des outils DevSecOps

Voici comment obtenir et installer chaque outil de notre sélection, que ce soit pour une utilisation locale (sur votre machine Windows) ou dans votre pipeline Azure/GitHub.

## 1. Dependency-Check (SCA)
**Comment l'obtenir :** Vous l'avez déjà ! Il est intégré via le fichier `pom.xml` que j'ai créé.
- **En local :** Assurez-vous d'avoir Maven installé. Lancez simplement :
  ```powershell
  mvn dependency-check:check
  ```
- **Rapports :** Un fichier `target/dependency-check-report.html` sera généré.

## 2. Semgrep (SAST)
**Comment l'obtenir :** C'est un outil en ligne de commande (CLI).
- **Sur Windows (via PowerShell) :** 
  Le plus simple est d'utiliser Python/Pip :
  ```powershell
  pip install semgrep
  ```
- **Utilisation :** Allez à la racine du projet et lancez `semgrep scan --config auto`.

## 3. GitLeaks (Secrets)
**Comment l'obtenir :** Téléchargeable sur GitHub.
- **Sur Windows :**
  1. Allez sur [GitLeaks Releases](https://github.com/gitleaks/gitleaks/releases).
  2. Téléchargez le fichier `gitleaks_x.x.x_windows_x64.zip`.
  3. Extrayez l'exécutable et ajoutez-le à votre PATH Windows.
- **Alternative (via Chocolatey) :** `choco install gitleaks`.

## 4. Trivy (Containers)
**Comment l'obtenir :** Principalement via Docker ou binaire.
- **Facile via Docker :** Si vous avez Docker Desktop, vous n'avez rien à installer, utilisez cette commande :
  ```powershell
  docker run aquasec/trivy image devsecops-demo
  ```

## 5. OWASP ZAP (DAST)
**Comment l'obtenir :** Interface graphique ou conteneur.
- **Logiciel complet :** Téléchargez l'installateur Windows sur [zaproxy.org](https://www.zaproxy.org/download/).
- **Application :** Lancez-le et entrez l'URL de votre application Spring Boot (quand elle tourne localement ou sur Azure).

---

## ⚡ Résumé pour votre Pipeline (Azure/GitHub)
Dans un pipeline (voir `pipeline-example.yml`), vous n'installez rien manuellement. Les "Actions" se chargent de tout :
- `gitleaks/gitleaks-action` : Installe et lance GitLeaks automatiquement.
- `aquasecurity/trivy-action` : Installe et lance Trivy dans le cloud.

> [!TIP]
> **Besoin d'aide pour l'install ?** Dites-moi si vous voulez que je tente d'installer `Semgrep` ou `GitLeaks` directement pour vous sur cet environnement via le terminal.
