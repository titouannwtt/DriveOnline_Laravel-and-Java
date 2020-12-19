## Projet Tutoré - Plateforme de partage pour l’IUT
*FA - IUT Informatique de Fontainebleau 2018/2019*


**NAVETEUR Lucas** - <a href="mailto:lucas.naveteur@etu.u-pec.fr">lucas.naveteur@etu.u-pec.fr</a><br/>
**SZATKOWSKI Théo** - <a href="mailto:theo.szatkowski@etu.upec.fr">theo.szatkowski@etu.u-pec.fr</a><br/>
**WATTELET Titouan** - <a href="mailto:titouan.wattelet@etu.u-pec.fr">titouan.wattelet@etu.u-pec.fr</a><br/>
**CASTRO Pierre** -    <a href="mailto:pierre.castro@etu.u-pec.fr">pierre.castro@etu.u-pec.fr</a><br/>

<hr /><!--- ================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================ -->

### SOMMAIRE:
<ul>
<li><strong>A. Cadre du projet</strong> <a href="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/wiki/Cahier+des+Charges/#a-cadre-du-projet">→</a></li>
<ul>
 <li>A.1 Planning</li>
 <li>A.2 Contraintes</li>
 <li>A.3 Raisons et intérêts de la plateforme</li>
</ul>
<li><strong>B. Structure de la Plateforme</strong> <a href="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/wiki/Cahier+des+Charges/#b-structure-de-la-plateforme">→</a> </li>

<ul>
 <li>B.1 Hébergement</li>
 <li>B.2 Base de données</li>
 <li>B.3 Sécurité</li>
  <ul>
    <li>Application WEB</li>
    <li>Daemon</li>
  </ul>
 <li>B.4 Espace de Stockage</li>
  <ul>
    <li>Permissions</li>
    <li>Limite taille</li>
  </ul>
 <li>B.5 Gestion des interactions</li>
  <ul>
    <li>Inscription/Connexion - Type de Compte</li>
    <li>Administrateur</li>
    <li>Type d’accès aux fichiers/dossiers</li>
  </ul>
</ul>
<li><strong>C. Applications</strong> <a href="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/wiki/Cahier+des+Charges#c-applications">→</a></li>
<ul>
 <li>C.1 Application WEB</li>
  <ul>
    <li>Fonctionnalités utilisateur</li>
    <li>Spécificités Développeur</li>
    <li>Accessibilité (navigateur web)</li>
  </ul>
 <li>C.2 Logiciel (Daemon)</li>
  <ul>
    <li>Fonctionnalités utilisateur</li>
    <li>Spécificités Développeur</li>
    <li>Accessibilité (Installation et lancement automatisé)</li>
  </ul>
 <li>C.3 Application Mobile</li>
   <ul>
    <li>Fonctionnalités utilisateur</li>
    <li>Spécificités Développeur</li>
    <li>Accessibilité (Android)</li>
  </ul>
</ul>
  <li><strong>D. Charte graphique</strong> <a href="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/wiki/Cahier+des+Charges/#d-charte-graphique">→</a> </li>
  <li><strong>E. Projet Similaire / Concurrent</strong> <a href="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/wiki/Cahier+des+Charges/#e-projets-similaires--concurrents">→</a> </li>
    <ul>
      <li>Google Drive</li>
      <li>DropBox</li>
    </ul>
    <li><strong>F. Phase de Test</strong> <a href="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/wiki/Cahier+des+Charges/#f-phase-de-test">→</a> </li>
</ul>

<hr /><!--- ================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================ -->

### A. Cadre du Projet
<ul>

<li><strong>1. Planning</strong></li>
    <p>Diagramme Gantt :</p>
    <br/>
    <img src="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/raw/master/Images/PT_drive.jpg" alt="Diagramme de Gannt" />

    
    <li><strong>2. Contraintes</strong></li>
    Rédiger ici
    
    <li><strong>3. Raisons et intérêt du projet</strong></li>
  
    <p>Notre projet est un mélange entre l’explorateur de linux, git et google drive. Nous allons essayer de prendre le meilleur de chaque et remplissant le plus ce que nous voulons produire afin de réaliser une application aussi pratique que visuellement agréable et simple, tout en gardant l’accès à toutes les informations passant par notre plateforme.</p>
    
