Devoir OWASP

Reda Aboudi
15 mai 2024


# A01:2021-Contrôles d'accès défaillants :

# Définition :

Cette faille survient lorsque les restrictions sur les actions des utilisateurs authentifiés ne sont pas correctement mises en place. Cela peut permettre aux attaquants d'accéder à des données ou des fonctionnalités sans les autorisations nécessaires.

# Recommandations OWASP :

Implémenter une politique de contrôle d'accès basée sur le principe du moindre privilège.
S'assurer que les contrôles d'accès sont appliqués à tous les niveaux de l'application, y compris les API.
Maintenir des journaux d'accès pour des audits réguliers.

# Pour les développeurs :

Intégrer des contrôles d'accès robustes dès la conception de l'application.
Tester régulièrement ces contrôles pour s'assurer qu'ils fonctionnent correctement et qu'ils couvrent toutes les parties de l'application.



# A02:2021-Défaillances cryptographiques 

# Définition :

La vulnérabilité A02:2021-Défaillances cryptographiques a maintenant surpassé A3:2017-Exposition de données sensibles, se plaçant en deuxième position. Cette faille met en lumière les problèmes liés à la cryptographie, qui peuvent conduire à l'exposition de données sensibles ou à la compromission d'un système. Auparavant, l'exposition de données était souvent traitée comme un effet secondaire général plutôt qu'une cause directe.

# Recommandations de l'OWASP :

Utiliser des algorithmes cryptographiques robustes et approuvés par la communauté de sécurité.
Mettre en œuvre une gestion sécurisée des clés cryptographiques, incluant leur stockage et leur rotation régulière.
Protéger la confidentialité et l'intégrité des données, tant en transit qu'au repos, en employant des protocoles cryptographiques adéquats.
Effectuer des tests réguliers sur les implémentations cryptographiques pour détecter et rectifier les vulnérabilités.

# Pour les développeurs :

Intégrer des mesures de sécurité cryptographique dès la phase de conception de l'application.
Rester à jour avec les dernières évolutions et recommandations en cryptographie.
S'assurer de l'exactitude des implémentations cryptographiques et réaliser des tests de sécurité fréquents pour confirmer leur robustesse.


# A03:2021-Injection

# Définition :

La vulnérabilité des injections demeure prévalente, touchant 94% des applications testées. Cette catégorie inclut maintenant le Cross-Site Scripting (XSS) et présente une incidence maximale de 19%, avec une moyenne de 3,37%. Les 33 CWE (Common Weakness Enumeration) liées à cette catégorie enregistrent le deuxième plus grand nombre d'occurrences, soulignant ainsi l'ampleur de cette problématique.

# Recommandations de l'OWASP :

Favoriser l'utilisation de requêtes préparées et de procédures stockées pour les interactions avec les bases de données, afin de prévenir les injections SQL.
Valider et assainir systématiquement toutes les entrées utilisateurs pour bloquer l'insertion de code malveillant.
Établir des politiques de sécurité rigoureuses pour les serveurs web et les bases de données.
Employer des outils de détection automatique pour identifier les vulnérabilités d'injection dans les applications.

# Pour les développeurs :

S'assurer de la validation et de l'échappement appropriés de toutes les entrées utilisateurs pour contrer les risques d'injection.
Utiliser des frameworks ORM (Object-Relational Mapping) qui facilitent une interaction sécurisée avec les bases de données.
Réaliser des tests de sécurité de manière régulière afin de découvrir et corriger rapidement les vulnérabilités d'injection.
Participer continuellement à des formations sur les pratiques de sécurité pour rester au fait des nouvelles menaces et des stratégies de mitigation.

# Conclusion :

Il est crucial pour moi, en tant que futur développeur, de comprendre l'importance de mettre en place des mesures de sécurité efficaces pour protéger les applications contre les injections. Ces attaques peuvent gravement compromettre les données et l'intégrité des systèmes. Adopter une approche proactive en matière de sécurité, notamment en utilisant des pratiques de codage sécurisé et en validant systématiquement les entrées des utilisateurs, est essentiel pour défendre mes applications contre de telles vulnérabilités.

# A04:2021-Conception non sécurisée :

# Définition :

