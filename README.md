# zuul-with-enums-v2
 RVCC 242 - Ch 8 project

## Super Text Adventure :: Possibility is Infinity!
Starting from the World of Zuul example provided (zuul-with-enums-v2), craft your own text adventure.

Fork the project from:  https://github.com/GDEV242-Fa19/zuul-Project-Base (Links to an external site.)

## Mandatory features:
If any of the following steps are not completed, the assignment will not be graded.

Every class must have a meaningful javadoc class header with appropriate text and updated @author and @version directives
Every method must have a meaningful javadoc method comment with appropriate directives (@param, @return, @throws, etc.)
The javadoc for your project must be generated and in the doc directory in your project directory
There must be a main method for the game class that allows the game to be run outside of BlueJ
(The game can still be invoked from within BlueJ by instantiating the Game class and invoking play() method)
Your map must contain at least 15 rooms, though it may contain more if you wish
### Everyone must 
8.14 - add the look command to your game (p 303) 

 

### To earn a C implement the following:
8.15 (p 303) - add another command, ie. eat with a simple text response 
8.16 (p 305) - Streamline printing of available commands
 

### To Earn a B, complete the C task and Implement three (3) of the following
8.20/8.21 (p 308) - add items to your game. Each room can have one item in it. Items have description and weight. When printing room info, Item should be included
8.22 (p 308)- make it so rooms can hold multiple items

8.23 (p 309,310) - implement the back command (back one room)
8.26 - implement the go back many rooms version of the command command (back repeatedly retraces your steps)

8.28-8.33  (p 314) -add a Player that can carry one or more objects according to the options presented


 

### To Earn an A, complete the B task and Implement three (3) of the following
These are the fun ones

- Time limit
- one way trap door
- charged transporter (beamer)
- locked doors and keys
- random transporter (discuss with others about implementation)
- non-player characters with clues/items for trade
- make npc's move 
- rudimentary health system

If you want to add a feature other than these, please e-mail or talk to me. IF it is risky I will ask you to branch your code so I can give credit for the attempt, and if you succeed you can merge your branch back to the main code base. 

 

### Extra Credit
Once you have completed the requirements to earn an A, 

- any features beyond the requirements in sections B and A count for extra credit on your project grade
- each feature must have its own discrete commit in your repository
- features that build or refactor are counted as separate features for example
implement an item
allow player to take item
allow player to drop item
implement a collection of items as Inventory so player may have multiple items
Add inventory to room so room can hold multiple items
Add weight to items so player can only carry specified weight, 
are all separate and count as 5 points per feature provided I see individual commits and progress over time
 

### To Submit - 
Merge your source code in to a single repository
Push your code to github
paste the URL of the repo to this assignment
Submit a one page project report detailing which features were implemented