</ul>

<hr /><!--- ================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================ -->
### B. Structure de la Plateforme

<ul>

<li><strong>1. Hébergement</strong></li>

<p>Tout est hébergé sur une machine virtuelle (Serveur web, Base de donnée, Fichiers utilisateurs) avec ArchLinux. Cela simplifie notre gestion de projet car tout se trouve à un seul et même endroit.</p>
    
    <li><strong>2. Base de données</strong></li>
  
      <img src="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/raw/master/Model.png" alt="Diagramme de classe de la base de données" />
      <p>Notre base de données sera paramétrée avec mysql, on interagira avec celle-ci à l’aide de phpMyAdmin. Elle regroupera globalement: les informations pour les fichiers (métadonnées), pour les utilisateurs, ainsi que les permissions permettant de relier utilisateurs et fichiers.</p>
      
      <li><strong>3. Sécurité</strong></li>
  
    <p>Nous allons devoir faire grandement attention à la sécurité, autant sur l’application WEB que sur le daemon.</p>
    <ul>
    <li><strong>Application WEB</strong></li>
       <p>Concernant l’application WEB, nous devrons faire attentions aux risques correspondant bien évidemment au WEB :</p>
<ul>
  <li>Authentification (Gestion authentification et session, Références à un objet non sécurisé)</li>
  <li>Autorisations et permissions (Défaillance de restriction d'accès à une URL)</li>
  <li>Attaques côté client (Cross-Site scripting)</li>
  <li>Exécution de commandes (Injection)</li>
  <li>Révélations d’informations (Gestion de configuration non sécurisée,Stockage de données non sécurisé,Communications non sécurisées )</li>
  <li>Attaques logiques (Falsification de requêtes intersites,Redirection et renvoi non validés )</li>
</ul>


   <p>Voici un tableau de présentation des risques concernant le web avec degré d’importance (Données certes un peu vieilles mais révélatrices des risques avec A1 : risque élevé et A10 risque peu élevé)</p>
   <img src="https://lh3.googleusercontent.com/FcMdBMkmgHE9pi-FC0DaWdQ2vJtQ2hNm2CwDkpj_k3dSD9zFXqWIdXesMD2PyVy7Csj-PT5LnCODllJb3PWQjCeGLw7pRgYbK6ErIwNKobpS1zkZe36_TPf9hibKwbLwF_gS_wiY" alt="Présentation des risques web" />

<li><strong>Daemon</strong></li>
   <p>Lors de la connexion, les mots de passent devront être chiffrés pour éviter les "sniffers".<br>Il serait également intéressant de vérifier que personne n'upload de programme malveillant sur le drive, mais on peut partir du principe que l'utilisateur doit faire attention à ce qu'il ouvre.<br>D'autres sécurités plus spécifiques au système d'exploitation utilisées seront aussi à prendre en compte.</p>
</ul>
</ul>
<li><strong>4. Espace de Stockage</strong></li>
<ul>
<li><strong>Permissions</strong></li>
<p>Les permissions seront un incontournable de notre projet. Un utilisateur créant un fichier ou un répertoire aura, par défaut l’accès unique à cet objet (Personne d’autre ne pourra y avoir accès). L’utilisateur peut cependant modifier les permissions d’un fichier ou répertoire et y ajouter un utilisateur, un groupe ou un cercle dont il fait parti. Le but est de fournir une application fonctionnelle mais sécurisée dans l’accès aux fichiers.</p>
<li><strong>Quota</strong></li>
Nous prévoyons de donner des cotats aux utilisateurs, les quotas servent à empêcher une trop grande création de fichiers ou répertoire. Si un utilisateur arrive à créer une boucle créant des fichiers ou répertoires, le serveur va se retrouver down rapidement. Les utilisateurs auront donc des cotats d’espace mais aussi de nombre de fichiers. Pour ainsi éviter d’uploader des fichiers trop gros mais aussi éviter le spam de création de fichiers d’1 bit par exemple.

</ul>
<li><strong>5. Gestion des interactions</strong></li>
<ul>
<li><strong>Inscription/Connexion - Type de Compte</strong></li>
<br/>L’iut dispose d’une base de données LDAP, c’est celle qui est par exemple utilisée lors de la connexion sur les postes informatiques de l’iut.
<br/><br/>Les étudiants et professeurs auront la possibilité de se connecter à partir de cette base de données. Les utilisateurs ne pourront donc pas s’inscrire en tant qu’étudiant ou professeur. Il leur sera cependant possible de faire une inscription externe (pour acquérir un compte dit "Indépendant") avec confirmation par email.
<br/><br/>Ces comptes indépendants ne disposeront pas des dossiers présynchronisés tel que “Année 2017”, “Groupe 4”, “FA2”, qui seront des dossiers de groupe déjà présent sur le drive pour les différentes classes, car ce sera des dossiers réservés aux étudiants/professeurs de l’iut. Il sera cependant possible pour ces comptes indépendants de créer des “cercles” (c’est-à-dire des groupes entre amis) avec des étudiants/professeurs.
<br/>Il sera donc possible de se connecter avec un compte:
<ul><ul>

<li><strong>Etudiant:</strong> L’utilisateur devra être enregistré sur la base de données de l’iut; il rentrera son nom d’utilisateur et son mot de passe, une requête LDAP sera ensuite envoyé, si elle répond positivement aux identifiants: l’utilisateur sera connecté au drive avec un compte étudiant. Il disposera par défaut d’accès à un dossier de partage pour tout l’iut, un dossier de partage auquel auront accès tous les étudiants de sa promotion (exemple “Année 2017”), ainsi qu’un dossier de partage pour les gens de sa classe. Il lui sera par la suite possible -comme n’importe quel utilisateur- de créer des dossiers de partage entre amis (dit des “cercles”).</li>

<li><strong>Professeur:</strong> L’utilisateur devra être enregistré sur la base de données de l’iut; sur le même principe que l’étudiant: il rentrera son nom d’utilisateur et son mot de passe, une requête LDAP sera ensuite envoyé, si elle répond positivement aux identifiants: l’utilisateur sera connecté en tant “professeur”. Les professeurs auront accès à un dossier commun pour tous les professeurs, l’accès aux dossiers de partage des étudiants restent encore à voir.</li>

<li><strong>Indépendant:</strong> L’utilisateur devra s’inscrire à sa première connexion, fournissant obligatoirement: email, login et mot de passe. Il pourra -s’il le souhaite- également poster une photo de profil et fournir des informations complémentaires à son inscription, tel que “profession”, etc. Il ne disposera par défaut: que d’un accès à son dossier personnel.</li>

</ul></ul>

A noter qu’à leur première connexion: les étudiants et professeurs se verront enregistrés dans la base de données. Ils auront ensuite la possibilité de spécifier un email s’ils le souhaitent, une photo de profil ainsi que d’autres informations complémentaires.



<li><strong>Compte Administrateur</strong></li>
   Administrateurs: les comptes administrateurs pourront être des étudiants, des professeurs, ou des indépendants. L’idée et qu’ “Administrateur” soit une étiquette procurant des droits sur les modifications de n’importe quel dossier(s)/groupe(s)/utilisateur(s) permettant de éventuellement de modérer ce qui est mit en ligne, résoudre les problèmes, recevoir les tickets de problème des étudiants.<br/><br/>Par défaut les utilisateurs ne disposent pas de l’étiquette “Administrateur” et n’ont pas de droit particulier.
<li><strong>Type d'accès aux fichiers/dossiers</strong></li>
<ul>
<li><strong>Type de dossier</strong></li>
<ul><ul></ul>
<li><strong>Dossier Perso :</strong> Les dossiers perso sont les dossiers que chaque utilisateur possède, il peut se permettre de laisser en libre téléchargement certains fichiers mais par défaut le dossier est personnel pour chaque utilisateur, afin qu'ils puissent héberger leurs fichiers.</li>
<li><strong>Dossier Groupe (Pour les classes, exemple: An17+Groupe3) :</strong> Les dossiers de groupes ne sont pas paramétrables par des utilisateurs basique. Ils donnent l'accès à des fichiers à partager pour une classe. D'après l'organisation de l'IUT, cela représente un GX avec X correspondant au numéro du groupe</li>
<li><strong>Dossier Section (Pour les promos, exemple: An17) :</strong> La section correspond à une promotion, les dossiers étant des dossiers section sont accessibles par exemple à tout les utilisateurs de la promotion "Informatique"</li>
<li><strong>Dossier Cercle (Entre utilisateurs, création libre, exemple: projet ACDA) :</strong> Le dossier cercle sera un dossier créer par un utilisateur, il peut-être rendu accessible à son bon vouloir à n'importe qui.</li>
</ul>
<li><strong>Navigation dans les dossiers</strong></li>
Barre de recherche : La barre de recherche va permettre à l'utilisateur d'afficher tout les fichiers ou dossiers comportant la chaine de charactère mise dans l'explorateur. Bien évidemment, les fichiers ou dossiers dont l'utilisateur n'a pas accès ne seront pas affichés grâce à l'explorateur.
Explorateur de fichier : L'explorateur de fichiers fonctionne comme sur Linux, il va permettre à l'utilisateur de naviguer entre les différents dossiers pour pouvoir afficher tout les fichiers dont il possède les droits d'accès.
<li><strong>Permissions</strong></li>
Les utilisateurs disposent de leur dossier personnel, ils peuvent choisir d'y mettre des fichiers et autoriser n'importe qui à les télécharger ou autoriser seulement des personnes spécifiques.<br/>Si quelqu'un décide de mettre un fichier
</ul>
</ul>

<hr /><!--- ================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================ -->


### C. Applications

<ul>
<li><strong>0. Diagrammes</strong></li>
    <strong>Diagramme de cas d'utilisation :</strong>
     <img src="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/raw/master/Images/Use%20case.png" />
     <strong>Diagramme de classe</strong>
     <img src="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/raw/master/Images/Class%20Diagram.png" />
<li><strong>1. Application Web</strong></li>
<ul>
<li><strong>Fonctionnalités utilisateur</strong></li>
Voici un wireframe de ce que nous envisageons comme model principale pour l’interface web lorsque l’utilisateur est connecté; une sorte de “menu” entre-autre.<br/>
Le wireframe ne contient que les fonctions nécessaires à l’utilisateur, pour la thématique de la fenêtre, voir la Charte Graphique (D.)<br/>

 <img src="https://lh4.googleusercontent.com/_RYIDwN1v0IpgkUJVnQoWbjnCv0-e3xZ1Ypup-qiqyPOTGuyCxoZeCIRWictq60eis3V4ejNN13Nt-XhiSrSz8XWq9aRd8zCYgSxEafz3FxithP_7DTHUhbFlkZTONKkQoEHqTmY" alt="Wireframe" />
 
 <hr /><!--- ================= -->
 
 <br/>On retrouve au centre de la fenêtre l’explorateur de fichier, qui comme n’importe quel explorateur affiche les fichiers et dossiers présents dans le chemin où l’on se trouve.<br/>

 <img src="https://lh5.googleusercontent.com/8nqJLNa7amQlQrM9dve-wsXDw7g4p751hMjJSe391BEivvpNHRKovDO8MYo0ol_dIhUwYjPVBp1BIbXLLaCYXn4YUgVBwXVPVkU3jW_ePTN4wDdH4YQ9qw4lWOpLw1gQjLQEDl5Z" />
 
 <hr /><!--- ================= -->
 
<br/>En bas de l’explorateur, on peut voir la liste des utilisateurs ayant accès à ce groupe/dossier.<br/>

 <img src="https://lh5.googleusercontent.com/eSU2ORKFlZqMtQKGBW31xzs3V6IyEpimxMPv-MzfPB4coMV8FWl0jiVEqdGFRozzZX4eGp0MRkLLI5PvmIgyd2_-Jq5SncAwzMXYQPfifyQOQfAC5VHY_IOlu0fWJJWo3z6g5-LR" />

<hr /><!--- ================= -->

<br/>Nous savons qu’il y aura à terme de nombreux fichiers et dossiers, il est donc nécessaire de faire une barre de recherche permettant de parcourir rapidement les fichiers dans tout le serveur. Bien évidemment, seuls les fichiers où l’utilisateur possède les droits d’accès pourront être vus par celui-ci<br/>

 <img src="https://lh4.googleusercontent.com/End0FAU7-FcMJ0KDZUjoGGofpo9VpWGoY8CxRChIHOW2pWOXdLj4Tnt3Z2aeSpkqFvMyfiw_hElk-_tJPwcGpvPFK3BxkhFeXd3t54ATF3evi4AVsW3_WgZh07DXzmeiMAjdrrbI" />

<hr /><!--- ================= -->

<br/>L’utilisateur retrouvera une arborescence du chemin dans lequel il se trouve dans la partie “Explorateur” à droite qui affichera sous forme d’arbre les différents dossiers auxquels il a accès.<br/>

 <img src="https://lh4.googleusercontent.com/CJY0jgF0HzurGIFK3MehFx9sYFDFy971h4J69tLjc5BJGZ9vuKwOqdWux7LFTcAQnrZRA2MLu1AioNDrFycWK1jh3X6H9HmSutFg8vPKQVPu1SsbtKKK-f1LLaW6TvA2jSZkjfse" />

<hr /><!--- ================= -->

<br/>Les groupes auxquels il appartient seront visibles en bas à gauche de sa fenêtre, lorsqu’il cliquera sur un groupe: il aura la possibilité de voir les membres, gérer leur adhésion et leur exclusion s’il en est le créateur<br/>

 <img src="https://lh6.googleusercontent.com/j7aQCEXzO-CygGQzXx9qI6tJLsl9KakkMLgLEQi4Dj19uDaw4Dqz98J0TU09viJfqklzJHwn7hdKbhQtT77hQpnvJ84jCPMJJZ8O9smg85_e335zxLVnzn5Jfw9A8XcGVmN2636x" />

<hr /><!--- ================= -->

<br/>L’onglet “prévisualisation” affichera les méta-données basiques d’un fichier ou d’un dossier lorsque l’on clique dessus dans l’explorateur de fichiers.<br/>

 <img src="https://lh5.googleusercontent.com/E9P5ENoA9h0T73jWGyaDNTjHPxroNqCXYkGo8v6wSo1wcSS8pnbD4Oovdn5pb3kmSTopfk9eBVEKsV5s6CaLHdPBr1vDAdRz5T4u1hn1BN1Rg2-sweRyPTnLSAGpSXqBS94ziaXl" />

<hr /><!--- ================= -->

<br/>Le chat, présent en bas à droite de la fenêtre va permettre aux utilisateurs de se parler entre eux, nous estimons cette fonctionnalité pratique lorsque des utilisateurs modifient un même répertoire et qu’ils ont besoin de communiquer ensemble.<br/>

 <img src="https://lh5.googleusercontent.com/d9HsE-uYyTnnChjnbOURTyHzNiSwKwRxrgvD2Kdfb14LGnw77kt9U1v41nx8DCy7vUuIryEy8ISJrhXki-2DQ-2VOzuE8fr2oqhZ0QU_R-sIeVQDvkNu2SzjFn8fsKuCqxNnCdcx" />

<br/>Chaque groupe, c’est-à-dire: cercle d’amis, promo, groupe de classe, etc. (voir B.5.b) disposera d’un chat distinct, ainsi chaque canaux de discussion sera spécifique à un projet/embranchement.
Les utilisateurs ne pourront -en théorie- pas avoir de discussion privé avec un autre utilisateur, pour le saluer par exemple.<br/><br/>Dans son profil, l’utilisateur aura la possibilité de changer sa photo de profil, afin d’être plus reconnaissable par les autres utilisateurs.
<br/>S’il s’est inscrit de manière indépendante, il aura également la possibilité de changer son login ainsi que son mot de passe.<br/>S’il s’est connecté via la base de données LDAP de l’iut, il pourra seulement modifier sa photo de profil.

<hr /><!--- ================= -->

<li><strong>Spécificité Développeur</strong></li>
L’application web utilisera Laravel, c’est un framework relativement connu, notre choix s’est porté sur ce dernier car nous voulions un framework PHP et il semble -d’après les avis des internautes- adapté pour les petits et gros projet. C’est également pour nous l’opportunité d’adopter la maîtrise d’un nouveau framework<br/><br/>Les langages utilisés seront évidemment l’html, le php, le css ainsi que le javascript et le jquery.

<li><strong>Accessibilité</strong></li>
L’utilisateur devra pouvoir accéder à l’application Web depuis son ordinateur à partir de n’importe quel navigateur commun tel que Google Chrome, Mozilla, Internet Explorer, etc. via un URL (pour le moment non-défini), par exemple: https://drive-iut-fbleau.fr/ <br/><br/>Pour ce faire nous avons fait le choix d’installer Apache2 sur notre machine virtuelle. C’est le serveur HTTP le plus utilisé à l’heure actuelle et nous garantissant la meilleure stabilité avec Laravel.<br/><br/>L’utilisateur aura ensuite la possibilité de se connecter/s’inscrire pour interagir avec la Plateforme. Un utilisateur non-connecté pourra seulement accéder aux fichiers publiques que tout le monde peut visionner et les télécharger s’il le souhaite.

</ul>

<li><strong>2. Logiciel (Daemon)</strong></li>
<ul>
<li><strong>Fonctionnalités Utilisateur</strong></li>

Le daemon que nous allons développer permettra à l’utilisateur d’avoir un dossier sur sa machine, en local, contenant ses différents dossiers de partage, synchronisé automatiquement . En outre, l’utilisateur aura uniquement besoin de se connecter une premiere fois, ainsi que de spécifier le chemin du dossier à synchroniser.
Il sera aussi possible pour un utilisateur n'appartenant pas au domaine de l'IUT de s'inscrire en tant qu'indépendant via ce logiciel.

<hr /><!--- ================= -->

La première fois que le daemon sera lancé, il sera représenté ainsi:

 <img src="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/raw/master/wireframes/Screenshot_2018-12-21%20Wireframe%20cc%20-%20minimal%20wireframing%20tool.png" />
 
<hr /><!--- ================= -->

<br/>Une fois connecté, les utilisateurs auront un rappel de leur avatar ainsi que de leur login.<br/>Il verra également la place qu'il utilise et la place totale qui lui est allouée sur le drive.<br/>Il aura la possibilité de changer le dossier qui servira à synchroniser les élements de la Plateforme en cliquant sur le chemin déjà existant<br/>En dessous il verra la liste des groupes auxquels il appartient (pour rappel, par exemple: "An17; Projet APL; Groupe3"), il pourra choisir pour quel groupe il décide de synchroniser automatiquement les fichiers.<br/>Le bouton "Déconnexion" lui permettra de se déconnecter, il sera normalement peu utilisé si les gens souhaitent utiliser le drive.<br/>Le dernier bouton permettra d'accéder directement au site web.

 <img src="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/raw/master/wireframes/Screenshot_2018-12-21%20Wireframe%20cc%20-%20minimal%20wireframing%20tool%281%29.png" />

<hr /><!--- ================= -->

<li><strong>Spécificité développeur</strong></li>

Afin d’être le plus cohérents possibles avec les deux systèmes d’exploitation que nous utilisons à l’IUT, nous développerons 2 daemons différents, l'un pour Linux, en C, et l’autre pour Windows, en C# (langage .NET). C’est l’occasion pour nous d’apprendre le C#, langage très utilisé en entreprise, et plutôt versatile.

<li><strong>Accessibilité</strong></li>
   
L'utilisateur aura besoin de télécharger et d'installer le daemon sur sa machine et de se connecter, puis le logiciel tournera en "tache de fond" pour effectuer la synchronisation des dossiers. Le logiciel se lancera automatiquement au démarrage de la session.
Le logiciel sera disponible sur le site.

</ul>

<li><strong>3. Application Mobile</strong></li>
<strong>L’application mobile n’est pas la priorité du projet, c’est un module complémentaire qui reste seulement une éventualité. C’est une partie qui sera envisagée si le logiciel et le site internet sont terminés dans les temps.</strong>

<ul>
<li><strong>Fonctionnalités Utilisateur</strong></li>
  Voici un wireframe de ce que nous envisageons.
Cependant L'application mobile serait une option supplémentaire si nous avons le temps de la réaliser. Elle est donc facultative.
<br>
<img src="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/raw/master/Images/AccueilMobile.png" alt="Accueil appli" />
<br>
Voici un wireframe lorsque l'on développe le menu : 
<br>
<img src="https://dwarves.iut-fbleau.fr/git/szatkows/PT_Drive/raw/master/Images/MenuMobile.png" alt="Menu Appli" />
<br>


L'application a pour but d'avoir une interface afin de pouvoir consulter facilement les documents ainsi que pouvoir envoyer par mail facilement et rapidement.
Si l'utilisateur est déconnecté il pourra regarder les fichiers publiques.
   <li><strong>Spécificités développeur</strong></li>
  Afin de réaliser cette application nous allons utiliser android studio avec le sdk android Marshmallow 6.0.
   <li><strong>Accessibilité</strong></li>
   
L'utilisateur devra pouvoir télécharger l'APK de l'application depuis le site web.
L'utilisateur sera déconnecté automatiquement s'il ferme l'application
</ul>

</ul>

<hr /><!--- ================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================ -->


### D. Charte Graphique

   *Après nous être concertés, nous avons décidé de prendre la charte graphique du site de l'IUT pour que les étudiants ne soient pas trop dépaysés dans l'utilisation du drive. Cette charte graphique n'est pas encore réellement définie mais nous voulons pour le moment partir sur cette décision. Des changements pourront avoir lieu lors de la phase de développement des applications.*

### E. Projets similaires / concurrents
<ul>
  <li><strong>Google Drive</strong></li>
   <ul>
   <li><strong>Différences spécifiques:</strong></li>
    <ul>
      <li>Impossible de partager ses fichiers avec des groupes de personnes</li>
    </ul>
    <li><strong>Similitudes spécifiques:</strong></li>
    <ul>
      <li>Possibilité de donner accès à ses fichiers à certaines personnes</li>
      <li>Syncrhonisation des dossiers/fichiers automatique (avec Drive File Stream)</li>
    </ul>
   </ul>
  <li><strong>DropBox</strong></li>
   <ul>
   <li><strong>Différences spécifiques:</strong></li>
    <ul>
      <li>~~~~~</li>
    </ul>
    <li><strong>Similitudes spécifiques:</strong></li>
    <ul>
      <li>Synchronisation des dossiers/fichiers automatique</li>
    </ul>
   </ul>
</ul>

<hr /><!--- ================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================ -->

### F. Phase de Test
   Lors de la fin de la phase de développement, nous lancerons la version "Beta" à laquelle un petit groupe de personnes aura accès, lors de laquelle nous vérifierons le bon fonctionnement des différentes fonctionnalités de l'application Web et du daemon.
