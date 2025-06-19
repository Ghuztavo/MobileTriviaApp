package com.example.finalproject

data class AnswersSet(val answer1: String, val answer2: String, val answer3: String, val answer4: String)

data class Question (val question: String, val answers: AnswersSet, val correctAnswer: String)

data class Category (val name: String, val questions: List<Question>)

class AppData
{
    companion object {
        var categories = listOf<Category>()

        fun initializeCategories() {
            val mathQuestions = listOf(
                Question("What is 5 + 3?", AnswersSet("6", "7", "8", "9"), "8"),
                Question("What is 12 - 5?", AnswersSet("5", "7", "6", "8"), "7"),
                Question("What is 3 × 4?", AnswersSet("7", "12", "11", "13"), "12"),
                Question("What is 16 ÷ 4?", AnswersSet("2", "3", "4", "5"), "4"),
                Question("What is the square root of 49?", AnswersSet("5", "6", "7", "8"), "7"),
                Question("What is 10²?", AnswersSet("10", "100", "20", "1000"), "100"),
                Question("What is 15 % 4?", AnswersSet("3", "2", "1", "0"), "3"),
                Question("What is 2³?", AnswersSet("6", "7", "8", "9"), "8"),
                Question("What is the value of π (pi) approximately?", AnswersSet("2.14", "3.14", "4.14", "5.14"), "3.14"),
                Question("What is 9 + 10?", AnswersSet("19", "20", "21", "18"), "19"),
                Question("What is 100 ÷ 25?", AnswersSet("2", "3", "4", "5"), "4"),
                Question("What is 6 × 7?", AnswersSet("42", "36", "48", "54"), "42"),
                Question("What is the next prime number after 7?", AnswersSet("8", "9", "10", "11"), "11"),
                Question("What is 81 ÷ 9?", AnswersSet("7", "8", "9", "10"), "9"),
                Question("What is 1/2 + 1/2?", AnswersSet("1", "0.5", "2", "1.5"), "1"),
                Question("What is 30% of 200?", AnswersSet("50", "60", "70", "80"), "60"),
                Question("What is the cube root of 27?", AnswersSet("2", "3", "4", "5"), "3"),
                Question("What is 11 × 11?", AnswersSet("121", "111", "101", "131"), "121"),
                Question("What is 14 - 7 + 2?", AnswersSet("7", "8", "9", "10"), "9"),
                Question("What is 0 × 100?", AnswersSet("0", "1", "10", "100"), "0")
            )

            val scienceQuestions = listOf(
                Question("What planet is known as the Red Planet?", AnswersSet("Earth", "Venus", "Mars", "Jupiter"), "Mars"),
                Question("What gas do plants absorb from the atmosphere?", AnswersSet("Oxygen", "Hydrogen", "Nitrogen", "Carbon dioxide"), "Carbon dioxide"),
                Question("What is H2O commonly known as?", AnswersSet("Salt", "Oxygen", "Water", "Hydrogen"), "Water"),
                Question("What organ pumps blood through the body?", AnswersSet("Lung", "Brain", "Liver", "Heart"), "Heart"),
                Question("How many legs does a spider have?", AnswersSet("6", "8", "10", "12"), "8"),
                Question("What part of the plant conducts photosynthesis?", AnswersSet("Root", "Stem", "Flower", "Leaf"), "Leaf"),
                Question("Which of the following is a mammal?", AnswersSet("Shark", "Frog", "Dolphin", "Eagle"), "Dolphin"),
                Question("What is the boiling point of water?", AnswersSet("90°C", "100°C", "110°C", "120°C"), "100°C"),
                Question("What gas do humans breathe in?", AnswersSet("Carbon dioxide", "Hydrogen", "Oxygen", "Nitrogen"), "Oxygen"),
                Question("How many planets are in our Solar System?", AnswersSet("7", "8", "9", "10"), "8"),
                Question("What is the center of an atom called?", AnswersSet("Electron", "Proton", "Neutron", "Nucleus"), "Nucleus"),
                Question("What natural satellite orbits the Earth?", AnswersSet("Sun", "Star", "Moon", "Asteroid"), "Moon"),
                Question("Which of these is NOT a state of matter?", AnswersSet("Solid", "Liquid", "Gas", "Heat"), "Heat"),
                Question("What is gravity?", AnswersSet("A type of light", "Force pulling objects toward Earth", "Type of energy", "Weather pattern"), "Force pulling objects toward Earth"),
                Question("Which vitamin do we get from sunlight?", AnswersSet("Vitamin A", "Vitamin B", "Vitamin C", "Vitamin D"), "Vitamin D"),
                Question("Which planet is closest to the sun?", AnswersSet("Earth", "Mercury", "Venus", "Mars"), "Mercury"),
                Question("What does DNA stand for?", AnswersSet("Data Network Array", "Deoxyribonucleic Acid", "Digital Numeric Algorithm", "None of these"), "Deoxyribonucleic Acid"),
                Question("What causes tides?", AnswersSet("Wind", "Sunlight", "Moon's gravity", "Rainfall"), "Moon's gravity"),
                Question("Which metal is liquid at room temperature?", AnswersSet("Iron", "Gold", "Mercury", "Zinc"), "Mercury"),
                Question("Which organ is responsible for filtering blood?", AnswersSet("Heart", "Kidney", "Lungs", "Stomach"), "Kidney")
            )

            categories = listOf(
                Category("Math", mathQuestions),
                Category("Science", scienceQuestions)
            )
        }

    }
}