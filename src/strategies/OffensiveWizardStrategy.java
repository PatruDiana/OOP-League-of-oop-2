package strategies;
import heroes.Hero;

public class OffensiveWizardStrategy implements Strategy{

    @Override
    public void changecoef(Hero hero){
        float life = 1f/10 * hero.getHpCurrent();
        hero.setHpCurrentStrategy(hero.getHpCurrent() - Math.round(life));
        for (int i = 0; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefOffensive(0.6f);
        }
    }
}
