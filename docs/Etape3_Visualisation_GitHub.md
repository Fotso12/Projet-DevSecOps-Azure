# 🚀 Étape 4 : Le Pipeline DevSecOps (Le côté "Visuel" Automatique)

Puisque votre compte Azure est verrouillé par Microsoft pour "activité inhabituelle", nous allons utiliser **GitHub Actions**. C'est le moteur qui va faire tourner les scans de sécurité à chaque fois que vous changez le code.

## 1. Créer le Pipeline
J'ai déjà préparé le fichier pour vous. Il se trouve ici : `.github/workflows/devsecops.yml`. 

## 2. Envoyer le Pipeline sur GitHub
Tapez ces commandes dans votre terminal PowerShell pour activer les "graphiques" de suivi :
```powershell
git add .
git commit -m "Ajout du pipeline DevSecOps avec scans SAST et SCA"
git push origin main
```

---

## 3. Ce que vous allez voir (C'est ICI que c'est graphique !)
Une fois le `push` terminé, allez sur votre dépôt GitHub :

1.  **L'onglet "Actions"** : Vous verrez une ligne jaune qui tourne. Cliquez dessus. Vous verrez en temps réel l'application se compiler et les outils de sécurité (Checkmarx, CodeQL) s'exécuter.
2.  **Les "Checkmarx" (✅ / ❌)** : Sur la page d'accueil de votre code, vous verrez une petite coche verte ou une croix rouge à côté de votre dernier commit. C'est l'indicateur visuel de santé du projet.
3.  **L'onglet "Security" > "Code scanning"** : Après quelques minutes, un tableau de bord apparaîtra ici avec des graphiques montrant les erreurs de programmation (SAST).

---

### 🎓 Ce qu'il faut dire au prof :
> "Monsieur, suite à un blocage administratif d'Azure (Deny Assignment), j'ai basculé ma stratégie DevSecOps sur **GitHub Advanced Security**. Cela prouve l'agilité du DevSecOps : la sécurité est intégrée au code (SAST) et aux dépendances (SCA) directement dans la forge logicielle, avant même d'avoir besoin d'un Cloud."

**Dites-moi dès que vous voyez la ligne jaune tourner dans l'onglet "Actions" de GitHub !**
