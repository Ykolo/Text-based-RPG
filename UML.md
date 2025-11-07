L'UML a ete genere avec plantUML.online grace au fichier diagramme_uml.puml

# Diagramme UML du Projet Text-based RPG

## 📊 Vue d'ensemble

Ce diagramme UML représente l'architecture complète du projet RPG en Java.

## 🏗️ Structure des packages

### 1. **rpg.entities**

- `Player` : Représente le joueur avec ses statistiques, inventaire et actions

### 2. **rpg.entities.Destructible**

- `Destructible` (interface) : Contrat pour tout ce qui peut être détruit
- `Monster` : Ennemis avec HP, attaque, récompenses (XP, Or)
- `Obstacle` : Obstacles destructibles sans contre-attaque

### 3. **rpg.weapons**

- `Weapon` (abstract) : Classe de base pour toutes les armes
- `Sword`, `Bow`, `Staff` : Armes concrètes avec stats spécifiques

### 4. **rpg.game**

- `Game` : Classe principale gérant la boucle de jeu
- `Battle` : Gère les combats contre monstres et obstacles
- `Map` : Carte 2D avec déplacements et génération d'entités
- `WeaponStore` : Magasin d'armes

## 🔗 Relations principales

### Implémentations

- `Monster` et `Obstacle` implémentent `Destructible`

### Héritages

- `Sword`, `Bow`, `Staff` héritent de `Weapon`

### Compositions/Agrégations

- `Player` possède plusieurs `Weapon` (0..\*)
- `Game` crée et utilise `Player`, `Map`, `WeaponStore`
- `Battle` utilise `Player` et `Destructible`
- `WeaponStore` contient des `Weapon`

### Dépendances

- `Player` attaque les `Destructible` avec des `Weapon`
- `Weapon` a des méthodes spécifiques pour `Monster` et `Obstacle`
- `Map` crée des `Monster` et `Obstacle`

## 📖 Comment visualiser le diagramme

### Option 1 : Extension VS Code

1. Installer l'extension "PlantUML" dans VS Code
2. Ouvrir le fichier `uml_diagram.puml`
3. Appuyer sur `Alt+D` pour prévisualiser

### Option 2 : PlantUML en ligne

1. Aller sur http://www.plantuml.com/plantuml/uml/
2. Copier le contenu de `uml_diagram.puml`
3. Coller dans l'éditeur en ligne

### Option 3 : Ligne de commande

```bash
# Installer PlantUML
# Sur Windows avec Chocolatey:
choco install plantuml

# Générer l'image
plantuml uml_diagram.puml

# Cela crée uml_diagram.png
```

## 🎯 Points clés de l'architecture

### Design Patterns utilisés

1. **Interface Segregation** : `Destructible` définit un contrat commun
2. **Abstract Factory** : `Weapon` comme classe abstraite
3. **Composition over Inheritance** : `Player` compose des `Weapon`
4. **Polymorphisme** : `Battle` accepte tout `Destructible`

### Principes SOLID

- ✅ **Single Responsibility** : Chaque classe a une responsabilité claire
- ✅ **Open/Closed** : Facile d'ajouter de nouveaux types d'armes ou de monstres
- ✅ **Liskov Substitution** : `Monster` et `Obstacle` sont interchangeables via `Destructible`
- ✅ **Interface Segregation** : Interface minimale et cohérente
- ✅ **Dependency Inversion** : Dépendance sur l'interface `Destructible`, pas les implémentations

## 📝 Légende UML

- `+` : public
- `-` : private
- `#` : protected
- `{final}` : attribut final (constante)
- `{abstract}` : classe/méthode abstraite
- `--|>` : héritage (extends)
- `..|>` : implémentation (implements)
- `o--` : agrégation
- `*--` : composition
- `..>` : dépendance

## 🔄 Flux d'exécution

1. `Main` → démarre `Game`
2. `Game` → crée `Player` et `Map`
3. `Game.explore()` → affiche la carte et gère les déplacements
4. Rencontre → `Battle` créé avec `Player` et `Destructible`
5. Combat → `Player` attaque avec `Weapon`
6. Victoire → récompenses et progression
7. Objectif → atteindre la sortie de la carte

## 📦 Extensibilité

Pour ajouter de nouvelles fonctionnalités :

- **Nouvelle arme** : Créer une classe héritant de `Weapon`
- **Nouveau monstre** : Créer une instance de `Monster` avec des stats différentes
- **Nouveau type d'entité** : Implémenter `Destructible`
- **Nouvelle mécanique** : Ajouter dans `Battle` ou `Game`

## 🎮 Fonctionnalités couvertes

✅ Création de personnage  
✅ Inventaire d'armes  
✅ Combat contre monstres (avec contre-attaque)  
✅ Destruction d'obstacles  
✅ Magasin d'armes  
✅ Système XP et Or  
✅ Carte 2D avec déplacements  
✅ Objectif : Sortie du donjon
