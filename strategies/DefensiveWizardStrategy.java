package strategies;

import heroes.Hero;
import common.Constants;
public class DefensiveWizardStrategy implements Strategy {
    /**
     * if the hero choose to play defensive.
     * @param hero - a Wizard hero.
     */
    public void changecoef(final Hero hero) {
        for (int i = 0; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefDefensive(Constants.WIZARD_DEF);
        }
        float life = Constants.WIZARD_LIFE_DEF * hero.getHpCurrent();
        hero.setHpCurrentStrategy(hero.getHpCurrent() + Math.round(life));
    }
}
