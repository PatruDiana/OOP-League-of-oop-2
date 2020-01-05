// Patru Diana-Georgiana 322CA
# Project - Stage 1 & 2 - League of OOP
// STAGE 1 \
 As this is the first part of the project, I have tried as much as possible to structure and 
organize the logic of the code itself in as many packages and having suggestive names with 
specific functionalities. So, in the following, I will try to explain each package and the files
 that belong to it.
 
> 1  Abilities package 
>> * Each hero ability represents one file in which the visit() method is overwritten for each
>> hero type. These are part of the Double Dispatch concept, in which we deal with several categories 
>> of objects (each category containing objects of different types), between which there is an interaction. 
>>* Thus, each hero interacts with the type of ability corresponding to the opponent in the current battle. 
>> Each ability represents "a visitor" that determines the damage it inflicts on the opponent.
>> 
>
> 2 Common package 
>> * Contains a file called Constants.java in which all int or float constants are declared to determine 
> the damage, hp, or xp for each hero.
>
> 3 Heroes package
>> * Contains an abstract Hero class that is expanded by each type of hero: Pyromancer, Knight, Rogue,
>> Wizard and which contains all the hero methods for moving, fighting, level updating, hp, xp, etc.
>> * The Visitable class is an interface, whose accept method (Visitor) allows each ability to visit
>> each hero, being part of the Double Dispatch Concept. 
>> * The Factory Pattern design is used to create the types of heroes that correspond to the input data.
>
> 4 Main package 
>> * Contains the Main class that calls the GameInputLoader instance, which uses reading from the
>> first homework :). 
>> * The Game class, instantiated with Singleton Pattern, contains methods of creating heroes, conducting 
>> the game itself on rounds but also displaying the board game at the end of the game.
>
> 5 Map package
>> * Contains the instant Map class with Singleton Pattern, and represents the game map and the type of 
>> land for each corresponding box.
>

// STAGE 2 \
As for the 2nd stage of the project, we have created a package for angels, strategy but also for the
 great magician, which will be explained below.
 
> 6 Angels package
>> * Containts an abstract Angel class that is expanded by each of 10 types of angels, which contains
>>  the coordinates on the map and all the angels methods: add one observer, when an angel appears on
>> on the map and the action of each angel on each hero.
>> * The VisitableAngel is an interface, whose accept method (VisitorAngel) allows each ability to 
>> visit each hero, being part of the Double Dispatch Concept.
>> * The Factory Pattern design is used to create the types of angels that correspond to the input data.
> 
>
> 6 Strategies package
>> * It contains 2 classes for each type of hero: the offensive strategy (the one in which the player 
>gives up  of his life to give greater damage to the opponent) and the offensive strategy (the player 
>>reduces his damage to gain more life). 
>> * Each player's strategy is implemented using the Strategy Design Pattern and depends on the 
>> player's current life.
>
> 7 TheGreatMagician package
>> * It contains an abstract class Observer, which has as observable objects, an angel and a hero. 
>> In order to be able to display the output corresponding to each test, I have created a class 
>>for all the dates in which the great magician must be notified by how many angels or heroes: 
>> when an angel appears on the map, when a player dies / revives but also when a player does level up.
>> * The display is implemented with the help of the Observer Pattern Design.

I left attached in the archive and the .git folder for granting the bonus :) :)