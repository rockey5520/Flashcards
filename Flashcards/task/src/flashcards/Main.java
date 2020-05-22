package flashcards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Card> cards = new ArrayList<>();
        System.out.println("Input the number of cards:");
        int numberOfCards = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfCards ; i++) {
            System.out.println("The card #"+i+":");
            String term = scanner.nextLine();
            System.out.println("The definition of the card #"+i+":");
            String definition = scanner.nextLine();
            Card card = new Card(term,definition);
            cards.add(card);
        }

        for (Card card: cards
        ) {
            System.out.println("Print the definition of \""+card.getTerm()+"\":");
            String response = scanner.nextLine();
            if(card.getDefintion().equals(response)){
                System.out.println("Correct answer.");
            }else{
                System.out.println("Wrong answer. The correct one is \""+card.getDefintion()+"\".");
            }
        }
    }
}

class Card{
    String term;
    String defintion;
    String answer;

    @Override
    public String toString() {
        return "Card{" +
            "term='" + term + '\'' +
            ", defintion='" + defintion + '\'' +
            ", answer='" + answer + '\'' +
            '}';
    }

    public Card(String term, String defintion) {
        this.term = term;
        this.defintion = defintion;
        this.answer = answer;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefintion() {
        return defintion;
    }

    public void setDefintion(String defintion) {
        this.defintion = defintion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
