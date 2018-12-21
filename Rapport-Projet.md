QUIRYNEN Gilles
VASE Rémy
CONDE Ibrahima

### 2TL1		Ephec


# Rapport du projet Tricount pour le cours de Développement informatique avancé : applications


### Lien github :
-Repository: https://github.com/Ibra-Yves/Projet_Tricount_Java

-Wiki :	 https://github.com/Ibra-Yves/Projet_Tricount_Java/wiki


## Cahier des charges
### But du projet :
Le but de ce projet est de développer un programme Java Gui qui aura les mêmes fonctionnalités que l’application Tricount déjà existante. Cette application fort utile sert à répartir les dépenses d’un groupe que ce soit une colocation, un voyage entre amis ou autre. L’objectif étant qu’elle soit parfaitement modulable au niveau de la composition du groupe et de l’ajout des dépenses.

### Fonctionnement de l'application :
L’utilisateur devra créer son groupe de dépenses en entrant leurs données qui s’inscriront dans une base de données locale. A chaque dépense il lui sera demandé le montant de celle-ci, l’auteur de cette dépense et qui en profitent. Le programme effectuera alors les calculs pour répartir les coûts de manière équitable entre tous les membres du groupe de départ. Cette répartition sera visible par chaque utilisateur dans leur balance. Si leur balance à la fin de la période donnée est positive, d’autres membres du groupe lui devront de l’argent alors que si elle est négative cet utilisateur devra rembourser une certaine somme à un ou plusieurs des membres du groupe. Toutes les dépenses seront accessibles à tout moment par chaque utilisateur. Pour aller un peu plus loin que l’application originale nous voulions faire en sorte que chaque personne qui utilise l’application aie la capacité de choisir le mode de paiement sur lequel il s’attend à être remboursé (Paypal , Compte bancaire , carte de crédit) Une autre idée était de laisser la personne choisir la monnaie dans laquelle il/elle voudrait être remboursé dans le cas possible d’un groupe international.


### Diagramme UML :






### Implémentation

-Base de donnée local
Nous avons choisi d’utiliser une base de données car nous étions familiers avec son utilisation et c’était également une bonne façon de mettre en place des notions vues aux cours l’année précédente.L’utilisation d’une base de données locale nous paraissant également très logique dans le cadre de notre projet pour stocker les différents types de données utilisés.
Une autre raison pour ce choix était l’intérêt des différents membres du groupe pour le monde des bases de données et l’envie d’en apprendre plus notamment grâce à la pratique qu’offrait ce projet.



### Les difficultés rencontrées :

Nous avons rencontrés des difficultés d’arrangements pour les séances de travail au même endroit, du coup nous avons décidé de communiquer via Discord et de se partager certaines tâches.
Une autre difficulté majeure était les échéances dans les autres cours ainsi que des projets en parallèle de celui-ci qui rendaientt l’organisation complexe
Certaines difficultées venaient du fait que deux d’entre nous avaient encore des cours de première avec des interrogations ou travaux réguliers ce qui n’améliorait pas notre de temps de travail disponible.
Lors de la mise en place JDBC dans un premier temps nous avons rencontrés des difficultés à communiquer avec la BDD. Nous avons résolus ce problème grâce à de la documentation sur Internet et un livre emprunté dédié à JDBC et le livre “Base de données de première année”.


### Pistes d’améliorations éventuelles: 


-Le rendre fonctionnel en réseau et pas seulement en local (utilisation de serveur). 
-Un design un peu plus soigné dans le but de rendre l’application plus attirante dans le cadre d’une sortie publique.
-Ajouter des boutons vers des liens de paiement comme pour Paypal ou bancontact.
-Un espace commentaire pour les dépenses. (Courses,activité,restos,..)
-Une fonctionnalité de back-up


### Conclusions individuelles :

### Rémy : 
J’ai trouvé ce travail assez compliqué, il fallait faire pas mal de recherche sur internet car il était demandé plus de choses que ce que l’on a vu au cours. Il y a eu quelques problèmes de cohésion entre les trois membres du groupes et des avis divergents quant à la résolution de certains problèmes, malgré le manque de temps suite à un autre projet dans un autre cours et des conflits horaires à cause de cours de première à rattraper, nous avons su nous organiser afin de toujours travailler ensemble sur discord.


### Ibrahima :
  Tout d’abord, je pense que la réalisation de ce projet est une bonne chose, car cela m’a permis d’acquérir de l’expérience. Je sais par exemple que le timing est un critère déterminant. Quand nous commençons notre projet plus tôt, nous avons plus de temps à consacrer. 

Ensuite, l’un des éléments positifs de ce projet  est surtout la cohésion du groupe. En effet, nous avons tous eu la même quantité de travail, personne n’a été mis en retrait. Certes il y a eu certains désaccords mais nous avons toujours eu des solutions pour remédier à cela.  

Pour finir, Je peux affirmer sans hésitation que ce projet m’a beaucoup apporté tant au niveau de langage de programmation utilisé mais aussi au niveau humain.


### Gilles :
 Ce projet m’a beaucoup apporté aussi bien dans mes connaissances théoriques et pratiques que dans l’organisation et le travail en équipe. Malgré la complexité au premier abord d’un travail à cette échelle qui était une première pour chacun des membres du groupe, je pense avoir beaucoup appris dans la décomposition d’une tâche complexe en plus petites tâches plus abordables.
L’utilisation de base de données allié à l'utilisation d’un nouveau langage s’est avéré un défi que je suis très satisfait d’avoir accompli.

J’ai également beaucoup apprécié travailler avec cette équipe principalement grâce à l’ambiance qui régnait et qui nous poussait à chacuns trouver des solutions aux problèmes qui ont jalonnés l'exécution de ce projet.


