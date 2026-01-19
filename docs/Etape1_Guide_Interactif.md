# 🚀 Guide Pas à Pas : Votre TD DevSecOps sur Azure

Puisque vous êtes sur le portail Azure, voici exactement ce que nous allons faire. Suivez ces étapes, et je vous expliquerai quoi dire à votre professeur à chaque fois.

---

## Étape 1 : Créer votre "Maison" sur le Cloud (GitHub)
*Pourquoi ?* C'est sur GitHub que nous verrons les premiers graphiques de sécurité (SCA et SAST).

1. Allez sur [GitHub.com](https://github.com) et créez un nouveau dépôt public nommé `Projet-DevSecOps-Azure`.
2. **Ne cochez rien** (pas de README, pas de licence).
3. Copiez l'URL du dépôt (ex: `https://github.com/votre-nom/Projet-DevSecOps-Azure.git`).

---

## Étape 2 : Envoyer le code depuis votre PC
1. Ouvrez votre terminal (PowerShell).
2. Déplacez-vous dans le dossier de votre projet avec cette commande :
   ```powershell
   cd "c:\Users\Darryl\Documents\Cours_EADL\DevSecOps\projetDevSecOps"
   ```
3. Copiez-collez ensuite ces commandes une par une :
```powershell
git init
git add .
git commit -m "Initial commit - Stock Management App"
git branch -M main
git remote add origin [L_URL_QUE_VOUS_AVEZ_COPIEE]
git push -u origin main
```

---

## Étape 3 : Activez les "Yeux de Sécurité" (Le côté Visuel !)
Une fois le code sur GitHub, allez sur la page de votre dépôt GitHub :
1. Cliquez sur l'onglet **"Security"**.
2. Cliquez sur **"Code scanning"** -> Activez **CodeQL** (c'est le SAST visuel).
3. Cliquez sur **"Dependabot alerts"** -> Activez-le (c'est le SCA visuel).

> **💡 À expliquer au prof :** 
> "Monsieur, ici nous avons activé le **Shift Left Security**. Dès que le code est poussé, GitHub analyse automatiquement les bibliothèques et le code. Regardez ce graphique : il nous montre déjà que ma bibliothèque Log4j est dangereuse !"

---

## Étape 4 : Sur le Portail Azure (Microsoft Defender)
Maintenant, retournez sur votre onglet **Azure Portal** :
1. Dans la barre de recherche en haut, tapez **"Microsoft Defender for Cloud"**.
2. Cliquez sur **"Environments settings"**.
3. C'est ici que vous voyez votre **"Secure Score"**.

---

### Prochaine étape quand vous aurez créé le dépôt GitHub :
Dites-le moi, et je vous donnerai le code pour le fichier `Dockerfile` afin d'utiliser votre **Docker Desktop** et envoyer l'image sur Azure !
