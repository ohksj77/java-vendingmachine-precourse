package vendingmachine.utils;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.constant.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.OwningMoney;

import java.util.List;

public class RandomCoinGenerator {

    public Coins generate(final OwningMoney owningMoney) {
        final List<Integer> availableCoins = Coin.getCoinByOwningMoney(owningMoney);
        return addCoins(owningMoney, availableCoins);
    }

    private Coins addCoins(final OwningMoney owningMoney, final List<Integer> availableCoins) {
        final Coins coins = new Coins();
        while (owningMoney.hasMoney()) {
            final int coin = Randoms.pickNumberInList(availableCoins);
            if (owningMoney.isAvailableCoin(coin)) {
                owningMoney.minusValue(coin);
                coins.addCoin(Coin.valueOfAmount(coin));
            }
        }
        return coins;
    }
}
