package heroes;

import abilities.Visitor;
import common.Constants;
import abilities.AbilitiesFactory;
import strategies.DefensiveWizardStrategy;
import strategies.OffensiveWizardStrategy;


public class Wizard extends Hero {
    Wizard(final int row, final int col, final int index) {
        this.row = row;
        this.col = col;
        this.hp = Constants.HP_WIZARD;
        this.type = "W";
        this.abilities = AbilitiesFactory.getAbilities(type);
        this.freeze = false;
        this.death = false;
        this.hpCurrent = Constants.HP_WIZARD;
        this.hpMax = Constants.HP_WIZARD;
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
        hpMax += common.Constants.EXTRA_HP_WIZARD;
        hp = hpMax;
        hpCurrent = hpMax;
    }

    public void setTheStrategy(){
        if(1f/4 * getHpMax() < hpCurrent && hpCurrent < 1f/2 * getHpMax()) {
            strategy = new OffensiveWizardStrategy();
            strategy.changecoef(this);
        } else if ( hpCurrent <= 1f/4 * getHpMax()) {
            strategy = new DefensiveWizardStrategy();
            strategy.changecoef(this);
        }
    }

    @Override
    public String getName() {
        return "Wizard";
    }

    @Override
    public void acceptangel(angels.VisitAngel a) {
        a.visit(this);
    }
}
