package org.derryfield.toys;

public class Magic8Ball {
    private static String result;

    public Magic8Ball() {
        
    }

    public static void shake() {
        int randomNum = (int) (Math.random() * 20);
        result = switch (randomNum) {
            case 0 -> "It is certain";
            case 1 -> "It is decidely so";
            case 2 -> "Without a doubt";
            case 3 -> "Yes definitely";
            case 4 -> "You may rely on it";
            case 5 -> "As I see it, yes";
            case 6 -> "Most likely";
            case 7 -> "Outlook good";
            case 8 -> "Yes";
            case 9 -> "Signs point to yes";
            case 10 -> "Reply hazy, try again";
            case 11 -> "Ask again later";
            case 12 -> "Better not tell you now";
            case 13 -> "Cannot predict now";
            case 14 -> "Concentrate and ask again";
            case 15 -> "Don't count on it";
            case 16 -> "My reply is no";
            case 17 -> "My sources say no";
            case 18 -> "Outlook not so good";
            case 19 -> "Very doubtful";
            default -> "It is certain";
        };
        System.out.print(result);
    }

}