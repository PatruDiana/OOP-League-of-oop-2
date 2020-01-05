package main;

import java.util.ArrayList;

import fileio.FileSystem;

public class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    /**
     * reading input data and organizing them.
     */
    public void load() {
        int nrRows = 0, nrCols = 0, nrHeroes = 0, nrRounds = 0;
        ArrayList<String> playersinfo = new ArrayList<>();
        ArrayList<Integer> coordplayers = new ArrayList<>();
        ArrayList<Character> arraymoves = new ArrayList<>();
        ArrayList<Integer> nrroundsangels = new ArrayList<>();
        ArrayList<String> angelsinfo = new ArrayList<>();
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            nrRows = fs.nextInt();
            nrCols = fs.nextInt();
            map.Mapworld mapworld = map.Mapworld.getInstance(nrRows, nrCols);

            for (int i = 0; i < nrRows; i++) {
                mapworld.setLocation(fs.nextWord(), i);
            }
            nrHeroes = fs.nextInt();
            for (int i = 0; i < nrHeroes; i++) {
                playersinfo.add(fs.nextWord());
                coordplayers.add(fs.nextInt());
                coordplayers.add(fs.nextInt());
            }
            nrRounds = fs.nextInt();
            for (int i = 0; i < nrRounds; i++) {
                String lineMoves = fs.nextWord();
                char[] moves = lineMoves.toCharArray();
                for (char c : moves) {
                    arraymoves.add(c);
                }
            }
            for (int i = 0; i < nrRounds; i++) {
                int round = fs.nextInt();
                for (int j = 0; j < round; j++) {
                    String info = fs.nextWord();
                    angelsinfo.add(info);
                }
                nrroundsangels.add(round);
            }


          fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
         Game game = Game.getInstance(playersinfo, coordplayers, arraymoves,
                 nrRounds, nrroundsangels, angelsinfo);
    }

}
