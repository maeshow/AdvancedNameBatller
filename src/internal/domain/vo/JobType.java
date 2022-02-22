package internal.domain.vo;

public enum JobType {
    FIGHTER(100, 300, 0, 0, 30, 100, 30, 100, 1, 100, 1, 50),
    WIZARD(50, 150, 30, 80, 1, 50, 1, 50, 1, 100, 20, 60),
    PRIEST(80, 200, 20, 50, 10, 70, 10, 70, 1, 100, 20, 60),
    ASSASSIN(50, 150, 20, 50, 30, 80, 1, 25, 1, 100, 50, 100),;

    private int minHitPoint;
    private int maxHitPoint;
    private int minMagicPoint;
    private int maxMagicPoint;
    private int minStrength;
    private int maxStrength;
    private int minDefence;
    private int maxDefence;
    private int minLuck;
    private int maxLuck;
    private int minAgilty;
    private int maxAgility;

    private JobType(
            final int minHitPoint,
            final int maxHitPoint,
            final int minMagicPoint,
            final int maxMagicPoint,
            final int minStrength,
            final int maxStrength,
            final int minDefence,
            final int maxDefence,
            final int minLuck,
            final int maxLuck,
            final int minAgility,
            final int maxAgility) {
        this.minHitPoint = minHitPoint;
        this.maxHitPoint = maxHitPoint;
        this.minMagicPoint = minMagicPoint;
        this.maxMagicPoint = maxMagicPoint;
        this.minStrength = minStrength;
        this.maxStrength = maxStrength;
        this.minDefence = minDefence;
        this.maxDefence = maxDefence;
        this.minLuck = minLuck;
        this.maxLuck = maxLuck;
        this.minAgilty = minAgility;
        this.maxAgility = maxAgility;
    }

    public int minHitPoint() {
        return minHitPoint;
    }

    public int maxHitPoint() {
        return maxHitPoint;
    }

    public int minMagicPoint() {
        return minMagicPoint;
    }

    public int maxMagicPoint() {
        return maxMagicPoint;
    }

    public int minStrength() {
        return minStrength;
    }

    public int maxStrength() {
        return maxStrength;
    }

    public int minDefence() {
        return minDefence;
    }

    public int maxDefence() {
        return maxDefence;
    }

    public int minLuck() {
        return minLuck;
    }

    public int maxLuck() {
        return maxLuck;
    }

    public int minAgility() {
        return minAgilty;
    }

    public int maxAgility() {
        return maxAgility;
    }
}
