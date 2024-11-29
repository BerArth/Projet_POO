# [Nom du Jeu]

## Description

    Bienvenue dans [Nom du Jeu], un jeu d'aventure textuel où vous incarnez un héros qui explore des pièces, résout des énigmes et affronte des ennemis dans un monde mystérieux.

## Prérequis

    - Java version 8 ou supérieur
    - Un terminal ou IDE pour exécuter le programme

## Instruction

### Démarrer le jeu

    1. Télécharger le code source, disponible à l'adresse git suivante : https://github.com/BerArth/Projet_POO.git
    2. Compilez et exécutez le jeu en lançant la classe principale (main.java)
> Le jeu commencera automatiquement et vous serez accueilli par un message de bienvenue.

### Commandes disponibles

> Voici une liste des commandes que vous pouvez utiliser pour interagir avec le jeu :

1. HELP
    - Affiche la liste des commandes disponibles et fournit des informations sur le jeu.

2. LOOK
    - Affiche une description détaillée de la pièce actuelle, y compris les objets présents, **les personnages ?** et les sorties disponibles ou les particularité d'une pièce.

3. LOOK [objet]
    - Si vous voulez examiner un objet spécifique dans la pièce.
        - Tapez LOOK [nom de l'objet], vous verrez alors une description détaillée de cet objet.

4. SPEAK
    - Vous permet de parler aux personnages présents dans la pièce.

5. TAKE [objet]
    - Permet de ramasser un objet dans la pièce et de l'ajouter à votre inventaire.
        - Tapez TAKE [nom de l'objet] pour ramasser un objet spécifique.

6. INVENTORY
    - Affiche tous les objets que vous avez dans votre inventaire ~~à condition que vous ayez un sac pour transporter ces objets~~.

7. GO [direction]
    - Permet de se déplacer vers une nouvelle pièce dans la direction spécifiée.
        - Tapez Go [nom de la sortie] pour rejoindre cette sortie.
    - Si une sortie est bloquée, vous en serez informé.

8. UNLOCK [direction]
    - Déverrouille une sortie dans la direction spécifiée. Cette commande est utile pour ouvrir les portes nécessitant une clé ou un code.

9. OPEN [direction]
    - Ouvre une porte ou une sortie dans la direction spécifiée, si celle si n'est pas vérrouillé.

10. QUIT
    - Pour quitter le jeu à tout moment.

11. autre : Certaines interactions dans le jeu demandent une réponse simple sous forme de "yes" ou "no". Par exemple, lorsque vous êtes invité à confirmer une action ou une décision, vous pouvez répondre en tapant :
    - yes pour accepter ou continuer l'action.
    - no pour refuser ou annuler l'action.

## Exemple de session

    - Voici un exemple de session de jeu :

```
Welcome in [nom du jeux] !
Controls :
    -GO [Name of exit]
    -UNLOCK [Name of exit]
    -OPEN [Name of exit]
    -HELP
    -QUIT
    -INVENTORY
    -LOOK


> LOOK

Item in this room : 
    Bag
Available exits :
    - Square west

> TAKE Bag
Great ! Now you have a bag!

> GO Square west
Square west

...
```

### Combats

>Si vous entrez dans une pièce où un Boss se trouve, vous devrez engager un combat. Le jeu vous indiquera la santé de l'ennemi et celle du héros, tour à tour.

## Entités Principales

### Personnages

    - Héros : Le joueur incarne ce personnage qui explore le monde, collecte des objets et combat des ennemis.
    - Aidant : Ce type de personnage peuvent donner des indices pour avancer dans le jeu.
    - Boss : Un ennemi puissant que le héros doit vaincre pour progresser.

### Pièces

    - Pièces : Chaque pièce peut contenir des objets, des personnages et des sorties.

### Objets

    -

## Remarques

    - Le jeu repose sur la logique des commandes textuelles. Il est important d'écrire les commandes correctement (en tenant compte de la casse ou de l'espace).

## Code Source
>
> Disponible à l'adresse git suivante : https://github.com/BerArth/Projet_POO.git