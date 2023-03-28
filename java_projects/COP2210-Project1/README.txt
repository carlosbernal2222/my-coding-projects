Project Name: COP2210 Project 1
Introduction
This Java project simulates a cash register system for a food store. The project includes classes for different types of food items such as apples and sandwiches, as well as a Register class to handle transactions and cash management.

Installation
To run the project, you will need to have Java installed on your system. To compile and run the project, follow these steps:

Clone or download the project repository to your local machine.

Open a command prompt or terminal window and navigate to the project directory.

Run the following command to compile the project:

Copy code
javac app/Controller.java
Run the following command to run the project:

Copy code
java app.Controller
Usage
The project simulates different transactions involving the purchase of apples and sandwiches. The Register class handles cash management and provides information on the amount of cash in the register. The main method in the Controller class is used to execute the different transactions and display the results.

To use the project, simply run the main method in the Controller class as described in the Installation section.

Controller Class
The Controller class contains the main method that executes the different transactions in the project. It also contains a yourInfoHeader method that displays information about the programmer and project.

The main method in the Controller class creates instances of the different food items and Payment objects to simulate transactions. It then calls the buyApple and buySandwich methods in the Register class to process the transactions and update the cash in the register. Finally, it calls the cashInfo method in the Register class to display the amount of cash in the register.

