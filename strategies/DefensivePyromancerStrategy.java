package strategies;

import heroes.Hero;
import common.Constants;
public class DefensivePyromancerStrategy implements Strategy {
    /**
     * if the hero choose to play defensive.
     * @param hero - Pyromancer hero
     */
    public void changecoef(final Hero hero) {
        for (int i = 0; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefDefensive(Constants.PYROMANCER_DEF);
        }
        float life = Constants.PYROMANCER_LIFE_DEF * hero.getHpCurrent();
        hero.setHpCurrentStrategy(Math.round(life) + hero.getHpCurrent());
    }
}
