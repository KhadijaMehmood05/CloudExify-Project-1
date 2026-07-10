# CloudExify-Project-1#
Number Guessing Game (Java Swing)

## Project Overview

Number Guessing Game is a Java-based desktop application developed using **Java Swing GUI**. The purpose of this game is to guess a randomly generated number within a limited number of attempts. The game provides different hints to guide the player and improve the guessing experience.

This project demonstrates the implementation of **Object-Oriented Programming (OOP)** concepts, GUI development, event handling, and file handling in Java.

---

##  Features

*  Interactive graphical user interface using Java Swing
*  Random number generation
*  Two difficulty levels:

  *  **Easy Level:** max 10 attempts
  * **Hard Level:** max  7 attempts
* Helpful hints:

  * Too High
  * Too Low
  * Warmer (closer to the target number)
  * Colder (farther from the target number)
* Attempts counter
*  Best score saving using file handling
* Leaderboard system for top scores
* Play Again option
* Dynamic background changes according to game status

---

## Technologies Used

* **Programming Language:** Java
* **GUI Framework:** Java Swing

### Concepts Used:

* Object-Oriented Programming (OOP)
* Classes and Objects
* Encapsulation
* File Handling
* Event Handling
* Exception Handling

---

## Project Structure

NumberGuessingGame/
│
├── src/
│   ├── Game.java
│   ├── NumberGuessingGameGUI.java
│   └── ScoreManager.java
│
├── screenshots/
│
├── bestscore.txt
├── .project
├── .classpath
└── README.md


## ▶️ How to Run the Project

### Requirements:

* Java Development Kit (JDK) installed
* Eclipse IDE (recommended) or any Java IDE

### Steps:

1. Download or clone this repository.
2. Open **Eclipse IDE**.
3. Select:
   File → Import → Existing Projects into Workspace
  
4. Select the downloaded project folder.
5. Click **Finish**.
6. Open:
   NumberGuessingGameGUI.java

 from the `src` folder.
7. Run the project using:
   Run → Run As → Java Application
   
The game window will open, and you can start playing.

---

## How to Play

1. Select a difficulty level.
2. Enter a number within the given range.
3. Click the **Guess** button.
4. Use the hints to find the correct number:

   * **Too High:** Enter a smaller number.
   * **Too Low:** Enter a larger number.
   * **Warmer:** Your guess is closer to the target number.
   * **Colder:** Your guess is farther from the target number.
5. Try to guess the number using fewer attempts to achieve a better score.

## Screenshots
Screenshots of the application are available in the separate **screenshots** folder in this repository.

##  Learning Outcomes

Through this project, I learned:

* Developing GUI applications using Java Swing
* Handling user interactions and events
* Applying OOP concepts in a practical project
* Working with file handling for data storage
* Creating an interactive desktop application

## 👩‍💻 Author
**Khadija Mehmood**

## ⭐ Future Improvements

* Add sound effects
* Add user profiles
* Store leaderboard data using a database
* Add more difficulty levels
* Improve animations and user experience