La vulnérabilité A04:2021-Conception non sécurisée est un terme qui souligne les défauts inhérents de conception dans les applications. Cette faille se manifeste quand les mécanismes de sécurité essentiels, qui auraient dû être envisagés pour se défendre contre des attaques spécifiques, sont absents dès le début. Ce type de vulnérabilité est insensible à une mise en œuvre parfaite du code; en absence des contrôles de sécurité nécessaires initialement, les risques demeurent.

# Recommandations de l'OWASP :

Utiliser activement des techniques de modélisation des menaces pour identifier et évaluer les risques dès la phase de conception.
Adopter des principes et des modèles de conception sécurisée pour garantir que la sécurité est une priorité dès le premier jour.
Mettre en place des architectures de référence qui intègrent des contrôles de sécurité éprouvés et fiables.
Organiser des revues de conception de manière régulière afin de vérifier le respect des principes de sécurité tout au long du cycle de développement.

# Pour les développeurs :

Intégrer des pratiques de conception sécurisée dès le début de chaque projet.
Collaborer étroitement avec des experts en sécurité pour évaluer les conceptions et les architectures proposées.
Participer à des formations dédiées aux modèles de menaces et aux principes de conception sécurisée.
Assurer que les évaluations de sécurité sont une composante systématique de chaque étape du développement, afin de détecter et rectifier les défauts de conception avant qu'ils ne se transforment en vulnérabilités exploitables.

# Conclusion :

En tant que développeur, je reconnais l'importance de l'intégration de la sécurité dès la phase de conception. Cela me permet non seulement de réduire les risques de sécurité mais aussi d'éviter les coûts élevés et les efforts substantiels nécessaires pour corriger des failles de sécurité après le déploiement des applications. Intégrer des mesures de sécurité préventives dès le début aide à construire des systèmes plus robustes et fiables.

# A05:2021-Mauvaise configuration de sécurité :

# Définition :

La vulnérabilité A05:2021-Mauvaise configuration de sécurité, qui a monté d'une place dans le classement, souligne les risques liés aux configurations de sécurité inappropriées ou incorrectes. Cette catégorie, englobant maintenant l'ancienne A4:2017-XML Entités externes (XXE), affecte 90% des applications testées, avec une incidence moyenne de 4,5% et plus de 208 000 occurrences des CWEs associées. L'augmentation de la configurabilité des logiciels rend cette catégorie de plus en plus critique.

# Recommandations de l'OWASP :

Adopter des configurations de sécurité sécurisées par défaut et les personnaliser en fonction des besoins spécifiques de chaque application.
Maintenir une gestion rigoureuse des configurations pour éviter les paramètres incorrects ou exposant à des risques.
Mettre à jour et corriger régulièrement les systèmes, bibliothèques et frameworks pour éviter les exploitations de vulnérabilités connues.
Désactiver les fonctionnalités et les services non nécessaires pour minimiser la surface d'attaque.
Utiliser des outils de gestion de configuration pour automatiser et auditer les paramètres de sécurité de manière efficace.

# Pour les développeurs :

Veiller à ce que les configurations de sécurité soient adéquatement établies dès le début du projet.
Effectuer des audits de configuration réguliers afin de détecter et rectifier les paramètres vulnérables.
Se former continuellement sur les meilleures pratiques de configuration de sécurité pour rester à jour.
Rester informé des dernières vulnérabilités et des correctifs disponibles pour les technologies employées.
Automatiser autant que possible la gestion des configurations de sécurité à l'aide d'outils adaptés pour assurer une conformité constante et réduire les risques.

# Conclusion : 

Comprendre l'importance d'une configuration de sécurité bien conçue et maintenue est crucial pour moi en tant que futur développeur. Cette approche ne se limite pas seulement à prévenir les attaques externes, mais joue également un rôle essentiel dans la limitation des dommages potentiels lors d'incidents de sécurité. Adopter et appliquer des configurations sécurisées est fondamental pour assurer la protection et la résilience des applications que je développe.

# A06:2021-Composants vulnérables et obsolètes :

# Définition :

