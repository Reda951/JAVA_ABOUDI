# Mission 0 : Déploiement sur un serveur distant avec AlwaysData

Reda aboudi - Esiee-it - (BTS SIO SLAM) - 18/04/2024




## Etape 0 : Créer un espace sur Alwaysdata
- Quels services sont offerts par Alwaysdata ?
  
Always Data  propose des services d’hébergement web pour vos créations de sites et applications.
-   Ils gèrent également des bases de données, vous permettant de stocker et organiser vos informations.
-   Vous pouvez développer vos projets dans un environnement sécurisé avec des langages de programmation  variés.
-   La  sécurité et les sauvegardes sont assurées pour protéger vos données.

En gros, Always Data est là pour faciliter l’hébergement et le développement de nos futur projets en ligne !

- Quels services seront nécessaires pour déployer un site web (HTML, CSS, JS et PHP) ?

Pour mettre en ligne un site web utilisant HTML, CSS, JavaScript et PHP sur Always Data, voici ce dont vous aurez besoin :

- Un hébergement Web ( où stockez ces fichiers html,css...)
- Un Serveur Web ( qui exécute nos fichiers html,css...)
- Une Base de Données ( si utilisation de php dans votre projet )
- Un Éditeur de Texte ( app tels que notpad++ ou sites tel que stackedit.io)
- Un Navigateur Web ( google, safari...)

- Quel est le nom de domaine choisi pour le déploiement de votre site ?

Mon nom de domaine est : http://aboudi.alwaysdata.net

# Etape 1 : Activer SSH

- Expliquer l'intérêt du protocole SSH. Sur quel port est-il actif par défaut ?

Le protocole SSH (Secure Shell) est utilisé pour sécuriser les communications réseau. En d’autres termes, il permet de créer une  connexion sécurisée entre deux ordinateurs. Grâce à cette connexion, les données échangées sont cryptées, ce qui les rend inaccessibles aux personnes non autorisées.

L’un des  grands avantages de SSH réside dans sa capacité à  protéger les communications. Il assure la sécurité de l’authentification (c’est-à-dire vérifier que l’utilisateur est bien autorisé) et le transfert sécurisé des données. C’est pourquoi SSH est idéal pour accéder à distance aux serveurs de manière sûre et fiable.

Le protocole SSH est sur le port 22 par défaut.

- Quel autre protocole semble avoir les mêmes fonctionnalités ? Que fait SSH qui n'est pas possible avec le 2e ?

Telnet représente un autre protocole qui partage certaines similitudes avec SSH. Cependant, sa principale faiblesse réside dans sa méthode de transmission des données en texte brut, ce qui les rend vulnérables aux interceptions. En revanche, SSH se distingue par son niveau de sécurité accru, obtenu grâce au chiffrement des données durant la communication. Cette caractéristique fondamentale assure la confidentialité et l'intégrité des informations échangées, ce qui en fait un choix préféré pour les communications à distance sécurisées.

-- Activer un accès au serveur via ce protocole. Quelles étapes sont nécessaires ?
  
Pour activer l’accès SSH sur alwaysdata, suivez ces étapes :
- Connectez-vous à votre compte.
- Modifiez votre utilisateur et vérifiez la connexion par mot de passe.
- Vous pouvez ensuite configurer une connexion avec des clés SSH et désactiver la connexion par mot de passe.


-- Se connecter à votre espace dédié sur le serveur via ce protocole. Quelle est la ligne de commande nécessaire pour y arriver ?

Voici la ligne de code que je dois écrire dans mon terminal : ssh aboudireda@ssh-aboudireda.alwaysdata.net


-- Dans quel repertoire faut-il déposer vos fichiers du site si vous voulez le voir en ligne ? (chemin complet sur le serveur)

Pour mon site, je dois placer les fichiers dans le dossier public de mon espace sur le serveur. En général, ce dossier se trouve à /home/aboudireda/http://aboudireda.alwaysdata.net

# Etape 2 : Copier notre contenu sur Alwaysdata


-- Quel est le chemin local absolu pour accéder à votre site ?

Le chemin local absolu dépend de l’endroit où j'ai sauvegardé mes fichiers sur mon ordinateur. Par exemple, si mes fichiers sont dans le dossier /home/aboudireda/http://aboudireda.alwaysdata.net alors c’est mon chemin local absolu.

