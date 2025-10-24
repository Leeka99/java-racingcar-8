package racingcar.util.random;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements RandomNumber{
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0,9);
    }
}
