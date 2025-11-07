# Ce Readme a ete genere par ia pour expliquer le deroulement du jeu

# Text-based RPG - Guide du Joueur

Un jeu de rôle textuel en Java où vous explorez un donjon, combattez des monstres et détruisez des obstacles pour atteindre la sortie.

## 📋 Table des Matières

- [Prérequis](#prérequis)
- [Installation](#installation)
- [Comment Lancer le Jeu](#comment-lancer-le-jeu)
- [Comment Jouer](#comment-jouer)
- [Les Classes de Personnage](#les-classes-de-personnage)
- [Le Système de Combat](#le-système-de-combat)
- [Les Armes](#les-armes)
- [La Carte du Donjon](#la-carte-du-donjon)
- [Conseils Stratégiques](#conseils-stratégiques)

---

## 🎮 Prérequis

- **Java JDK 8** ou version supérieure
- Un terminal ou invite de commandes
- (Optionnel) Un IDE comme Eclipse, IntelliJ IDEA ou VS Code

---

## 📦 Installation

1. **Cloner ou télécharger le projet**

   ```bash
   git clone https://github.com/Ykolo/Text-based-RPG.git
   cd Text-based-RPG
   ```

2. **Vérifier que Java est installé**
   ```bash
   java -version
   ```

---

## 🚀 Comment Lancer le Jeu

### Option 1 : Depuis la ligne de commande

1. **Compiler le projet**

   ```bash
   javac -d bin rpg/**/*.java
   ```

2. **Lancer le jeu**
   ```bash
   java -cp bin rpg.game.Game
   ```

### Option 2 : Depuis un IDE

1. Ouvrir le projet dans votre IDE
2. Localiser la classe `Game.java` dans le package `rpg.game`
3. Exécuter le fichier (généralement clic droit → Run)

---

## 🎯 Comment Jouer

### 1. Création du Personnage

Au lancement du jeu, vous devez créer votre personnage :

```
=== CRÉATION DU PERSONNAGE ===
Entrez le nom de votre personnage :
> Aragorn

Choisissez votre classe :
1. Sorcier (Mage)
2. Elfe (Archer)
3. Guerrier (Knight)
Votre choix :
> 3
```

**Chaque classe a des statistiques différentes :**

- **Sorcier** : Équilibré (PV: 100, Attaque: 15, Défense: 10)
- **Elfe** : Rapide et précis (PV: 80, Attaque: 20, Défense: 8)
- **Guerrier** : Tank résistant (PV: 120, Attaque: 18, Défense: 12)

### 2. Le Menu Principal

Une fois votre personnage créé, vous accédez au menu principal :

```
=== MENU PRINCIPAL ===
1. Explorer le donjon
2. Visiter la boutique d'armes
3. Voir mes statistiques
4. Quitter le jeu
```

#### Option 1 : Explorer le Donjon

- Lance le mode exploration avec la carte 5x5
- Vous commencez en haut à gauche [0,0]
- Objectif : Atteindre la sortie en bas à droite [4,4]

#### Option 2 : Boutique d'Armes

- Permet d'acheter de nouvelles armes avec votre or
- Trois types d'armes disponibles (voir section [Les Armes](#les-armes))

#### Option 3 : Voir Statistiques

- Affiche vos PV, attaque, défense, niveau, XP, or
- Liste toutes vos armes en inventaire

#### Option 4 : Quitter

- Sauvegarde votre progression et quitte le jeu

### 3. Mode Exploration

Lors de l'exploration, vous voyez la carte du donjon :

```
Carte du donjon :
. . . M .
. O . . .
M . . . O
. . O . .
. . M . S

Légende : P=Vous | M=Monstre | O=Obstacle | S=Sortie | .=Vide
Position actuelle : [0, 0]
```

**Commandes de déplacement :**

- `Z` ou `z` : Aller vers le Nord (haut)
- `S` ou `s` : Aller vers le Sud (bas)
- `Q` ou `q` : Aller vers l'Ouest (gauche)
- `D` ou `d` : Aller vers l'Est (droite)
- `M` ou `m` : Retourner au menu principal

**Que se passe-t-il quand vous bougez ?**

- Si vous entrez sur une case avec un **Monstre** → Combat automatique
- Si vous entrez sur une case avec un **Obstacle** → Combat automatique
- Si vous atteignez la **Sortie** → Vous gagnez le jeu !

---

## ⚔️ Le Système de Combat

### Combat contre un Monstre

Lorsque vous rencontrez un monstre, un combat commence :

```
=== COMBAT ===
Un Gobelin (PV: 50) vous attaque !

--- Tour de combat ---
Vos PV : 100/120
PV du monstre : 50/50

1. Attaquer avec votre arme
2. Fuir le combat
```

**Options :**

- **Attaquer** : Vous infligez des dégâts au monstre

  - Les dégâts dépendent de votre arme et de vos stats
  - Le monstre riposte et vous inflige des dégâts
  - Le combat continue jusqu'à la mort de l'un des combattants

- **Fuir** : Vous retournez au menu principal
  - Pas de pénalité, mais le monstre reste sur la carte

**Récompenses après victoire :**

- **Expérience (XP)** : 20 XP par monstre
- **Or** : 15 pièces d'or par monstre
- Le monstre disparaît de la carte

### Combat contre un Obstacle

Les obstacles (rochers, barrières) peuvent être détruits :

```
=== COMBAT ===
Un Rocher (PV: 30) bloque votre chemin !

--- Tour de combat ---
Vos PV : 100/120
PV de l'obstacle : 30/30

1. Attaquer avec votre arme
2. Fuir le combat
```

**Différences avec les monstres :**

- Les obstacles ne ripostent **pas** (pas de contre-attaque)
- Vous infligez **80% des dégâts normaux** contre les obstacles
- Pas de récompense XP ou or après destruction
- L'obstacle disparaît de la carte une fois détruit

---

## 🗡️ Les Armes

### Types d'Armes

#### 1. Épée (Sword)

- **Prix** : 50 or
- **Dégâts** : 25 points
- **Meilleur usage** : Combat rapproché équilibré

#### 2. Arc (Bow)

- **Prix** : 60 or
- **Dégâts** : 30 points
- **Meilleur usage** : Attaques à distance, dégâts élevés

#### 3. Bâton (Staff)

- **Prix** : 40 or
- **Dégâts** : 20 points
- **Meilleur usage** : Économique, bon pour débuter

### Boutique d'Armes

```
=== BOUTIQUE D'ARMES ===
Votre or : 100

1. Épée (50 or) - Dégâts: 25
2. Arc (60 or) - Dégâts: 30
3. Bâton (40 or) - Dégâts: 20
4. Quitter la boutique
```

**Astuce** : Achetez plusieurs armes pour avoir plus d'options en combat !

---

## 🗺️ La Carte du Donjon

### Structure de la Carte

- Grille de **5x5 cases** (25 cases au total)
- **Position de départ** : Coin supérieur gauche [0,0]
- **Sortie** : Coin inférieur droit [4,4]

### Entités sur la Carte

- **Monstres** : 3-4 monstres générés aléatoirement

  - Types : Gobelin, Orc, Dragon
  - Bloquent votre passage, doivent être combattus ou évités

- **Obstacles** : 2-3 obstacles générés aléatoirement
  - Types : Rocher, Barrière
  - Bloquent votre passage, peuvent être détruits

### Système de Coordonnées

```
[0,0] [0,1] [0,2] [0,3] [0,4]
[1,0] [1,1] [1,2] [1,3] [1,4]
[2,0] [2,1] [2,2] [2,3] [2,4]
[3,0] [3,1] [3,2] [3,3] [3,4]
[4,0] [4,1] [4,2] [4,3] [4,4] <- Sortie
```

**Important** : Les entités sont placées aléatoirement à chaque nouvelle partie !

---

## 💡 Conseils Stratégiques

### Pour Débuter

1. **Achetez une arme dès le début**

   - Utilisez votre or de départ (100 pièces) pour acheter au moins un Bâton
   - Sans arme, vous ne pouvez pas attaquer !

2. **Explorez prudemment**

   - Regardez la carte avant de bouger
   - Planifiez votre route pour éviter trop de combats

3. **Gérez vos points de vie**
   - Si vos PV sont bas, retournez au menu (touche `M`)
   - Attention : il n'y a pas de soin automatique !

### Stratégies Avancées

#### Choix de la Classe

- **Sorcier** : Bon pour les débutants, équilibré
- **Elfe** : Pour les joueurs agressifs, tue rapidement mais fragile
- **Guerrier** : Pour les joueurs prudents, encaisse beaucoup de dégâts

#### Gestion de l'Or

- Priorité 1 : Acheter une première arme
- Priorité 2 : Acheter l'Arc (meilleurs dégâts)
- Priorité 3 : Diversifier votre arsenal

#### Tactiques de Combat

- **Contre les Monstres** : Privilégiez l'Arc (30 dégâts) pour les tuer rapidement
- **Contre les Obstacles** : Utilisez le Bâton pour économiser vos armes fortes
- **Fuite** : N'hésitez pas à fuir si vos PV sont critiques

#### Optimisation du Parcours

1. Étudiez la carte au début
2. Repérez le chemin le plus court vers la sortie
3. Contournez les groupes d'ennemis si possible
4. Les obstacles ne ripostent pas → plus sûrs que les monstres

---

## 🏆 Condition de Victoire

**Vous gagnez quand :**

- Vous atteignez la case de sortie [4,4]
- Peu importe combien de monstres/obstacles restent sur la carte

**Message de victoire :**

```
🎉 FÉLICITATIONS ! Vous avez atteint la sortie du donjon ! 🎉
```

---

## ❓ FAQ

**Q : Que se passe-t-il si je meurs en combat ?**  
A : Actuellement, le jeu continue. Faites attention à vos PV !

**Q : Puis-je récupérer des PV ?**  
A : Non, il n'y a pas de système de soin dans cette version.

**Q : Les monstres réapparaissent-ils ?**  
A : Non, une fois vaincus, ils disparaissent définitivement de la carte.

**Q : Puis-je sauvegarder ma partie ?**  
A : Non, chaque session est une nouvelle partie.

**Q : Combien d'armes puis-je avoir ?**  
A : Illimité, tant que vous avez l'or pour les acheter.

---

## 🎮 Exemple de Partie Complète

```
1. Créer un Guerrier nommé "Thor"
2. Acheter un Bâton (40 or) → Reste 60 or
3. Explorer le donjon
4. Vaincre un Gobelin → +20 XP, +15 or (total: 75 or)
5. Retourner au menu (touche M)
6. Acheter une Épée (50 or) → Reste 25 or
7. Explorer à nouveau
8. Contourner un Orc
9. Détruire un Rocher
10. Vaincre un autre Gobelin → +20 XP, +15 or (total: 40 or)
11. Atteindre la sortie [4,4]
12. VICTOIRE ! 🎉
```

---

## 📞 Support

Pour toute question ou bug :

- GitHub : [Ykolo/Text-based-RPG](https://github.com/Ykolo/Text-based-RPG)
- Issues : Ouvrez une issue sur le repository

---

## 📄 Licence

Ce projet est développé dans un cadre éducatif.

---

**Bon courage, aventurier ! Que la chance soit avec vous dans votre exploration du donjon ! ⚔️🛡️**