-- Quel est le chemin absolu du repertoire dédié sur le serveur Alwaysdata ?

Le répertoire dédié sur le serveur Alwaysdata est : /home/aboudireda/http://aboudireda.alwaysdata.net

-- Les commandes scp et rsync peuvent être d'une grande aide à cette étape. Pourquoi ?

Ces deux commandes me permettent de copier des fichiers entre mon ordinateur local.
  
Le serveur distant. scp (Secure Copy) copie les fichiers de manière sécurisée via SSH. rsync il est plus puissant et optimisé pour la synchronisation de fichiers. Il utilise un algorithme de transfert delta pour minimiser la quantité de données transférées.

-- Quelle est la différence entre les deux commandes ?

Le scp effectue une copie linéaire simple, tandis que rsync utilise un algorithme de transfert delta pour accélérer les opérations. rsync prend en charge de nombreuses options pour personnaliser son comportement, tandis que scp a des options limitées.

-- Quelle est la commande complète pour ajouter les fichiers sauvegardés en local sur le serveur dédié ?
  
J'utilise rsync pour une synchronisation efficace : $ rsync -avz -e ssh /chemin/local/monsite/aboudireda@ssh-aboudireda.alwaysdata.net:/home/aboudireda/http://aboudireda.alwaysdata.net

-- Comment vérifier que l'ajout a bien été effectué ? Détailler la procédure et les résultats attendus.

Après avoir exécuté la commande, je vérifie que les fichiers ont été copiés en me connectant au serveur Alwaysdata via SSH. J'accède au répertoire /home/aboudireda/www/ et je vérifie la présence des fichiers de mon site.

-- Quelle URL permet de voir votre site en ligne ?

Pour voir mon site en ligne, j'utilise l’URL associée à mon compte Alwaysdata. Cela dépend de ma configuration, mais généralement, c’est : http://aboudireda.alwaysdata.net.

# Etape 3 - Gestion de paires de clés privée et publique : 

-- Notez les avantages à se connecter avec une paire de clé privée et publique vs se connecter avec mot de passe

L’authentification par clé privée est un processus sécurisé permettant d’accéder à un serveur distant. Contrairement à l’utilisation classique d’un nom d’utilisateur et d’un mot de passe, cette méthode repose sur deux éléments :

A.  Clé privée :
    
    -   Il s’agit d’un fichier confidentiel stocké sur l’ordinateur de la personne.
    -   La clé privée est générée localement et ne doit jamais au grand jamais être partagée.
B.  Passphrase:
    
    -   Le passphrase est un mot de passe supplémentaire nécessaire pour déverrouiller la clé privée.
    -   Il renforce la sécurité en ajoutant de la protection.

-- Noter les étapes nécessaires pour y parvenir ?

Lorsqu’un utilisateur tente de se connecter au serveur, il envoie sa  clé publique. Le serveur vérifie alors si cette clé publique correspond à la clé privée associée à l’utilisateur. Si c’est le cas, l’accès est autorisé.

L’authentification par clé privée offre une sécurité accrue :

-   Elle nécessite deux éléments pour se connecter (clé privée et passphrase).
-   Les personnes non autorisées doivent posséder à la fois la clé privée et le passphrase pour accéder au serveur.

En résumé, l’authentification par clé privée renforce la sécurité des connexions au serveur en ajoutant une de la protection supplémentaire.

-- Notez les étapes pour en tester le bon fonctionnement :

Vérification des Clés :

- Génération des Clés : Assurez-vous que les clés SSH (publique et privée) sont correctement générées. Utilisez une commande telle que ssh-keygen pour créer ces clés.

- Emplacement des Clés : Il faut vérifier que la clé publique (id_rsa.pub) est bien placée dans le fichier ~/.ssh/authorized_keys sur le serveur, et que la clé privée (id_rsa) est stockée sur le client dans le répertoire ~/.ssh/.

Utilisation de l'Agent SSH :

- Ajout de la Clé à l'Agent SSH : Il faut utiliser la commande ssh-add ~/.ssh/id_rsa pour ajouter la clé privée à l'agent SSH (ssh-agent).
- Vérification de l'Agent SSH : Confirmez que, à chaque connexions suivantes, la passphrase n'est plus demandée grâce à l'agent SSH.
