package main;
import fileio.FileSystem;
import heroes.Hero;
import heroes.HeroFactory;
import java.util.ArrayList;
import angels.Angel;
import angels.AngelFactory;
import magician.ActionAngel;
import magician.AppearAngel;

public final class Game {
    private static Game instance = null;
    private ArrayList<Hero> heroes;
    private ArrayList<String> playersinfo;
    private ArrayList<Integer> coordplayers;
    private ArrayList<Character> arraymoves;
    private ArrayList<Integer> nrroundsangel;
    private ArrayList<String> angelsinfo;
    private ArrayList<Angel>  angels;
    private int rounds;
    private fileio.FileSystem fs;

    private Game(final ArrayList<String> playersinfo, final ArrayList<Integer> coordplayers,
                final ArrayList<Character> arraymoves, final int rounds, final ArrayList<Integer> nrroundsangel,
                 final ArrayList<String> angelsinfo) {
        this.playersinfo = playersinfo;
        this.heroes = new ArrayList<>(playersinfo.size());
        this.arraymoves = arraymoves;
        this.coordplayers = coordplayers;
        this.nrroundsangel = nrroundsangel;
        this.angelsinfo = angelsinfo;
        this.rounds = rounds;
        this.angels = new ArrayList<>();
    }

    static Game getInstance(final ArrayList<String> playersinfo,
                            final ArrayList<Integer> coordplayers,
                            final ArrayList<Character> arraymoves, final int rounds, final ArrayList<Integer> nrroundsangel,
                            final ArrayList<String> angelsinfo){
        instance = new Game(playersinfo, coordplayers, arraymoves, rounds, nrroundsangel, angelsinfo);
        return instance;
    }

    static Game getInstance() {
        return instance;
    }

