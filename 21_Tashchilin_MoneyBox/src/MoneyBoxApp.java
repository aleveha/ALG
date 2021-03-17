public class MoneyBoxApp {
    public static void main(String[] args) {
        MoneyBox mb1 = new MoneyBox("Alice", 5, 3);
        MoneyBox mb2 = new MoneyBox("Bob");
        mb2.addCoins(2, 0);
        mb2.addCoins(0, 3);
        mb2.addCoins(5, 10);

        System.out.printf("Alice has %dKc, Bob has %dKc\n", mb1.getSum(), mb2.getSum());
        System.out.println(mb1.getMoneyBoxInfo());
        System.out.println(mb2.getMoneyBoxInfo());
        System.out.printf("Alice can%s buy hamburger (39Kc)\n", mb1.refinePrice(39) ? "" : "'t");
        System.out.printf("Bob can%s buy hamburger (39Kc)\n", mb2.refinePrice(39) ? "" : "'t");
        System.out.printf("%s has more money than %s\n", mb1.getSum() > mb2.getSum() ? mb1.getOwner() : mb2.getOwner(), mb1.getSum() < mb2.getSum() ? mb1.getOwner() : mb2.getOwner());

        mb1.addCoins(mb2.getOneCoinCounter(), mb2.getTwoCoinCounter());
        System.out.printf("Bob gave Alice all his money. Alice has %dKc", mb1.getSum());
    }
}
