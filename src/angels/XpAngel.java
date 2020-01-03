package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class XpAngel extends Angel implements VisitAngel {
    public XpAngel(int coodx, int coordy) {
        super(coodx, coordy);
    }

    @Override
    public void visit(Pyromancer p) {
        p.increaseXp(50);
    }

    @Override
    public void visit(Knight k) {
        k.increaseXp(45);
    }

    @Override
    public void visit(Rogue r) {
        r.increaseXp(40);
    }

    @Override
    public void visit(Wizard w) {
        w.increaseXp(60);
    }
    public String getName() {
        return "XPAngel";
    }

    @Override
    public String actionangel(heroes.Hero hero) {
        return getName()+ " helped " + hero.getName() + " "+ hero.getIndex();
    }
}
