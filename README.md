# KATA-FINANCE
# Auteur: Samir FAKOREDE

Cette application ValoCB permet d'agréger les prix des produits détenus par des clients dans différents portefeuilles.

Les inputs Prices.csv, Product.csv et Forex.csv sont dans src/main/resources.
Les resultats Reporting-portfolio.csv et Reporting-client.csv sont dans src/main/resultats

Les tests unitaires sont dans src/main/tests.

Format Prices.csv:
Les informations utiles doivent commencer à la 5 ème ligne avec ce format:
PTF1,P1,U11,EUR,10 .
Soit respectivement: nom portefeuille,nom produit,nom underlying,devise,prix underlying.(sans espace)

Format Product.csv:
Les informations utiles doivent commencer à la 6 ème ligne avec ce format:
P1,C1,10 .
Soit respectivement: nom produit,nom client,quantité (sans espace)

Format Forex.csv:
Les informations utiles doivent commencer à la 6 ème ligne avec ce format:
EUR,USD,2 .
Soit respectivement: devise1,devise2,taux de conversion de devise1 vers devise2 .(sans espace)
Le taux peut être un réel, si c'est le cas le format est "0,5" (avec les guillemets).

Format Reporting-portfolio.csv:
Les résultats utiles commencent à la 2ème ligne avec ce format:
PTF2,155700.0 .
Soit respectivement: nom portfolio,prix portfolio en nombre réel

Format Reporting-client.csv:
Les résultats utiles commencent à la 2ème ligne avec ce format:
C3,36250.0 .
Soit respectivement: nom client,capital client en nombre réel
