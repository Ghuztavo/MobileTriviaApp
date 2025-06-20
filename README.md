# MobileTriviaApp
Simple mobile app made in android studio that allows users to choose a category and play a game of trivia. 

# Simple Trivia Game

A **Simple Trivia game** built in **Android Studio** as a college project, with the main objective of practicing the tools and components provided by the IDE.  
Players can select a category of questions and must answer as many questions as possible before the time runs out.

---

## 🕹️ Gameplay Overview

- The player starts on a **splash screen** with the app title. Tapping the screen leads to the **main menu**.
  ![ezgif-83fc79134a6559](https://github.com/user-attachments/assets/55f80be4-4690-45ad-a684-067445f9f199)
- In the main menu:
  - A **brief instruction** explains how to play the game.
  - A **SeekBar** allows the player to set the time limit for the game.
    ![ezgif-8f461de5fd78cf](https://github.com/user-attachments/assets/931214c9-ba70-44f7-a895-0255a58ef220)
  - A **RecyclerView** displays all available categories (customizable and extendable).
    ![ezgif-87ed8cb048407a](https://github.com/user-attachments/assets/07122541-7a0b-483c-adb8-153d5201a099)
- After selecting a category, the **game screen** appears:
  - Displays the **category title**, **time left**, **question**, **possible answers**, and **current score**.
    ![ezgif-8d4b4e7097a607](https://github.com/user-attachments/assets/81bf4ecc-0c36-4eed-8976-f026c4b32f4e)
  - If the player selects the correct answer:
    - The selected button turns **green**.
    - The score is increased.
      ![ezgif-8b99837d626c9c](https://github.com/user-attachments/assets/e0e5f1fd-7d67-435c-8bd9-dcebc324e8c6)
  - If the player selects a wrong answer:
    - The **correct answer button turns green**.
    - The **wrong answer button turns red**.
    - After a short delay, button colors reset for the next question.
      ![ezgif-8ce5fac0bffde1](https://github.com/user-attachments/assets/39b9255f-ca0d-49c3-9972-66d3d18e1cf4)
- When the timer runs out:
  - A **game over screen** shows the final score.
  - A button returns the player to the main menu.
  ![ezgif-840f0f713b06fa](https://github.com/user-attachments/assets/8670432e-ffaa-4c35-99c3-992703b4f23a)
- A **back button** is available at the top-left corner of the game screen for returning to the main menu at any time.
  ![ezgif-81d907956e0d48](https://github.com/user-attachments/assets/6639b96a-4ae2-41ab-ad1e-42c76d785318)

---

## 🧠 Features

- Time-limited quiz rounds with a customizable duration.
- Category-based questions with expandable category support.
- Visual feedback for correct and incorrect answers.
- Simple, intuitive user interface.

---

## 🚧 Challenges Faced

- Implementing the **game logic**, especially:
  - Randomizing questions.
  - Checking and highlighting correct/incorrect answers.
- Managing **Activity transitions** and maintaining game state when switching between screens.
- Ensuring a smooth and responsive UI experience.

---

## ✅ Requirements

- Android Studio
- Kotlin or Java (depending on your implementation)
- Android device or emulator
- Versions needed:
    - agp = "8.10.0"
    - kotlin = "2.0.21"
    - coreKtx = "1.16.0"
    - junit = "4.13.2"
    - junitVersion = "1.2.1"
    - espressoCore = "3.6.1"
    - appcompat = "1.7.1"
    - material = "1.12.0"
    - activity = "1.10.1"
    - constraintlayout = "2.2.1"










