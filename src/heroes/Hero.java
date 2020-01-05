package heroes;

import abilities.Abilities;
import common.Constants;
import strategies.Strategy;

import java.util.ArrayList;

public abstract class Hero implements Visitable, angels.VisitableAngel {
    protected int row;
    protected int col;
    protected String type;
    protected int level = 0;
    protected int xp = 0;
    protected int hpMax;
    protected int hp;
    protected int damageRec;
    protected ArrayList<Abilities> abilities;
    protected int nrRoundOvertime;
    protected int damageOvertime;
    protected boolean freeze;
    protected boolean death;
    protected int hpCurrent;
    protected Strategy strategy;
    protected int index;
    protected java.util.List<magician.Observer> observer = new java.util.ArrayList<>();
    protected boolean levelup;
    /**
     * function in which each player moves properly on the map if it is not frozen.
     * @param move - the movement he must perform.
     */
    public void setMove(final Character move) {
        if (!freeze) {
            if (move != '_') {
                if (move == 'U') {
                    this.row--;
                } else if (move == 'D') {
                    this.row++;
                } else if (move == 'L') {
                    this.col--;
                } else {
                    this.col++;
                }
            }
        }
    }

    /**
     * @return if the player si death or not.
     */
    public boolean getDeath() {
        return death;
    }
    /**
     * @return the coordinate of the column in which it is at the given moment.
     */
    public int getCol() {
        return this.col;
    }

    /**
     *
     * @return the coordinate of the row in which it is at the given moment.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * @return the list of abilities assigned to each hero.
     */
    public ArrayList<Abilities> getAbilities() {
        return this.abilities;
    }

    /**
     * @param life - set the current hp after strategy.
     */
    public void setHpCurrentStrategy(final int life) {
        this.hpCurrent = life;
    }

    /**
     * set the current hp during a fight.
     * @param damage - the damage received by an opponent
     */
    public void setHpCurrent(final int damage) {
        this.hpCurrent -= damage;
        if (hpCurrent <=  0) {
            setDeath();
        }
    }

    /**
      * @param newdamageOvertime - new damage received overtime received by the opponent.
     * @param newnrRoundOvertime - new number of rounds of damage overtime.
     * @param newfreeze - if the new damage overtime has the option to freeze the hero.
     */
    public void setDamageOvertime(final int newdamageOvertime, final int newnrRoundOvertime,
                                  final boolean newfreeze) {
        this.damageOvertime = newdamageOvertime;
        this.nrRoundOvertime = newnrRoundOvertime + 1;
        this.freeze = newfreeze;
    }
    /**
     * applying for overtime damage at the beginning of each round.
     */
    public void damageOvertime() {
        if (nrRoundOvertime != 0) {
            hp -= damageOvertime;
            hpCurrent = hp;
//            nrRoundOvertime--;
//            if (nrRoundOvertime == 0 && freeze) {
//                freeze = false;
//            }
            // declaring the player dead
            if (hp <= 0) {
                setDeath();
            }
        }
    }

    /**
     * setting the hp with the current one at the end of each fight.
     */
    public void setHP() {
        hp = hpCurrent;
        if (hp <= 0) {
            setDeath();
        }
    }

    /**
     * @return the current hp of each player.
     */
    public int getHpCurrent() {
        return hpCurrent;
    }

    /**
     * @return the hp of each player.
     */
    public int getHp() {
        return hp;
    }

    /**
     * @return the type of hero of each player.
     */
    public String getType() {
        return type;
    }

    /**
     * applying the list of abilities to a hero.
     * @param a - list of abilities
     */
    public void fight(final ArrayList<Abilities> a) {
        for (int i = 0; i < a.size(); i++) {

            accept(a.get(i));
        }
    }

    /**
     * reset the Wizard player's overtime damage after each fight.
     */
    public void resetDamageRec() {
        damageRec = 0;
    }

    /**
     * check if the hero is alive.
     * @return
     */
    public boolean isDeath() {
        return death;
    }

    /**
     * setting the player when he dies.
     */
    public void setDeath() {
        this.death = true;
    }

