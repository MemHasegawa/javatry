/*
 * Copyright 2019-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author jflute
 * @author MemCHT
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========

    /**
     * OneDayPassportを買う
     * @param handedMoney 受け取ったお金
     * @return OneDayPassport チケット購入結果
     */
    public TicketBuyResult buyOneDayPassport(int handedMoney) {
        // 種別に依存してよいのはこのメソッド。
        // done TODO 長谷川 enumをもっと最適化できる (2021/07/02)
        final TicketType ticketType = TicketType.ONE_DAY;
        final int ticketDays = ticketType.getDays();

        final Ticket ticket = new OneDayPassport();

        return doBuyPassport(ticket, handedMoney, ticketDays);
    }

    /**
     * TwoDayPassportを買う
     * @param handedMoney 受け取ったお金
     * @return MultiDayPassport チケット購入結果
     */
    public TicketBuyResult buyTwoDayPassport(int handedMoney) {
        // 種別に依存してよいのはこのメソッド。
        // done TODO 長谷川 enumをもっと最適化できる (2021/07/02)
        final TicketType ticketType = TicketType.TWO_DAY;
        final int ticketDays = ticketType.getDays();

        final MultiDayPassport ticket = new MultiDayPassport(ticketType);

        return doBuyPassport(ticket, handedMoney, ticketDays);
    }

    /**
     * TwoDayPassportを買う
     * @param handedMoney 受け取ったお金
     * @return MultiDayPassport チケット購入結果
     */
    public TicketBuyResult buyFourDayPassport(int handedMoney) {
        // 種別に依存してよいのはこのメソッド。
        // done TODO 長谷川 enumをもっと最適化できる (2021/07/02)
        final TicketType ticketType = TicketType.FOUR_DAY;
        final int ticketDays = ticketType.getDays();

        final MultiDayPassport ticket = new MultiDayPassport(ticketType);

        return doBuyPassport(ticket, handedMoney, ticketDays);
    }

    /**
     * Passportを買う
     * @param handedMoney 受け取ったお金
     * @param quantity チケットの消費枚数
     * @return お釣り
     */
    private TicketBuyResult doBuyPassport(Ticket ticket, int handedMoney, int quantity) {
        final int price = ticket.getDisplayPrice();

        checkSoldOut(); // 売り切れチェック
        checkShortMoney(handedMoney, price); // お金不足チェック
        reduceQuantity(quantity); // チケット数を減らす
        increaseSalesProceeds(quantity, price); // 売り上げを増やす

        int change = calcChange(handedMoney, price); // お釣りを計算

        return new TicketBuyResult(ticket, change); // チケットの購入結果インスタンスを返す
    }

    // -------------------- buy ticket modules --------------------
    // 売り切れチェック
    private void checkSoldOut() {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
    }

    // お金不足チェック
    private void checkShortMoney(int handedMoney, int price) {
        if (handedMoney < price) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
    }

    // チケット数を減らす
    private void reduceQuantity(int count) {
        quantity = quantity - count;
    }

    // 売り上げを増やす
    private int increaseSalesProceeds(int count, int price) {
        if (salesProceeds != null) {
            return salesProceeds = salesProceeds + price;
        } else {
            return salesProceeds = price;
        }
    }

    // お釣りを計算して返す ※意味で切り出す！さらに言えば、オブジェクトに分けて再利用が効くようにcalculateChangeクラスがあっても良い。。
    private int calcChange(int handedMoney, int price) {
        return handedMoney - price;
    }

    // -------------------- end buy ticket modules --------------------

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
