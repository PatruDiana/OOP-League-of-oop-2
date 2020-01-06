package heroes;

import abilities.Visitor;
import common.Constants;
import abilities.AbilitiesFactory;
import strategies.DefensivePyromancerStrategy;
import strategies.OffensivePyromancerStrategy;

public class Pyromancer extends Hero {
    Pyromancer(final int row, final int col, final int index) {
        this.row = row;
        this.col = col;
        this.hp = Constants.HP_PYROMANCER;
        this.type = "P";
        this.abilities = AbilitiesFactory.getAbilities(type);
        this.freeze = false;
        this.death = false;
        this.hpCurrent = Constants.HP_PYROMANCER;
        this.hpMax = Constants.HP_PYROMANCER;
        this.index = index;
        this.levelup = false;
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
        hpMax += Constants.EXTRA_HP_PYROMANCER;
        hp = hpMax;
        hpCurrent = hpMax;
    }

    /**
     *  set the player's strategy.
     */
    public void setTheStrategy() {
        if (Constants.PYROMANCER_STRATEGY1 * getHpMax() < hpCurrent
                && hpCurrent < Constants.PYROMANCER_STRATEGY2 * getHpMax()) {
            strategy = new OffensivePyromancerStrategy();
            strategy.changecoef(this);
        } else if (hpCurrent <= Constants.PYROMANCER_STRATEGY1 * getHpMax()) {
            strategy = new DefensivePyromancerStrategy();
            strategy.changecoef(this);
        }
    }

    /**
     * @return the name of hero.
     */
    public String getName() {
        return "Pyromancer";
    }

    /**
     * requires the visitor angel to visit the current hero.
     * @param a
     */
    public void acceptangel(final angels.VisitAngel a) {
        a.visit(this);
    }
}
