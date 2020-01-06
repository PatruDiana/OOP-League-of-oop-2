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

    /**
     *  set the player's strategy.
     */
    public void setTheStrategy() {
        if (Constants.WIZARD_STRATEGY1 * getHpMax() < hpCurrent
                && hpCurrent < Constants.WIZARD_STRATEGY2 * getHpMax()) {
            strategy = new OffensiveWizardStrategy();
            strategy.changecoef(this);
        } else if (hpCurrent <= Constants.WIZARD_STRATEGY1 * getHpMax()) {
            strategy = new DefensiveWizardStrategy();
            strategy.changecoef(this);
        }
    }

    /**
     * @return the name of hero.
     */
    public String getName() {
        return "Wizard";
    }

    /**
     * requires the visitor angel to visit the current hero.
     * @param a
     */
    public void acceptangel(final angels.VisitAngel a) {
        a.visit(this);
    }
}
