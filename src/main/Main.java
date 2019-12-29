package main;

public final class Main {
    private Main() {
        //for checkstyle
    }
    public static void main(final String[] args) {
        String input = "/home/diana/Desktop/leagueofoop2/src/checker/resources/in/fightKPV.in";
        String output = "/home/diana/Desktop/output.out";
        //GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInputLoader gameInputLoader = new GameInputLoader(input, output);
         gameInputLoader.load();
         Game game = Game.getInstance();
         game.createheroes();
         game.startgame();
//         game.printboard(args[0], args[1]);
         game.printboard(input, output);
    }
}
