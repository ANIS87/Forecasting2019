# Forecasting2019

Ce document présente les démarches techniques suivies dans la conception des applications utilisées pour répondre aux problématiques  annoncées dans les questions d’entretien. 

Dans ce projet, j’ai développé deux modules en java8 et python.

Sur le dépôt github, veullez trouver deux projets:

    Weather_orders_java_maven 	: projet java maven
    
    scripts_python_IA_Pizza_forecastin : projet python.
#  Weather_orders_java_maven

Le module Weather_orders_java_maven est développé en  JAVA8 et MAVEN. Il est utilisé pour collecter et analyser les données fournies par les fichiers XML et l’api Weatherstack.

Pour créer le jar du module, vous pouvez utiliser le script run_test.sh ou bien lancer les commandes suivantes:

    Mettre a jour la cle de l'api weatherstack: Il faut changer la variable public static final String ACCESS_KEY dans le fichier  Weather_orders_java_maven/src/main/java/com/mycompany/app/GetResponseApi.java

    cd Weather_orders_java_maven/
    
    mvn clean install
    
Pour teser le module, il faut utiliser la commande suivante:

    java -jar  target/my-app-1.0-SNAPSHOT.jar -i data.xml -o output.xml
    
ou

    target/my-app-1.0-SNAPSHOT.jar: le fichier jar
    
    data.xml: fichier d'entree ordres.xml
    
    output.xml:fichier de sortie (ajout des données meteo)

 #   scripts_python_IA_Pizza_forecastin
 
Le  module python permet de r tester des algorithmes de Machine Leraning.

Il consiste à  lire un fichier CSV pour générer un  data frame. Ce dernier est utilisé ensuite pour faire des statistiques. J’ai utilisé les libs pandas, numpy pour  transformer le fichier csv en datframe.

Pour développer un modèle prédictif des ventes, j’ai utilisé l’algorithme SARIMA. Cet algorithme est  recommandé pour traiter les problèmes du genre série chronologique  (time series forecasting). 

L’algorithme consiste à entraîner un modèle statistique à prédire une sortie y(t), qui varient en fonction du temps, en se basant sur une base d’apprentissage  collectée à partir des observations réelles.  

Pour juger les performances techniques du modèle ARIMA (précision) est analysé , j’ai effectué des tests sur des données réels et j’ai affiché  le  taux d’erreur obtenu en comparant les observations réelles et les prédictions fournies par le modèle.

Pour lancer le module, il faut installer python (version 3) et les libs pandas (dataframe) et statsmodels (statistiques) et matplotlib (affichage des figures), en utilisant les commandes suivantes sur linux
   
    apt-get install python3
    
    pip3 install pandas
    
    pip3 install statsmodels
    
    pip3 install matplotlib
  
 Pour lancer le traitement 
   

    cd scripts_python_IA_Pizza_forecastin
    
    python3 main.py
    
 Le fichier main.py permet de lire les données csv à partir de dossier data (data/pizzeria_tania_data_simplified.csv) pour créer un dataframe pandas. ce dataframe sera ensuite injecté dans le modèle statistique SARIMAS pour générer le modèle prédictif final.
 
Pour analyser la pertinence d'apprentissage, nous avons testé le modèle entraîné sur des données réelles.Les résultats obtenus sont disponibles dans le dossier images. Chaque image présente présente une comparaison entre les observations réelles et  celles obtenues entre deux dates données.

A titre d'exemple, la figure ci-dessous présente le résultat obtenu suite à une comparaison des observations et prédictions obtenues entre 2016/10/15 et 2016/10/25:
               
 ![alt text](https://github.com/ANIS87/Forecasting2019/blob/master/scripts_python_IA_Pizza_forecastin/images/result_foredastin_from_2016-10-15_01_00_00_to_2016-10-25_01_00_00.png)      
    


