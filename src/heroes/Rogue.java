package heroes;

import abilities.Visitor;
import common.Constants;
import abilities.AbilitiesFactory;
import strategies.DefensiveRogueStrategy;
import strategies.OffensiveRogueStrategy;


public class Rogue extends Hero {
    Rogue(final int row, final int col, final int index) {
        this.row = row;
        this.col = col;
        this.hp = Constants.HP_ROQUE;
        this.type = "R";
        this.abilities = AbilitiesFactory.getAbilities(type);
        this.freeze = false;
        this.death = false;
        this.hpCurrent = Constants.HP_ROQUE;
        this.hpMax = Constants.HP_ROQUE;
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
        hpMax += common.Constants.EXTRA_HP_ROGUE;
        hp = hpMax;
        hpCurrent = hpMax;
    }


    public void setTheStrategy() {
        if(1f/7* getHpMax() < hpCurrent && hpCurrent < 1f/5 * getHpMax()) {
            strategy = new OffensiveRogueStrategy();
            strategy.changecoef(this);
        } else if (hpCurrent <= 1f/7 * getHpMax()) {
            strategy = new DefensiveRogueStrategy();
            strategy.changecoef(this);
        }
    }

    @Override
    public String getName() {
        return "Rogue";
    }

    @Override
    public void acceptangel(angels.VisitAngel a) {
        a.visit(this);
    }
}
