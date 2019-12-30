package strategies;

import heroes.Hero;

public class DefensiveKnightStrategy implements Strategy {
    @Override
    public void changecoef(Hero hero) {
        for(int i = 0; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefDefensive(0.2f);
        }
        float life = 1f/4 * hero.getHpCurrent();
        hero.setHpCurrentStrategy(hero.getHpCurrent() + Math.round(life));
    }
}
