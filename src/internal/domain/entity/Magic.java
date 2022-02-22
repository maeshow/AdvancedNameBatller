package internal.domain.entity;

import internal.domain.implement.IMagic;
import internal.domain.implement.IPlayer;
import internal.domain.vo.MagicType;

public class Magic implements IMagic {

    protected String name;
    protected MagicType type;
    protected int needMagicPoint;

    public Magic() {
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void initMagic(String name, MagicType type, int needMagicPoint) {
        this.name = name;
        this.type = type;
        this.needMagicPoint = needMagicPoint;
    }

    @Override
    public int getNeedMagicPoint() {
        return needMagicPoint;
    }

    @Override
    public MagicType getMagicType() {
        return type;
    }

    @Override
    public void giveEffect(IPlayer user, IPlayer target) {
    }

    @Override
    public boolean canUseMagic(int magicPoint) {
        return this.needMagicPoint < magicPoint;
    }
}
