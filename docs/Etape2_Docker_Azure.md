# 🐳 Étape 5 : Conteneurisation et Scan Azure (Le côté Docker)

C'est ici que vous allez utiliser **Docker Desktop** pour la première fois dans votre TD.

## 1. Préparer Docker Desktop
- **Action :** Lancez l'application **Docker Desktop** sur votre PC. 
- **Pourquoi ?** C'est le moteur qui va "emballer" votre application Spring Boot dans une boîte étanche (un conteneur).
- **Vérification :** Attendez que l'icône de la petite baleine dans votre barre des tâches Windows devienne verte (stable).

---

## 2. Créer le Registre sur Azure (Le côté Visuel)
Avant de lancer Docker, nous devons préparer l'endroit où Azure va recevoir l'image.

1. Allez sur le **Portail Azure**.
2. Dans la barre de recherche, tapez **"Container registries"** et cliquez sur le premier résultat.
3. Cliquez sur **"+ Create"**.
4. Remplissez les champs :
   - **Resource group** : Créez-en un nouveau nommé `RG-DevSecOps`.
   - **Registry name** : Choisissez un nom unique (ex: `regdevsecops[votre-nom]`.
   - **Location** : Choisissez la même région que votre compte (ex: North Europe).
   - **Niveau de tarification (SKU)** : Choisissez **Standard** (C'est requis pour que Microsoft Defender puisse scanner l'image et vous donner des graphiques).
5. Cliquez sur **"Review + create"** puis **"Create"**.

---

## 2b. Installer Azure CLI (Si vous ne l'avez pas)
Pour que votre PC puisse parler à Azure, vous avez besoin de l'outil `az`.

- **Action :** Ouvrez PowerShell et tapez cette commande :
  ```powershell
  winget install -e --id Microsoft.AzureCLI
  ```
- **Redémarrage :** Une fois l'installation finie, **fermez et rouvrez** votre terminal PowerShell pour que la commande `az` soit reconnue.

---

## 3. Construire et Envoyer (Depuis votre PC)
Une fois que Docker Desktop est lancé et que le registre Azure est créé, tapez ces commandes dans votre terminal PowerShell :

```powershell
# 1. Compiler l'application (pour avoir le fichier .jar)
./bin/maven-mvnd/maven-mvnd-1.0.3-windows-amd64/bin/mvnd.exe clean package -DskipTests

# 2. Construire l'image Docker
docker build -t devsecops-demo .

# 3. Connexion à Azure
az login
az acr login --name [NOM_DE_VOTRE_REGISTRE]

# 4. Envoyer l'image sur Azure
docker tag devsecops-demo [NOM_DE_VOTRE_REGISTRE].azurecr.io/devsecops-demo:v1
docker push [NOM_DE_VOTRE_REGISTRE].azurecr.io/devsecops-demo:v1
```

---

### 🎓 Ce qu'il faut dire au prof :
> "Monsieur, en utilisant Docker, j'applique le principe d'**Isolation**. Mon image utilise `alpine` (une version de Linux très légère) pour réduire la surface d'attaque. Une fois l'image sur Azure, le service **Microsoft Defender** va la scanner graphiquement pour vérifier qu'aucune faille n'est apparue durant la conteneurisation."

**Dites-moi quand Docker Desktop est lancé et que vous avez créé le Registre sur Azure !**
