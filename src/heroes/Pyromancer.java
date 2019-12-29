package heroes;

import abilities.Visitor;
import common.Constants;
import abilities.AbilitiesFactory;

public class Pyromancer extends Hero {
    Pyromancer(final int row, final int col) {
        this.row = row;
        this.col = col;
        this.hp = Constants.HP_PYROMANCER;
        this.type = "P";
        this.abilities = AbilitiesFactory.getAbilities(type);
        this.freeze = false;
        this.death = false;
        this.hpCurrent = Constants.HP_PYROMANCER;
        this.hpmax = Constants.HP_PYROMANCER;
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
        hpmax += common.Constants.EXTRA_HP_PYROMANCER;
        hp = hpmax;
        hpCurrent = hpmax;
    }
}
