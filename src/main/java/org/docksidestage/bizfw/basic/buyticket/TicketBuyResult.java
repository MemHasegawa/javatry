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
public class TicketBuyResult {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final Ticket ticket;
    // private final Ticket[] tickets;
    private final int change;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * チケットの購入結果
     * @param ticketDays 発行するチケットの有効日数
     * @param price チケットの費用
     * @param change お釣り
     */
    // // TODO 長谷川 ドキュメントを治す (2021/05/07)
    public TicketBuyResult(/*Ticket ticket, */int ticketDays, int price, int change) {
        this.ticket = createTicket(ticketDays, price);
        // this.tickets = createInitialTickets(ticket, numberOfTickets, change);
        this.change = change;
    }

    // ===================================================================================
    //                                                                 Constructor Modules
    //                                                                            ========
    private Ticket createTicket(int ticketDays, int price) {
        switch (ticketDays) {
        case 1:
            return new OneDayPassport(price);
        case 2:
            return new TwoDayPassport(price);
        default:
            // 例外を書くときは、この例外を見る人を考える
            throw new InvalidTicketDaysException("チケットに設定された日数が無効です: " + ticketDays);
        }
    }
    // TODO 長谷川 イメージがつきづらいので、TicketBoothにあったほうが良い。 (2021/05/07)

    // ===================================================================================
    //                                                                           Exception
    //                                                                            ========
    public static class InvalidTicketDaysException extends RuntimeException {

        // TODO 長谷川 次回聞くことになった。 (2021/05/07)
        private static final long serialVersionUID = 1L; // これは何？

        public InvalidTicketDaysException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Ticket getTicket() {
        return this.ticket;
    }

    public int getChange() {
        return this.change;
    }
}
