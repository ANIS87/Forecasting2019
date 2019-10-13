# Forecasting2019

Ce document présente les démarches techniques suivies dans la conception des applications utilisées pour répondre aux problématiques  annoncées dans les questions d’entretien. 

Dans ce projet, j’ai développé deux modules en java8 et python, dont les codes sources sont disponibles sur github :https://github.com/ANIS87/Forecasting2019

Sur le dépôt github, veullez trouver deux projets:

    Weather_orders_java_maven 	: projet java maven
    
    scripts_python_IA_Pizza_forecastin : projet python.

Le module Weather_orders_java_maven est développé en  JAVA8 et MAVEN. Il est utilisé pour collecter et analyser les données fournies par les fichiers XML et l’api Weatherstack.

Pour créer le jar du module, vous pouvez utiliser le script run_test.sh ou bien lancer les commandes suivantes:

    cd Weather_orders_java_maven/
    
    mvn clean install
    
Pour teser le module, il faut utiliser la commande suivante:

    java -jar  target/my-app-1.0-SNAPSHOT.jar -i data.xml -o output.xml
    
ou

    target/my-app-1.0-SNAPSHOT.jar: le fichier jar
    
    data.xml: fichier d'entree ordres.xml
    
    output.xml:fichier de sortie (ajout des données meteo)

 
 
 
               
       
    

# Weather
