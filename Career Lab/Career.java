public class Career {
    private String name, subject, hobby, food;
    private int age;

    public Career(String name, int age, String subject, String hobby, String food) {
        updateProfile(name, age, subject, hobby, food);
    }

    public void printInfo() {
        System.out.println("Profile's name: " + name);
        System.out.println("Profile's age: " + age);
        System.out.println("Profile's subject: " + subject);
        System.out.println("Profile's hobby: " + hobby);
        System.out.println("Profile's food: " + food);
        printCareer();
    }

    private void printCareer() {
        // subjects: math, history, science
        // hobbies: hiking, sleep
        // food: potato chips, steak
        if(subject.equals("math")) {
            if(hobby.equals("hiking")) {
                if(food.equals("potato chips")) {
                    System.out.println("Your career is: Interesting Wandering Mathematician and Pythagoras Quoter");
                }
                if(food.equals("steak")) {
                    System.out.println("Your career is: Yo Average Joe Schmo Wandering Mathematics Professor");
                }
            }
            if(hobby.equals("sleep")) {
                if(food.equals("potato chips")) {
                    System.out.println("Your career is: Unproductive Sedentary Programmer");
                }
                if(food.equals("steak")) {
                    System.out.println("Your career is: Narcoleptic Sophisticated Engineer");
                }
            }
        }
        if(subject.equals("history")) {
            if(hobby.equals("hiking")) {
                if(food.equals("potato chips")) {
                    System.out.println("Your career is: Amazingly Obese Local Historian and Chatter Box");
                }
                if(food.equals("steak")) {
                    System.out.println("Your career is: In-Shape and Shy Wandering Historian and Archaeologist");
                }
            }
            if(hobby.equals("sleep")) {
                if(food.equals("potato chips")) {
                    System.out.println("Your career is: Absolutely nothing. You are destined do die an unaccomplished individual");
                }
                if(food.equals("steak")) {
                    System.out.println("Your career is: Nocturnal Private Investigator or Grey-Hat Detective");
                }
            }
        }
        if(subject.equals("science")) {
            if(hobby.equals("hiking")) {
                if(food.equals("potato chips")) {
                    System.out.println("Your career is: Mad Scientist with a Food Obsession and Possibly Advanced Diabetes");
                }
                if(food.equals("steak")) {
                    System.out.println("Your career is: Wandering Estranged World Class Chef");
                }
            }
            if(hobby.equals("sleep")) {
                if(food.equals("potato chips")) {
                    System.out.println("Your career is: Mostly Dormant Cave Explorer and Spelunker");
                }
                if(food.equals("steak")) {
                    System.out.println("Your career is: Somehow Incredibly Lean and Mean Nocturnal Astrobiology and Bagpiping Professor at the University of Arctica");
                }
            }
        }
    }

    public void updateProfile(String name, int age, String subject, String hobby, String food) {
        this.name = name.toLowerCase();
        this.age = age;
        this.subject = subject.toLowerCase();
        this.hobby = hobby.toLowerCase();
        this.food = food.toLowerCase();
    }
}