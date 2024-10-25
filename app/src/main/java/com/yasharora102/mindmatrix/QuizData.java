package com.yasharora102.mindmatrix;

public class QuizData {
    public static String[] categories = {"Science", "History", "General Knowledge"};
    public static String[] difficulties = {"Easy", "Medium", "Hard"};
    public static String[][][] questions = {
            // Science Questions
            {
                    // Easy Questions
                    {
                            "What is H2O?",
                            "What planet is closest to the Sun?",
                            "What is the speed of light?",
                            "What is the chemical symbol for Gold?",
                            "What is Newton's first law?",
                            "Who discovered penicillin?",
                            "What is the Higgs Boson?"
                    },
                    // Medium Questions
                    {
                            "What is the atomic number of Carbon?",
                            "What is the formula for calculating force?",
                            "What is photosynthesis?",
                            "Who developed the theory of relativity?",
                            "What is the largest organ in the human body?",
                            "Explain quantum entanglement.",
                            "Define Schrödinger's cat."
                    },
                    // Hard Questions
                    {
                            "What is dark matter?",
                            "What is the difference between a virus and a bacterium?",
                            "What is the significance of the double-slit experiment?",
                            "What is the standard model of particle physics?",
                            "What is a black hole?",
                            "Explain the concept of entropy.",
                            "Explain the theory of evolution."
                    }
            },
            // History Questions
            {
                    // Easy Questions
                    {
                            "Who was the first President of the USA?",
                            "When did WWII end?",
                            "Who discovered America?",
                            "What was the Renaissance?",
                            "Who was Cleopatra?",
                            "What was the capital of ancient Rome?",
                            "When was the Declaration of Independence signed?"
                    },
                    // Medium Questions
                    {
                            "When was the Berlin Wall torn down?",
                            "Who was Napoleon Bonaparte?",
                            "What was the significance of the Magna Carta?",
                            "Who was Martin Luther King Jr.?",
                            "What were the main causes of WWI?",
                            "Who was Winston Churchill?",
                            "What sparked the French Revolution?"
                    },
                    // Hard Questions
                    {
                            "Explain the Cold War.",
                            "What was the significance of 1066?",
                            "Who was Genghis Khan?",
                            "What was the Opium War?",
                            "What were the impacts of the Industrial Revolution?",
                            "What were the main events of the Byzantine Empire?",
                            "Why was the Treaty of Versailles significant?"
                    }
            },
            // General Knowledge Questions
            {
                    // Easy Questions
                    {
                            "What is the capital of India?",
                            "Who invented the telephone?",
                            "What is the currency of Japan?",
                            "Which is the largest ocean on Earth?",
                            "Which planet is known as the Red Planet?",
                            "What is the chemical formula for table salt?",
                            "What is the fastest land animal?"
                    },
                    // Medium Questions
                    {
                            "When did humans first land on the Moon?",
                            "Who painted the Mona Lisa?",
                            "How many continents are there?",
                            "What is the smallest country in the world?",
                            "Who wrote 'Romeo and Juliet'?",
                            "What is the largest animal on Earth?",
                            "What is the longest river in the world?"
                    },
                    // Hard Questions
                    {
                            "What is the IMF?",
                            "What is India's GDP (as of 2023)?",
                            "What is the highest mountain peak on Earth?",
                            "Who is known as the father of geometry?",
                            "What is the official language of Brazil?",
                            "What is the longest bone in the human body?",
                            "What is the most spoken language in the world?"
                    }
            }
    };

