package main;

public final class Main {
    private Main() {
        //for checkstyle
    }
    public static void main(final String[] args) throws java.io.IOException {
//        String input = "/home/diana/Desktop/leagueofoop2/src/checker/resources/in/fightKWW.in";
//        String output = "/home/diana/Desktop/output.out";
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
//        GameInputLoader gameInputLoader = new GameInputLoader(input, output);
         gameInputLoader.load();
         Game game = Game.getInstance();
         game.createheroes();
//         game.writeinfile(input, output);
        game.writeinfile(args[0], args[1]);
//         game.startgame(input, output);
         game.startgame(args[0], args[1]);
         game.printboard(args[0], args[1]);
//         game.printboard(input, output);
    }

    public static void main(String[] args) {

    }
}
