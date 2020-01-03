package heroes;

import abilities.Visitor;
import common.Constants;
import abilities.AbilitiesFactory;
import strategies.DefensiveKnightStrategy;
import strategies.OffensiveKnightStrategy;


public class Knight extends Hero {
    Knight(final int row, final int col, final int index) {
        this.row = row;
        this.col = col;
        this.hp = Constants.HP_KNIGHT;
        this.type = "K";
        this.abilities = AbilitiesFactory.getAbilities(type);
        this.freeze = false;
        this.death = false;
        this.hpCurrent = Constants.HP_KNIGHT;
        this.hpMax = Constants.HP_KNIGHT;
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
        hpMax += common.Constants.EXTRA_HP_KNIGHT;
        hp = hpMax;
        hpCurrent = hpMax;
    }


    public void setTheStrategy() {
        if(1f/3 * getHpMax() < hpCurrent && hpCurrent < 1f/2* getHpMax()) {
           strategy = new OffensiveKnightStrategy();
            strategy.changecoef(this);
        } else if (hpCurrent <= 1f/3 * getHpMax()) {
            strategy = new DefensiveKnightStrategy();
            strategy.changecoef(this);
        }
    }

    @Override
    public String getName() {
        return "Knight";
    }

    public void acceptangel(angels.VisitAngel a) {
            a.visit(this);
    }
}