    public static String[][][][] answers = {
            // Science Answers
            {
                    // Easy
                    {
                            {"Helium", "Water", "Carbon dioxide", "Hydrogen peroxide"},  // Water (1)
                            {"Venus", "Mars", "Mercury", "Earth"},  // Mercury (2)
                            {"499,792 km/s", "299,792 km/s", "399,792 km/s", "199,792 km/s"},  // 299,792 km/s (1)
                            {"Fe", "Cu", "Au", "Ag"},  // Au (2)
                            {"Energy cannot be created or destroyed", "For every action there is an equal reaction", "An object at rest stays at rest unless acted upon by a force", "Force equals mass times acceleration"},  // Object at rest... (2)
                            {"Louis Pasteur", "Alexander Fleming", "Robert Koch", "Marie Curie"},  // Alexander Fleming (1)
                            {"A quantum of light", "A fundamental particle that gives mass to other particles", "A type of atomic nucleus", "A form of radiation"},  // fundamental particle... (1)
                    },
                    // Medium
                    {
                            {"7", "5", "6", "8"},  // 6 (2)
                            {"P = mv", "W = Fd", "F = ma", "E = mc²"},  // F = ma (2)
                            {"Breaking down of food", "Transfer of nutrients in plants", "Process where plants convert sunlight to food", "Release of energy from food"},  // Process where plants... (2)
                            {"Max Planck", "Niels Bohr", "Albert Einstein", "Isaac Newton"},  // Albert Einstein (2)
                            {"Heart", "Liver", "Skin", "Brain"},  // Skin (2)
                            {"Particles splitting apart", "Particles connected regardless of distance", "Particles merging together", "Particles changing state"},  // Particles connected... (1)
                            {"A mathematical formula", "A physics principle", "A thought experiment about quantum superposition", "A theory about cat behavior"},  // thought experiment... (2)
                    },
                    // Hard
                    {
                            {"Black holes", "Anti-matter", "Invisible matter that doesn't interact with light", "Energy in space"},  // Invisible matter... (2)
                            {"Viruses evolve faster", "Viruses need host cells, bacteria are independent", "Bacteria are more harmful", "Viruses are smaller than bacteria"},  // Viruses need host cells... (1)
                            {"Demonstrates gravity", "Shows wave-particle duality of light", "Explains magnetism", "Proves light speed"},  // Shows wave-particle... (1)
                            {"Theory of evolution", "Theory explaining fundamental particles", "Theory of gravity", "Theory of relativity"},  // Theory explaining... (1)
                            {"Space anomaly", "Collapsed galaxy", "Region where gravity is so strong light can't escape", "Dead star"},  // Region where gravity... (2)
                            {"Temperature change", "Measure of disorder in a system", "Heat transfer process", "Energy conservation"},  // Measure of disorder... (1)
                            {"Divine creation", "Spontaneous generation", "Natural selection and genetic variation over time", "Inheritance of acquired traits"},  // Natural selection... (2)
                    }
            },
            // History Answers
            {
                    // Easy
                    {
                            {"Benjamin Franklin", "Thomas Jefferson", "George Washington", "John Adams"},  // George Washington (2)
                            {"1943", "1946", "1944", "1945"},  // 1945 (3)
                            {"Marco Polo", "Christopher Columbus", "Amerigo Vespucci", "Leif Erikson"},  // Christopher Columbus (1)
                            {"Medieval era", "Cultural rebirth in Europe", "Ancient Greek period", "Industrial period"},  // Cultural rebirth... (1)
                            {"Greek goddess", "Last active ruler of Ptolemaic Egypt", "Roman empress", "Persian queen"},  // Last active ruler... (1)
                            {"Constantinople", "Athens", "Rome", "Alexandria"},  // Rome (2)
                            {"July 4, 1777", "July 4, 1776", "July 4, 1775", "July 4, 1778"},  // July 4, 1776 (1)
                    },
                    // Medium
                    {
                            {"1991", "1989", "1988", "1990"},  // 1989 (1)
                            {"Spanish king", "Russian czar", "French military leader and emperor", "British general"},  // French military leader... (2)
                            {"Created parliament", "Established democracy", "Limited royal power in England", "Ended feudalism"},  // Limited royal power... (2)
                            {"Social philosopher", "Religious reformer", "Political activist", "Civil rights leader"},  // Civil rights leader (3)
                            {"Arms race", "Economic depression", "Assassination of Archduke Franz Ferdinand", "Colonial expansion"},  // Assassination... (2)
                            {"French leader", "British Prime Minister during WWII", "German chancellor", "American president"},  // British Prime Minister... (1)
                            {"Natural disasters", "Religious conflict", "Foreign invasion", "Economic crisis and social inequality"},  // Economic crisis... (3)
                    },
                    // Hard
                    {
                            {"Space race", "Nuclear war", "Political tension between USA and USSR", "World War III"},  // Political tension... (2)
                            {"Viking invasion", "Norman Conquest of England", "First Crusade", "Signing of Magna Carta"},  // Norman Conquest... (1)
                            {"Korean king", "Japanese shogun", "Founder of the Mongol Empire", "Chinese emperor"},  // Founder of Mongol... (2)
                            {"Colonial war in Africa", "Conflict over drug trade in China", "Trade dispute in Japan", "Civil war in India"},  // Conflict over drug... (1)
                            {"Cultural changes", "Political reform", "Agricultural revolution", "Mechanization and industrialization"},  // Mechanization... (3)
                            {"Islamic expansion", "Rise of Christianity", "Fall of Constantinople", "Roman conquest"},  // Fall of Constantinople (2)
                            {"Created United Nations", "Started WWII", "Ended WWI and reshaped Europe", "Formed European Union"},  // Ended WWI... (2)
                    }
            },
            // General Knowledge Answers
            {
                    // Easy
                    {
                            {"Kolkata", "Mumbai", "New Delhi", "Bangalore"},  // New Delhi (2)
                            {"Guglielmo Marconi", "Thomas Edison", "Alexander Graham Bell", "Nikola Tesla"},  // Alexander Graham Bell (2)
                            {"Yuan", "Ringgit", "Won", "Yen"},  // Yen (3)
                            {"Arctic Ocean", "Indian Ocean", "Pacific Ocean", "Atlantic Ocean"},  // Pacific Ocean (2)
                            {"Saturn", "Jupiter", "Mars", "Venus"},  // Mars (2)
                            {"CaCl₂", "MgCl₂", "NaCl", "KCl"},  // NaCl (2)
                            {"Tiger", "Leopard", "Lion", "Cheetah"},  // Cheetah (3)
                    },
                    // Medium
                    {
                            {"1971", "1970", "1969", "1968"},  // 1969 (2)
                            {"Botticelli", "Raphael", "Michelangelo", "Leonardo da Vinci"},  // Leonardo da Vinci (3)
                            {"8", "6", "7", "5"},  // 7 (2)
                            {"Liechtenstein", "San Marino", "Vatican City", "Monaco"},  // Vatican City (2)
                            {"John Webster", "William Shakespeare", "Christopher Marlowe", "Ben Jonson"},  // William Shakespeare (1)
                            {"Sperm Whale", "African Elephant", "Blue Whale", "Colossal Squid"},  // Blue Whale (2)
                            {"Mississippi River", "Amazon River", "Yangtze River", "Nile River"},  // Nile River (3)
                    },
                    // Hard
                    {
                            {"International Manufacturing Fund", "International Monetary Fund", "International Management Federation", "International Marketing Forum"},  // International Monetary Fund (1)
                            {"5.7 trillion USD", "4.7 trillion USD", "3.7 trillion USD", "2.7 trillion USD"},  // 3.7 trillion USD (2)
                            {"Mount Kilimanjaro", "Kangchenjunga", "Mount Everest", "K2"},  // Mount Everest (2)
                            {"Thales", "Archimedes", "Pythagoras", "Euclid"},  // Euclid (3)
                            {"French", "English", "Portuguese", "Spanish"},  // Portuguese (2)
                            {"Humerus", "Fibula", "Femur", "Tibia"},  // Femur (2)
                            {"Hindi", "Spanish", "English", "Mandarin Chinese"},  // Mandarin Chinese (3)
                    }
            }
    };

    public static int[][][] correctAnswers = {
            // Science
            {
                    {1, 2, 1, 2, 2, 1, 1}, // Easy
                    {2, 2, 2, 2, 2, 1, 2}, // Medium
                    {2, 1, 1, 1, 2, 1, 2}  // Hard
            },
            // History
            {
                    {2, 3, 1, 1, 1, 2, 1}, // Easy
                    {1, 2, 2, 3, 2, 1, 3}, // Medium
                    {2, 1, 2, 1, 3, 2, 2}  // Hard
            },
            // General Knowledge
            {
                    {2, 2, 3, 2, 2, 2, 3}, // Easy
                    {2, 3, 2, 2, 1, 2, 3}, // Medium
                    {1, 2, 2, 3, 2, 2, 3}  // Hard
            }
    };
}