# 🎓 Guide Pédagogique : Expliquer les Alertes à votre Professeur

Maintenant que vous voyez la liste des vulnérabilités sur GitHub, voici comment vous pouvez les présenter pour briller lors de votre TD.

## 1. Qu'est-ce que nous voyons ? (SCA - Software Composition Analysis)
Expliquez à votre prof : 
> "Monsieur, ici GitHub agit comme un **Scanner SCA**. Il ne regarde pas mon code à moi, mais il analyse toutes les bibliothèques (JAR) que j'utilise. Il compare mon fichier `pom.xml` avec une base de données mondiale de virus et de failles (appelée la NVD)."

## 2. Le cas Log4j (La ligne rouge)
Montrez la ligne concernant `log4j-core` :
> "Regardez cette alerte **Critical** sur Log4j. C'est la fameuse faille Log4Shell. GitHub me montre graphiquement que mon application est exposée à une prise de contrôle à distance (RCE) simplement parce que j'utilise une version obsolète."

## 3. Le bouton magique : "Create Dependabot security update"
GitHub vous propose parfois un bouton pour créer un correctif automatique.
> "Le DevSecOps, ce n'est pas juste détecter, c'est **automatiser la correction**. Si je clique ici, GitHub va lui-même modifier mon code pour monter la version et supprimer la faille."

---

## 🚀 Étape suivante : Le Tableau de bord Azure (Phase 4)
Maintenant, nous allons passer sur votre compte Azure pour voir la "vue globale".

1.  Sur le portail Azure, cherchez **"Microsoft Defender for Cloud"**.
2.  Regardez si vous avez un **"Secure Score"** (une note sur 100).
3.  C'est ici que vous pourrez dire à votre prof : 
    > "Ici, j'ai une vue centralisée de la sécurité de toute mon infrastructure Azure Student."

**Dites-moi quand vous êtes sur la page de Microsoft Defender !**