La vulnérabilité A06:2021, autrefois connue sous le nom d'Utilisation de Composants avec des Vulnérabilités Connues, souligne le risque accru posé par l'utilisation de composants logiciels qui ne sont plus à jour ou qui contiennent des failles de sécurité connues. Cette catégorie, désormais en deuxième position, ne se lie pas directement à des CVE (Common Vulnerabilities and Exposures) spécifiques, ce qui rend son évaluation et sa mesure en termes de risques particulièrement complexe. Par défaut, les coefficients d'impact et de poids de cette catégorie ont été établis à 5.0.

# Recommandations de l'OWASP :

Assurer une veille technologique continue sur les composants utilisés pour détecter rapidement les vulnérabilités connues.
Privilégier l'utilisation de versions à jour et sécurisées des bibliothèques et frameworks.
Instaurer des processus efficaces de gestion des dépendances pour surveiller et mettre à jour régulièrement les composants.
Scanner systématiquement les applications afin de repérer les composants vulnérables ou obsolètes.
Éviter l'utilisation de composants qui ne sont plus maintenus ou qui ont été abandonnés par leurs développeurs.

# Pour les développeurs :

Vérifier régulièrement les mises à jour et les correctifs pour les bibliothèques et frameworks utilisés.
Employer des outils de gestion des dépendances pour automatiser le suivi et la mise à jour des composants.
Effectuer des tests de sécurité réguliers pour détecter les vulnérabilités associées aux composants tiers.
Documenter et suivre de près tous les composants utilisés dans les projets pour simplifier leur gestion et mise à jour.
Participer activement à des formations et se tenir au courant des meilleures pratiques de gestion des composants.

# Conclusion :

Il est essentiel pour moi, en tant que futur développeur, de reconnaître l'importance de la gestion proactive des composants logiciels. Cela inclut non seulement la mise à jour régulière des bibliothèques et frameworks pour prévenir les risques de sécurité, mais aussi la surveillance continue de l'état des composants pour garantir la robustesse et la sécurité des applications que je développe. En adoptant cette approche, je peux assurer une défense efficace contre les vulnérabilités potentielles et contribuer activement à la fiabilité des solutions technologiques.

# A07:2021-Identification et authentification de mauvaise qualité : 

# Définition :

La vulnérabilité A07:2021-Identification et authentification de mauvaise qualité, auparavant appelée Authentification de mauvaise qualité, est maintenant au septième rang. Elle inclut désormais des CWE liées aux échecs d'identification. Bien que cette catégorie ait perdu la deuxième place, elle reste un problème majeur dans le Top 10. L'adoption croissante de frameworks d'authentification standardisés semble aider à atténuer ce risque.

# Recommandations OWASP :

Utiliser des frameworks et des bibliothèques d'authentification éprouvés pour implémenter des mécanismes sécurisés.
Mettre en place une authentification multifactorielle (MFA) pour renforcer la sécurité des comptes utilisateurs.
Protéger les informations d'identification en utilisant des techniques de hachage sécurisé et de chiffrement.
Implémenter des politiques de verrouillage de compte pour prévenir les attaques par force brute.
Valider et gérer correctement les sessions utilisateurs pour éviter les détournements de session.

# Pour les développeurs :

Adopter des pratiques de codage sécurisées pour implémenter des mécanismes d'identification et d'authentification robustes dès la conception.
Effectuer des audits de sécurité réguliers pour vérifier l'efficacité des mécanismes d'authentification et d'identification.
Utiliser des outils et des services de gestion des identités et des accès (IAM) pour centraliser et sécuriser les processus d'authentification.
Se tenir informé des nouvelles vulnérabilités et des meilleures pratiques en matière d'authentification et d'identification.
Former les équipes de développement sur l'importance de la sécurisation des mécanismes d'authentification et des informations d'identification.

# Conclusion : 

En tant que développeur, il est crucial pour moi de comprendre que des mécanismes d'identification et d'authentification solides sont essentiels pour protéger les utilisateurs et les systèmes contre les accès non autorisés et les attaques. Adopter et implémenter des stratégies de sécurité robustes pour l'authentification aide à sécuriser les données sensibles et à maintenir l'intégrité des systèmes que je développe, assurant ainsi une protection efficace face aux menaces émergentes.

# A08:2021-Manque d'intégrité des données et du logiciel :

# Définition :