    /**
     * set the player alive.
     */
    public void setAlive() {
        this.death = false;
    }
    /**
     * updating the XP when the player wins a fight.
     * @param lvl - the level of loser hero.
     */
    public void setXp(final int lvl) {
            xp += Math.max(0, Constants.MAX_XP - (level - lvl) * Constants.MULTIPLIER_XP);
            updatelevel();
    }

    /**
     * @return the player's xp.
     */
    public int getXp() {
        return xp;
    }

    /**
     * increase the xp after angel's action.
     * @param exp - the value with which xp is increased.
     */
    public void increaseXp(final int exp) {
        this.xp += exp;
        updatelevel();
    }

    /**
     * set the player's strategy.
     * @param strategy - the strategy chosen.
     */
    public void setStrategy(final strategies.Strategy strategy) {
        this.strategy = strategy;
    }

    /***
     * updates the hero level after each fight if he has enough Xp.
     */
    public void updatelevel() {
        while (xp >= level * Constants.XP_UPDATE_LEVEL + Constants.XP_MIN_LEVEL) {
            level++;
            levelup = true;
            // setting Hp to maximum
            setHPmax();
            // automatically update the base damage of each ability
            for (int i = 0; i < abilities.size(); i++) {
                abilities.get(i).setDamage();
            }
        }
    }

    /**
     * @return the level of each player.
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return the information required for each player
     */
    public String toString() {
        if (death) {
            return type + " " + "dead";
        } else {
            return type + " " + level + " " + xp + " " + hp + " " + row + " " + col;
        }
    }

    /**
     * sets the damage received by the opponent to the Wizard hero.
     * @param damageRec - the damage received.
     */
    public void setDamageRec(final int damageRec) {
        this.damageRec += damageRec;
    }

    /**
     * @return - the damage received.
     */
    public int getDamageRec() {
        return this.damageRec;
    }
    /**
     * set the maximum hp with the level update.
     *  The method will be overwritten by each hero.
     */
    public void setHPmax() { }
    /**
     * @return - the hp max at the level current
     */
    public int getHpMax() {
        return hpMax;
    }
    public abstract void setTheStrategy();

    /**
     * @return if the player is frozen or not.
     */
    public boolean isFreeze() {
        return freeze;
    }
    public abstract String getName();

    /**
     * @return the String for output file with the appropiate message when a hero dies.
     */
    public String herodied() {
        return observer.get(0).update();
    }

    /**
     * add one observer at the list with observers.
     * @param oneobserver - one of the observers.
     */
    public void addObservers(final magician.Observer oneobserver) {
        this.observer.add(oneobserver);
    }

    /**
     * @return if the player levels up.
     */
    public boolean isLevelup() {
        return levelup;
    }

    /**
     * set true or false if the player levels up.
     * @param lvl - true or false.
     */
    public void setLevelup(final boolean lvl) {
        this.levelup = lvl;
    }

    /**
     * @return the String for output file with the appropiate message when a hero levels up.
     */
    public String herolevelup() {
        setLevelup(false);
        return observer.get(1).update();
    }

    /**
     * @return the player's index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return the String for output file with the appropiate message when a hero dies by an angel.
     */
    public String isdeadbyangel() {
        return observer.get(2).update();
    }

    /**
     * @return the String for output file with the appropiate message when a hero is
     * alive by an angel.
     */
    public String alivebyangel() {
        return observer.get(Constants.OBSERVER_ALIVEBYANGEL).update();
    }

    /**
     * verify is the player has more rounds of freeze.
     */
    public void verifyisfreeze() {
        if (nrRoundOvertime != 0) {
            nrRoundOvertime--;
            if (nrRoundOvertime == 0 && freeze) {
                freeze = false;
            }
        }
    }

    /**
     * @param lvl - the intermediare level.
     * @return the String for output file with the appropiate message when a hero levels up.
     */
    public String levelupintermediar(final int lvl) {
        return observer.get(Constants.OBSERVER_LEVELUP).update() + " " + lvl;
    }
}
