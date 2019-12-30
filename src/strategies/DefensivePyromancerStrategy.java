package strategies;

import heroes.Hero;

public class DefensivePyromancerStrategy implements Strategy {
    @Override
    public void changecoef(Hero hero) {
        for(int i = 0; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefDefensive(0.3f);
        }
        float life = 1f/3 * hero.getHpCurrent();
        hero.setHpCurrentStrategy(Math.round(life) + hero.getHpCurrent());
    }
}
