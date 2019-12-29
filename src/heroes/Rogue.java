package heroes;

import abilities.Visitor;
import common.Constants;
import abilities.AbilitiesFactory;


public class Rogue extends Hero {
    Rogue(final int row, final int col) {
        this.row = row;
        this.col = col;
        this.hp = Constants.HP_ROQUE;
        this.type = "R";
        this.abilities = AbilitiesFactory.getAbilities(type);
        this.freeze = false;
        this.death = false;
        this.hpCurrent = Constants.HP_ROQUE;
        this.hpmax = Constants.HP_ROQUE;
    }

    /**
     * requires the visitor to visit the current hero.
     * @param v
     */
    public void accept(final Visitor v) {
        v.visit(this);
    }

    /**
     * set the maximum hp with the level update.
     */
    public void setHPmax() {
        hpmax += common.Constants.EXTRA_HP_ROGUE;
        hp = hpmax;
        hpCurrent = hpmax;
    }
}
