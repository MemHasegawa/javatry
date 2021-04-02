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
    private final Ticket[] tickets;
    private final int change;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * チケットの購入結果
     * @param ticket チケット
     * @param numberOfTickets 発行するチケットの枚数
     * @param change お釣り
     */
    public TicketBuyResult(Ticket ticket, int numberOfTickets, int change) {
        this.ticket = ticket;
        this.tickets = createInitialTickets(ticket, numberOfTickets, change);
        this.change = change;
    }

    // ===================================================================================
    //                                                                 Constructor Modules
    //                                                                            ========
    private Ticket[] createInitialTickets(Ticket ticket, int numberOfTickets, int change) {
        Ticket[] tickets = new Ticket[numberOfTickets];

        for (int i = 0; i < tickets.length; i++)
            tickets[i] = new Ticket(change);

        return tickets;
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