    /**
     * create the heroes with the initial position.
     */
    public void createheroes() {
        int coord1 = 0;
        int coord2 = 1;
        for (int i = 0; i < playersinfo.size(); i++) {
            magician.DieHerobyHero dieHerobyHero = new magician.DieHerobyHero();
            magician.LevelUpHero levelUpHero = new magician.LevelUpHero();
            magician.DieHerobyAngel dieHerobyAngel = new magician.DieHerobyAngel();
            magician.AliveByAngel aliveByAngel = new magician.AliveByAngel();
            magician.LevelUpIntermediarHero levelUpIntermediarHero = new magician.LevelUpIntermediarHero();
            Hero hero = HeroFactory.getHero(playersinfo.get(i),
                    coordplayers.get(coord1), coordplayers.get(coord2), i);
            heroes.add(hero);
            dieHerobyHero.addhero(heroes.get(i));
            levelUpHero.addhero(heroes.get(i));
            dieHerobyAngel.addhero(heroes.get(i));
            aliveByAngel.addhero(heroes.get(i));
            levelUpIntermediarHero.addhero(heroes.get(i));
            coord1 = coord1 + 2;
            coord2 = coord1 + 1;
        }
    }
    public void writeinfile(final String input, final String output) throws java.io.IOException {
        fs = new FileSystem(input, output);

    }
    /**
     * conducting the game itself.
     */
    public void startgame() throws java.io.IOException {
        int indexangels = 0;
        for (int i = 0; i < rounds; i++) {
            int nrround = i + 1;
            System.out.println( "~~ Round " + nrround + " ~~");
            fs.writeWord("~~ Round " + nrround + " ~~");
            fs.writeNewLine();

            // each player moves properly on the map if it is not frozen.
            for (heroes.Hero value : heroes) {
                Character move = arraymoves.get(0);
                value.setMove(move);
                arraymoves.remove(0);
            }
            // applying for overtime damage at the beginning of each round.
            for (heroes.Hero value : heroes) {
                value.damageOvertime();
            }
            // set the strategy of each player
            for (heroes.Hero value : heroes) {
                if (!value.isFreeze()) {
                    value.setTheStrategy();
                }
            }
            for (int j = 0; j < heroes.size(); j++) {
                for (int k = j + 1; k < heroes.size(); k++) {
                    // finding the opponent
                    if (heroes.get(j).getRow() == heroes.get(k).getRow()
                            && heroes.get(j).getCol() == heroes.get(k).getCol()) {
                        // checking if the two players can fight
                        if (!heroes.get(j).isDeath() && !heroes.get(k).isDeath()) {
                            // if the wizard player is the first, the opponent must attack first
                            // to set the damage received
                            if (heroes.get(j).getType().equals("W")) {
                                heroes.get(j).fight(heroes.get(k).getAbilities());
                                // set the damage received to Deflect ability
                                heroes.get(j).getAbilities().get(1).
                                        setDamagereceived(heroes.get(j).getDamageRec());
                                heroes.get(k).fight(heroes.get(j).getAbilities());
                            } else {
                                System.out.println(heroes.get(j).getAbilities().toString());
                                heroes.get(k).fight(heroes.get(j).getAbilities());
                                // check if the hero is a Wizard
                                if (heroes.get(k).getType().equals("W")) {

                                    // set the damage received to Deflect ability
                                    heroes.get(k).getAbilities().get(1).
                                            setDamagereceived(heroes.get(k).getDamageRec());
                                }
                                heroes.get(j).fight(heroes.get(k).getAbilities());

                             }
                            // setting the hp of the 2 players with the current one
                            heroes.get(j).setHP();
                            heroes.get(k).setHP();
                            // if he won the fight, assign the appropriate xp
                            if (heroes.get(k).isDeath()) {
                                String string1 = heroes.get(k).herodied();
                                fs.writeWord(string1 + heroes.get(j).getName() + " " + heroes.get(j).getIndex());
                                fs.writeNewLine();

                            }
                            if (heroes.get(j).isDeath()) {
                                String string1 = heroes.get(j).herodied();
                                fs.writeWord(string1 + heroes.get(k).getName() + " " + heroes.get(k).getIndex());
                                fs.writeNewLine();

                            }
                            if (!heroes.get(k).isDeath() && heroes.get(j).isDeath()) {
                                int level = heroes.get(k).getLevel();
                                heroes.get(k).setXp(heroes.get(j).getLevel());
                                if (heroes.get(k).getLevel() > level) {
                                    for (int m = level + 1; m <= heroes.get(k).getLevel(); m++) {
                                        fs.writeWord(heroes.get(k).levelupintermediar(m));
                                        fs.writeNewLine();
                                    }
                                    heroes.get(k).setLevelup(false);
                                }
                            } else if (heroes.get(k).isDeath() && !heroes.get(j).isDeath()) {
                                int level = heroes.get(j).getLevel();
                                heroes.get(j).setXp(heroes.get(k).getLevel());
                                if (heroes.get(j).getLevel() > level) {
                                    for (int m = level + 1; m <= heroes.get(j).getLevel(); m++) {
                                        fs.writeWord(heroes.get(j).levelupintermediar(m));
                                        fs.writeNewLine();
                                    }
                                    heroes.get(j).setLevelup(false);
                                }
                            }
                        }
                    }
                }
            }
            for (heroes.Hero value : heroes) {
                // reset the heroes.Wizard player's overtime damage after each fight.
                if (value.getType().equals("W")) {
                    value.resetDamageRec();
                }
            }
            for(int j = 0; j < nrroundsangel.get(i); j++) {
                String infoangel = angelsinfo.get(indexangels);
                String[] arrOfStr = infoangel.split(",");
                int coordx = Integer.parseInt(arrOfStr[1]);
                int coordy = Integer.parseInt(arrOfStr[2]);
                Angel angel = AngelFactory.getAngel(arrOfStr[0], coordx, coordy);
                angels.add(angel);
                indexangels++;
            }
            for (Angel angel : angels) {
                 AppearAngel appearAngel = new AppearAngel();
                 ActionAngel actionAngel = new ActionAngel();
                 appearAngel.addangel(angel);
                 actionAngel.addangel(angel);
            }
            for (Angel angel : angels) {
                fs.writeWord(angel.appear());
                fs.writeNewLine();
                for (Hero hero : heroes) {
                    if (hero.getRow() == angel.getCoodx() &&
                            hero.getCol() == angel.getCoordy()) {
                        if (!hero.getDeath() || angel.getName().equals("Spawner")) {
                            int level = hero.getLevel();
                            if(!angel.getName().equals("Spawner")) {
                                fs.writeWord(angel.actionangel(hero));
                                fs.writeNewLine();
                                hero.acceptangel(angel);
                            } else {
                              if (hero.getDeath()) {
                                  fs.writeWord(angel.actionangel(hero));
                                  fs.writeNewLine();
                                  hero.acceptangel(angel);
                                  fs.writeWord(hero.alivebyangel());
                                  fs.writeNewLine();
                              }
                            }
                            if (hero.isLevelup()) {
                                for (int k = level + 1; k < hero.getLevel(); k++) {
                                    fs.writeWord(hero.levelupintermediar(k));
                                    fs.writeNewLine();
                                }
                                fs.writeWord(hero.herolevelup());
                                fs.writeNewLine();
                                hero.setLevelup(false);
                            }
                            if (hero.isDeath()) {
                                fs.writeWord(hero.isdeadbyangel());
                                fs.writeNewLine();
                            }
                        }
                    }
                }
            }
            for (Hero hero : heroes) {
                hero.setHP();
            }
            // delete list of angels
            if (angels.size() > 0) {
                angels.subList(0, angels.size()).clear();
            }
            fs.writeNewLine();
            for (Hero  hero : heroes) {
                hero.verifyisfreeze();
            }
        }
    }

    /**
     * print the final broad game.
     * @param input - file input
     * @param output - file output
     */
    public void printboard(final String input, final String output) {
        try {
            fs.writeWord("~~ Results ~~");
            fs.writeNewLine();
            for (heroes.Hero hero : heroes) {
                fs.writeWord(hero.toString());
                fs.writeNewLine();
            }
            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
