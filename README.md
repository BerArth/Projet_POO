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

1. **HELP**
    - Affiche la liste des commandes disponibles et fournit des informations sur le jeu.

2. **LOOK**
    - Affiche une description détaillée de la pièce actuelle, y compris les objets présents, les personnages et les sorties disponibles ou les particularités d'une pièce.

3. **LOOK [objet]**
    - Si vous voulez examiner un objet spécifique dans la pièce.
        - Tapez LOOK [nom de l'objet], vous verrez alors une description détaillée de cet objet.

4. **SPEAK**
    - Vous permet de parler aux personnages présents dans la pièce.

5. **TAKE [objet]**
    - Permet de ramasser un objet dans la pièce et de l'ajouter à votre inventaire.
        - Tapez TAKE [nom de l'objet] pour ramasser un objet spécifique.

6. **INVENTORY**
    - Affiche tous les objets que vous avez dans votre inventaire.

7. **GO [direction]**
    - Permet de se déplacer vers une nouvelle pièce dans la direction spécifiée.
        - Tapez GO [nom de la sortie] pour rejoindre cette sortie.
    - Si une sortie est bloquée, vous en serez informé.

8. **UNLOCK [direction]**
    - Déverrouille une sortie dans la direction spécifiée. Cette commande est utile pour ouvrir les portes nécessitant une clé ou un code.

9. **OPEN [direction]**
    - Ouvre une porte ou une sortie dans la direction spécifiée, si celle-ci n'est pas verrouillée.

10. **EAT**
    - Permet de consommer de la nourriture pour restaurer de la santé.

11. **READ**
    - Permet de lire un livre ou un document dans votre inventaire.

12. **STATE**
    - Affiche l'état actuel de la santé de votre personnage.
    
13. **TIME**
    - Affiche le temps restant pour les parties avec un compte à rebours.

14. **QUIT**
    - Pour quitter le jeu à tout moment.

15. Autres : Certaines interactions dans le jeu demandent une réponse simple sous forme de "yes" ou "no". Par exemple, lorsque vous êtes invité à confirmer une action ou une décision, vous pouvez répondre en tapant :
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
 -SPEAK 
 -READ 
 -TAKE 
 -EAT 
 -STATE
You are in the tavern. Apart from a half-unconscious drunk man there is no one there.


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

### Compte à rebours

>Si vous avez accepté de jouer avec un compte à rebours alors, vous aurez 20 minutes pour terminer la partie.

### Combats

>Si vous entrez dans une pièce où un Boss se trouve, vous devrez engager un combat. Le jeu vous indiquera la santé de l'ennemi et celle de votre personnage, tour à tour.

## Entités Principales

### Personnages

    - Héro : Le joueur incarne ce personnage qui explore le monde, collecte des objets et combat des ennemis.
    - Aidant : Ce type de personnage peuvent donner des indices pour avancer dans le jeu.
    - Boss : Un ennemi puissant que le héros doit vaincre pour progresser.

### Pièces & Type portes/sorties

    - Pièces : Chaque pièce peut contenir des objets, des personnages et des sorties.
    - Porte/Sortie : Une sortie simple reliant deux pièces.
    - Sortie sans issue : Une sortie qui mène à une impasse, ne permettant pas d'avancer plus loin.
    - Porte avec clé : Une sortie verrouillée qui nécessite une clé spécifique pour être déverrouillée.
    - Portes avec verrou automatique : Une sortie qui se verrouille automatiquement après le passage du héros, nécessitant une clé ou un code pour être déverrouillée à nouveau.
    - Portes avec code secret : Une sortie qui est verrouillée et nécessite un code secret pour être ouverte.


### Objets

    - Bag : permet de transporter d'autres objets.
    - Armes : permet d'être plus efficace dans un combat.
    - Net : permet de capturer des lucioles.
    - Flacon : permet de transporter des lucioles.
    - Luciole : permet de produit de la lumière.
    - Or : permet d'être échangé contre d'autres objets.
    - Nourriture : permet de restaurer des points de vie.
    - Livre/Pancarte : permet d'obtenir des indices.
    - Morceau de clé : permet, une fois combiner, de créer une clé.
    - Clé : permet de déverrouiller une porte.

## Remarques

    - Le jeu repose sur la logique des commandes textuelles. Il est important d'écrire les commandes correctement (en tenant compte de la casse ou de l'espace).

## Code Source
>
> Disponible à l'adresse git suivante : https://github.com/BerArth/Projet_POO.git