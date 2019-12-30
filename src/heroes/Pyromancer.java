package heroes;

import abilities.Visitor;
import common.Constants;
import abilities.AbilitiesFactory;
import strategies.DefensivePyromancerStrategy;
import strategies.OffensivePyromancerStrategy;

public class Pyromancer extends Hero {
    private float ROGUE_MODIFICATOR_F = 0.8f;
    private float KNIGHT_MODIFICATOR_F = 1.2f;
    private float PYROMANCER_MODIFICATOR_F = 0.9f;
    private float WIZARD_MODIFICATOR_F = 1.05f;
    Pyromancer(final int row, final int col) {
        this.row = row;
        this.col = col;
        this.hp = Constants.HP_PYROMANCER;
        this.type = "P";
        this.abilities = AbilitiesFactory.getAbilities(type);
        this.freeze = false;
        this.death = false;
        this.hpCurrent = Constants.HP_PYROMANCER;
        this.hpMax = Constants.HP_PYROMANCER;
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
}