La vulnérabilité A08:2021-Manque d'intégrité des données et du logiciel est une catégorie récente qui soulève des préoccupations concernant les suppositions incorrectes faites sur l'intégrité des mises à jour logicielles, des données critiques, et des pipelines CI/CD (Continuous Integration/Continuous Deployment) sans les vérifications nécessaires. Elle regroupe les risques associés à dix CWE (Common Weakness Enumeration) et est notable pour ses impacts élevés, tels que reportés dans les données de Common Vulnerability and Exposures (CVE) et Common Vulnerability Scoring System (CVSS). Cette catégorie inclut aussi les problématiques autrefois couvertes sous A8:2017-Désérialisation non sécurisée.

# Recommandations de l'OWASP :

Instaurer des protocoles stricts de validation et de vérification pour maintenir l'intégrité des mises à jour logicielles et des données critiques.
Utiliser des signatures numériques et des checksums pour garantir l'intégrité des fichiers téléchargés et des mises à jour.
Intégrer des contrôles de sécurité robustes dans les pipelines CI/CD afin de s'assurer de l'intégrité et de l'authenticité des composants avant leur déploiement.
Conduire des audits réguliers des processus de mise à jour et de déploiement pour identifier et rectifier les vulnérabilités.
Gérer avec rigueur les clés et certificats pour renforcer la confiance dans les validations d'intégrité.

# Pour les développeurs :

Incorporer des pratiques de vérification d'intégrité dès la conception des systèmes et des processus de mise à jour.
Employer des outils et des services spécialisés pour suivre l'intégrité des composants logiciels tiers.
Se former aux meilleures pratiques en matière de gestion de l'intégrité des données et des logiciels.
Collaborer étroitement avec les équipes de sécurité pour implémenter des vérifications et validations efficaces.
Effectuer des tests périodiques pour assurer le bon fonctionnement des mécanismes de vérification de l'intégrité et leur couverture complète des systèmes.

# Conclusion : 

Comprendre et appliquer ces recommandations est crucial pour moi en tant que futur développeur. Cela me permet de prévenir efficacement les attaques et de maintenir la confiance dans les systèmes que je déploie. Assurer que les mises à jour et les données que j'utilise sont fiables et sécurisées est essentiel pour protéger l'intégrité et la confidentialité des environnements numériques que je développe. En intégrant ces pratiques de sécurité dès la conception et tout au long du cycle de développement, je contribue activement à la création de solutions technologiques robustes et dignes de confiance.

# A09:2021-Carence des systèmes de contrôle et de journalisation : 

# Définition :

La vulnérabilité A09:2021-Carence des systèmes de contrôle et de journalisation, précédemment connue sous le nom de A10:2017-Supervision et Journalisation Insuffisantes, est ajoutée à partir de l'enquête auprès de l'industrie où elle se classe 3ème, alors qu'elle était précédemment à la dixième place. Cette catégorie a été élargie pour inclure davantage de types de défaillances. Bien qu'elle soit difficile à tester et sous-représentée dans les données CVE/CVSS, les incidents dans cette catégorie peuvent directement affecter la visibilité, la levée d'alertes et l'analyse forensique.

# Recommandations OWASP :

Mettre en place des systèmes de journalisation complets et fiables pour toutes les activités critiques et sensibles.
Configurer des alertes en temps réel pour détecter les comportements anormaux et les incidents de sécurité.
Assurer une surveillance continue des journaux et des systèmes de contrôle pour identifier et répondre rapidement aux menaces.
Utiliser des outils de gestion des journaux et des systèmes de surveillance pour centraliser et analyser les données de journalisation.
Réaliser des audits réguliers des journaux pour vérifier leur intégrité et leur efficacité dans la détection des incidents.

# Pour les développeurs :

Intégrer des mécanismes de journalisation et de surveillance dès la conception des applications et des systèmes.
Veiller à ce que les journaux incluent des informations suffisantes pour permettre une analyse forensique complète en cas d'incident.
Collaborer avec les équipes de sécurité pour définir des politiques de journalisation et de surveillance adaptées aux besoins de l'organisation.
Tester régulièrement les systèmes de journalisation et de surveillance pour s'assurer qu'ils fonctionnent correctement et qu'ils couvrent tous les aspects critiques.

# Conclusion : 

