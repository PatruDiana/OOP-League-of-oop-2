package strategies;
import heroes.Hero;
import common.Constants;
public class OffensiveWizardStrategy implements Strategy {
    /**
     * if the hero choose to play offensive.
     * @param hero - a Wizard hero.
     */
    public void changecoef(final Hero hero) {
        float life = Constants.WIZARD_LIFE_OFF * hero.getHpCurrent();
        hero.setHpCurrentStrategy(hero.getHpCurrent() - Math.round(life));
        for (int i = 0; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefOffensive(Constants.WIZARD_OFF);
        }
    }
}
