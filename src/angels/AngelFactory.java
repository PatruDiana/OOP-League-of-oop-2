package angels;

public final class AngelFactory {
    public static angels.Angel getAngel(final String type, final int coordx, final int coordy) {
        if("DamageAngel".equalsIgnoreCase(type)) {
            return new DamageAngel(coordx, coordy);
        } else if("DarkAngel".equalsIgnoreCase(type)) {
            return new DarkAngel(coordx, coordy);
        } else if("Dracula".equalsIgnoreCase(type)) {
            return new Dracula(coordx, coordy);
        } else if("GoodBoy".equalsIgnoreCase(type)) {
            return new GoodBoy(coordx, coordy);
        } else if("LevelUpAngel".equalsIgnoreCase(type)) {
            return new LevelUpAngel(coordx, coordy);
        } else if("LifeGiver".equalsIgnoreCase(type)) {
            return new LifeGiver(coordx, coordy);
        } else if("SmallAngel".equalsIgnoreCase(type)) {
            return new SmallAngel(coordx, coordy);
        } else if("Spawner".equalsIgnoreCase(type)) {
            return new Spawner(coordx, coordy);
        } else if("TheDoomer".equalsIgnoreCase(type)) {
            return new TheDoomer(coordx, coordy);
        } else {
            return new XpAngel(coordx, coordy);
        }
    }
}
