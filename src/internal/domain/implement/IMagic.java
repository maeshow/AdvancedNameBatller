package internal.domain.implement;

import internal.domain.vo.MagicType;

public interface IMagic {

    String getName();

    void initMagic(String name, MagicType type, int needMagicPoint);

    int getNeedMagicPoint();

    MagicType getMagicType();

    void giveEffect(IPlayer user, IPlayer target);

    boolean canUseMagic(int magicPoint);
}
