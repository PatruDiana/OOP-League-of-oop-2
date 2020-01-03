package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class TheDoomer extends Angel implements VisitAngel {
    public TheDoomer(int coodx, int coordy) {
        super(coodx, coordy);
    }

    @Override
    public void visit(Pyromancer p) {
        p.setDeath();
    }

    @Override
    public void visit(Knight k) {
        k.setDeath();
    }

    @Override
    public void visit(Rogue r) {
        r.setDeath();
    }

    @Override
    public void visit(Wizard w) {
        w.setDeath();
    }

    public String getName() {
        return "TheDoomer";
    }

    @Override
    public String actionangel(heroes.Hero hero) {
        return getName()+ " hit " + hero.getName() + " "+ hero.getIndex();
    }
}
