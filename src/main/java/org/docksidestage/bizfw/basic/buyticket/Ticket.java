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
public abstract class Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected boolean alreadyIn;
    protected TicketType ticketType;
    protected int days;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * 抽象チケットクラスのコンストラクタ
     * @param ticketType チケットの種類
     * @param displayPrice チケットの値段
     */
    public Ticket(TicketType ticketType) {
        this.ticketType = ticketType;
        this.days = ticketType.getDays();
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    // 
    public void doInPark() {
        if (days <= 0) {
            throw new IllegalStateException("Ticket is expired: validDays = " + this.days);
        }
        days--; // 1日消費
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getDisplayPrice() {
        return ticketType.getPrice();
    }

    public int getValidDays() {
        return this.days;
    }

    public boolean isAlreadyIn() {
        return alreadyIn;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public String getName() {
        return ticketType.getName();
    };
}
