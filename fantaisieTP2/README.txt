--> Groupe: 

###########   TP2 -- FANTAISIE    ###########
#                                           #
#      Téri   GRANDPIERRE   ---- READ ME    #
#                                           #
###########        -------        ###########

This is a maven project of the TP2 "fantaisie".

---Peut s'importer sous Eclipse---

arborescence packages: 

fantaisie_TP2
  |__ attaque
  |     |__ armes
  |     |__ pouvoirs
  |           |__ fireSpells
  |           |__ iceSpells
  |           |__ sharpSpells
  |__ protagonistes
  |__ bataille
  |__ livre
  |__ mainApp
  |__ mainAppOld (for test purposes only + TP1)  
              
        

Are missing the usual .project, .classpath and .settings files/folder. These are generated automatically (on VSCode 
for example).

To use this project in Eclipse, just import it as a maven project:

File > Import... > Maven > Existing Maven Project

then select the unzipped project (the file pom.xml appears is the Projects subwindow) and hit finish.