Comme développeur, je dois me former aux meilleures pratiques en journalisation et surveillance pour toujours maîtriser les outils et techniques les plus récents et efficaces. Cela me permet de renforcer activement la sécurité des applications et des systèmes. Appréhender l'importance des systèmes de contrôle et de journalisation est crucial, non seulement pour assurer une sécurité optimale, mais aussi pour faciliter la détection rapide, la réponse et l'analyse des incidents de sécurité. Grâce à ces compétences, je peux mieux prévenir les risques et gérer proactivement les problèmes de sécurité, renforçant ainsi la confiance dans les solutions technologiques que je développe.

# A10:2021-Falsification de requête côté serveur :

# Définition :

La vulnérabilité A10:2021-Falsification de requête côté serveur (SSRF) a été placée en première position lors de l'enquête récente du Top 10 de l'OWASP. Cette catégorie montre une incidence faible mais attire l'attention avec un taux de couverture des tests et des notes sur le potentiel d'exploitabilité et l'impact supérieurs à la moyenne. Cela indique l'importance que la communauté de la sécurité accorde à ce type de vulnérabilité, soulignant les risques potentiels qu'elle pose même si les données actuelles ne montrent pas encore clairement son impact.

# Recommandations de l'OWASP :

Valider et filtrer toutes les entrées utilisateur avant de les utiliser dans des requêtes côté serveur.
Mettre en place des listes blanches d'URLs pour limiter les destinations vers lesquelles les requêtes peuvent être dirigées.
Implémenter des contrôles d'accès stricts pour bloquer les requêtes non autorisées ou malveillantes.
Réduire les privilèges des services capables d'initier des requêtes côté serveur afin de diminuer l'impact en cas d'exploitation.
Surveiller et consigner les requêtes côté serveur pour identifier les comportements suspects et les tentatives d'exploitation.

# Pour les développeurs :

Intégrer dès la conception des pratiques rigoureuses de validation et de filtrage des entrées pour les fonctionnalités impliquant des requêtes côté serveur.

Utiliser des outils de sécurité dédiés pour tester et détecter les vulnérabilités SSRF dans les applications.
Collaborer étroitement avec les équipes de sécurité pour établir et mettre en œuvre des politiques de contrôle d'accès efficaces.
Se former continuellement sur les meilleures pratiques de prévention des attaques SSRF et rester informé des nouvelles méthodes d'exploitation et des mesures de protection.
Effectuer régulièrement des revues de code et des tests de sécurité pour s'assurer de l'efficacité et de la mise à jour des protections contre les SSRF.

# Conclusion :

Il est essentiel pour moi, en tant que futur développeur, de comprendre et de mettre en œuvre des stratégies de prévention contre les attaques de type SSRF (Server Side Request Forgery). Cette démarche est cruciale pour protéger les applications des accès non autorisés et de la compromission des systèmes internes. En faisant cela, je contribue activement à la sécurité globale de notre environnement numérique, assurant ainsi la protection des données et des infrastructures critiques.



# Noter les mots clés incompréhensibles qu'il faudrait définir : 



# A01:2021-Contrôles d'accès défaillants :

API

# A02:2021-Défaillances cryptographiques :

Algorithmes cryptographiques
Clés cryptographiques
Protocole cryptographique

# A03:2021-Injection :

Injection SQL
Cross-Site Scripting (XSS)
ORM (Object-Relational Mapping)

# A04:2021-Conception non sécurisée :

Architecture de référence
Revues de conception

# A05:2021-Mauvaise configuration de sécurité :

XML Entités externes (XXE)

# A06:2021-Composants vulnérables et obsolètes :

Common Vulnerabilities and Exposures (CVE)
Gestion des dépendances

# A07:2021-Identification et authentification de mauvaise qualité :

Frameworks d'authentification
Authentification multifactorielle (MFA)
IAM (Identity and Access Management)

# A08:2021-Manque d'intégrité des données et du logiciel :

Pipelines CI/CD
Signatures numériques
Checksums

# A09:2021-Carence des systèmes de contrôle et de journalisation :

Journalisation
Analyse forensique

# A10:2021-Falsification de requête côté serveur : 

Falsification de requête côté serveur (SSRF)
Listes blanches d'URL