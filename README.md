# Food Ordering System
This repository contains the implementation of Food Ordering System aplication wirtten in Java. Project was building with Maven,
for operations on input Excel file was used Apache POI library.

## Aplication descriptions
- Application is using Food.xlsx file as the input of data content 
- Application is using onlny command-line interface
- It's possible to order lunch or drink via command-line interface
- There are three defulat cuisines available to choose from (Polish, Mexican, Italian)
- Lunch consists of the main course and dessert
- When ordering a drink, the customer can additionally ask for ice cubes or/and lemon  

**Aditional feauteres**
- It's possible to mix order items via one transaction
- It's possible to order itmes with specific quantity (from 1 to 998)
- It's possible to show/forgot current order and continue work with the new one 

**IMPORTANT!** The solution is extendable it is possible to add new postion( new cuisines/dishes) into application
by editing Excel Workbook. This project supports only XSSF format 
(XSSF is the POI project implementation of the Excel 2007.xlsx file format)   

##Running the aplication  
Once you have cloned the repository to your local machine, follow the directions below:     
1. Set the path to Food Excel file. You can set this path by two different ways directly from main class 
or with first program arguments args[0].  
2. If you want to change content of Excel remeber that:
  * First Sheet contains Launch data (Name of Cuisines, Main course, Dessert, Price)
  * Second Sheet contains Drinks data (Name, Price).


##Using the aplication
1. Execution of action depends on the user's choice. Depending on the entered value it is possible to 
navigate via appliaction view, make order and etc.  

**IMPORTANT!** To make transaction complete select payment option in the General view.




##Author
- Dawid Janik
