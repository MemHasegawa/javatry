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
public class TwoDayPassport extends Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========

    private String name = "TwoDayPassport";
    private int days = 2;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TwoDayPassport(int displayPrice) {
        super(displayPrice);
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======

    // TODO 長谷川 doInParkのオーバーライド考え途中 (2021/05/07)
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

    @Override
    public String getName() {
        return this.name;
    }
}
