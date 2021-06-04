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
public class MultiDayPassport extends Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========

    private int days;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========

    /**
     * 複数日チケットクラスのコンストラクタ
     * @param ticketType チケットの種類
     * @param displayPrice チケットの値段
     * @param name チケット名
     * @param days チケットの有効日数
     */
    public MultiDayPassport(TicketType ticketType, int displayPrice, int days) {
        super(ticketType, displayPrice);
        this.days = days;
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======

    // TODO 長谷川 複数日パスポートでの処理をオーバーライドする (2021/06/04)
    /*@Override
    public void doInPark() {
        if (alreadyIn) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        alreadyIn = true;
    }*/

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
}
