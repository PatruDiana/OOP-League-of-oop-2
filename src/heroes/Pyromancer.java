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
        hpMax += common.Constants.EXTRA_HP_PYROMANCER;
        hp = hpMax;
        hpCurrent = hpMax;
    }
    public void setTheStrategy(){
        if(1f/4 * getHpMax() < hpCurrent & hpCurrent < 1f/3 * getHpMax()) {
            strategy = new OffensivePyromancerStrategy();
            strategy.changecoef(this);
        } else if (hpCurrent <= 1f/4 * getHpMax()) {
            strategy = new DefensivePyromancerStrategy();
            strategy.changecoef(this);
        }
    }

    @Override
    public String getName() {
        return "Pyromancer";
    }
    @Override
    public void acceptangel(angels.VisitAngel a) {
        a.visit(this);
    }
}
