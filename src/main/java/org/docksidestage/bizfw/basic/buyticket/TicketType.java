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
public enum TicketType {
    // インスタンス生成している感じ。
    ONE_DAY("OneDayPassport", 7400, 1), //
    TWO_DAY("TwoDayPassport", 13200, 2), //
    FOUR_DAY("FourDayPassport", 20000, 4), //
    NIGHT_ONLY("NightOnlyPassport", 7400, 1); //

    private final String label;
    private final int price;
    private final int days;

    private TicketType(String label, int price, int days) {
        this.label = label;
        this.price = price;
        this.days = days;
    }

    public String getLabel() {
        return this.label;
    }

    public int getPrice() {
        return this.price;
    }

    public int getDays() {
        return this.days;
    }
}
