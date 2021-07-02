/*
 * Copyright 2019-2021 the original author or authors.
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
package org.docksidestage.javatry.basic;

import org.docksidestage.bizfw.basic.buyticket.Ticket;
import org.docksidestage.bizfw.basic.buyticket.TicketBooth;
import org.docksidestage.bizfw.basic.buyticket.TicketBooth.TicketShortMoneyException;
import org.docksidestage.bizfw.basic.buyticket.TicketBuyResult;
import org.docksidestage.bizfw.basic.buyticket.TicketType;
import org.docksidestage.unit.PlainTestCase;

/**
 * The test of class. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author MemCHT
 */
public class Step05ClassTest extends PlainTestCase {

    // ===================================================================================
    //                                                                          How to Use
    //                                                                          ==========
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_class_howToUse_basic() {
        TicketBooth booth = new TicketBooth();
        booth.buyOneDayPassport(7400);
        int sea = booth.getQuantity();
        log(sea); // your answer? => 9
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_class_howToUse_overpay() {
        TicketBooth booth = new TicketBooth();
        booth.buyOneDayPassport(10000);
        Integer sea = booth.getSalesProceeds();
        log(sea); // your answer? => 0
                  // answer => 10000, 7400のボーダーを逆にとらえていた！ handedMoney: 手持ちの金
                  // 修正後answer => 7400
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_class_howToUse_nosales() {
        TicketBooth booth = new TicketBooth();
        Integer sea = booth.getSalesProceeds();
        log(sea); // your answer? => 0
                  // answer => null, Integerは参照型（intのラッパークラス)なので
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_class_howToUse_wrongQuantity() {
        Integer sea = doTest_class_ticket_wrongQuantity();
        log(sea); // your answer? => 9
                  // 修正後answer => 10
    }

    private Integer doTest_class_ticket_wrongQuantity() {
        TicketBooth booth = new TicketBooth();
        int handedMoney = 7399;
        try {
            booth.buyOneDayPassport(handedMoney);
            fail("always exception but none");
        } catch (TicketShortMoneyException continued) {
            log("Failed to buy one-day passport: money=" + handedMoney, continued);
        }
        return booth.getQuantity();
    }

    // ===================================================================================
    //                                                                           Let's fix
    //                                                                           =========
    /**
     * Fix the problem of ticket quantity reduction when short money. (Don't forget to fix also previous exercise answers) <br>
     * (お金不足でもチケットが減る問題をクラスを修正して解決しましょう (以前のエクササイズのanswerの修正を忘れずに))
     */
    public void test_class_letsFix_ticketQuantityReduction() {
        Integer sea = doTest_class_ticket_wrongQuantity();
        log(sea); // should be max quantity, visual check here
    }

    /**
     * Fix the problem of sales proceeds increased by handed money. (Don't forget to fix also previous exercise answers) <br>
     * (受け取ったお金の分だけ売上が増えていく問題をクラスを修正して解決しましょう (以前のエクササイズのanswerの修正を忘れずに))
     */
    public void test_class_letsFix_salesProceedsIncrease() {
        TicketBooth booth = new TicketBooth();
        booth.buyOneDayPassport(10000);
        Integer sea = booth.getSalesProceeds();
        log(sea); // should be same as one-day price, visual check here
    }

    /**
     * Make method for buying two-day passport (price is 13200). (which can return change as method return value)
     * (TwoDayPassport (金額は13200) も買うメソッドを作りましょう (戻り値でお釣りをちゃんと返すように))
     */
    public void test_class_letsFix_makeMethod_twoday() {
        // uncomment after making the method
        TicketBooth booth = new TicketBooth();
        int money = 14000;
        // int change = booth.buyTwoDayPassport(money); ※TicketBoothクラス修正前
        int change = booth.buyTwoDayPassport(money).getChange();
        Integer sea = booth.getSalesProceeds() + change;
        log(sea); // should be same as money

        // and show two-day passport quantity here
        log(booth.getQuantity());
    }

    /**
     * Recycle duplicate logics between one-day and two-day by e.g. private method in class. (And confirm result of both before and after) <br>
     * (OneDayとTwoDayで冗長なロジックがあったら、クラス内のprivateメソッドなどで再利用しましょう (修正前と修正後の実行結果を確認))
     */
    // done 長谷川_2021年2月5日_考え中
    public void test_class_letsFix_refactor_recycle() {
        TicketBooth booth = new TicketBooth();
        booth.buyOneDayPassport(10000);
        log(booth.getQuantity(), booth.getSalesProceeds()); // should be same as before-fix
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Now you cannot get ticket if you buy one-day passport, so return Ticket class and do in-park. <br>
     * (OneDayPassportを買ってもチケットをもらえませんでした。戻り値でTicketクラスを戻すようにしてインしましょう)
     */
    // done TODO 長谷川_2021年3月5日_考え中_
    // 要件に一貫性があれば、どのように実装しても良い。
    public void test_class_moreFix_return_ticket() {
        // uncomment out after modifying the method
        TicketBooth booth = new TicketBooth();
        // Ticket oneDayPassport = booth.buyOneDayPassport(10000); ※TicketBoothクラス修正前
        Ticket oneDayPassport = booth.buyOneDayPassport(10000).getTicket();
        log(oneDayPassport.getDisplayPrice()); // should be same as one-day price
        log(oneDayPassport.isAlreadyIn()); // should be false
        oneDayPassport.doInPark();
        log(oneDayPassport.isAlreadyIn()); // should be true

    }

    /**
     * Now also you cannot get ticket if two-day passport, so return class that has ticket and change. <br>
     * (TwoDayPassportもチケットをもらえませんでした。チケットとお釣りを戻すクラスを作って戻すようにしましょう)
     */
    public void test_class_moreFix_return_whole() {
        // uncomment after modifying the method
        TicketBooth booth = new TicketBooth();
        int handedMoney = 20000;
        TicketBuyResult twoDayPassportResult = booth.buyTwoDayPassport(handedMoney);
        Ticket twoDayPassport = twoDayPassportResult.getTicket();
        int change = twoDayPassportResult.getChange();
        log(twoDayPassport.getDisplayPrice() + change); // should be same as money
    }

    /**
     * Now you cannot judge ticket type "one-day or two-day?", so add method to judge it. <br>
     * (チケットをもらってもOneDayなのかTwoDayなのか判定できません。判定できるメソッドを追加しましょう)
     */
    // done 長谷川_2021年4月2日_複数のTicketをどう管理するか考え中。
    public void test_class_moreFix_ticketType() {
        // your confirmation code here
        TicketBooth booth = new TicketBooth();
        int handedMoney = 20000;
        TicketBuyResult twoDayPassportResult = booth.buyTwoDayPassport(handedMoney);
        Ticket twoDayPassport = twoDayPassportResult.getTicket();
        String ticketName = twoDayPassport.getName();

        log("ticketName: " + ticketName);

        // 個別に階層化していない場合はenumを用いる。 分岐（特にswitch）を用いるときは注意
        if (twoDayPassport.getTicketType().equals(TicketType.ONE_DAY)) {
            log("this ticket is " + TicketType.ONE_DAY.getLabel());
        } else if (twoDayPassport.getTicketType().equals(TicketType.TWO_DAY)) {
            log("this ticket is " + TicketType.TWO_DAY.getLabel());
        }
    }

    /**
     * Now you can use only one in spite of two-day passport, so fix Ticket to be able to handle plural days. <br>
     * (TwoDayPassportなのに一回しか利用できません。複数日数に対応できるようにTicketを修正しましょう)
     */
    public void test_class_moreFix_usePluralDays() {
        // your confirmation code here
        TicketBooth booth = new TicketBooth();
        int handedMoney = 20000;
        TicketBuyResult twoDayPassportResult = booth.buyTwoDayPassport(handedMoney);
        Ticket twoDayPassport = twoDayPassportResult.getTicket();

        log(twoDayPassport.getValidDays() + " days left"); // 2 days
        twoDayPassport.doInPark();
        log(twoDayPassport.getValidDays() + " days left"); // 1 days
        twoDayPassport.doInPark();
        log(twoDayPassport.getValidDays() + " days left"); // 0 days
        twoDayPassport.doInPark(); // throw error
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Fix it to be able to buy four-day passport (price is 22400). <br>
     * (FourDayPassport (金額は22400) のチケットも買えるようにしましょう)
     */
    public void test_class_moreFix_wonder_four() {
        // your confirmation code here
        TicketBooth booth = new TicketBooth();
        int handedMoney = 20000;
        TicketBuyResult fourDayPassportResult = booth.buyFourDayPassport(handedMoney);
        Ticket fourDayPassport = fourDayPassportResult.getTicket();

        for (int i = fourDayPassport.getValidDays(); i > 0; i--) {
            log(fourDayPassport.getValidDays() + " days left"); // 4~1 days
            fourDayPassport.doInPark();
        }
        log(fourDayPassport.getValidDays() + " days left"); // 0 days
        fourDayPassport.doInPark(); // throw error
    }

    /**
     * Fix it to be able to buy night-only two-day passport (price is 7400), which can be used at only night. <br>
     * (NightOnlyTwoDayPassport (金額は7400) のチケットも買えるようにしましょう。夜しか使えないようにしましょう。)
     */
    public void test_class_moreFix_wonder_night() {
        // your confirmation code here

    }

    /**
     * Refactor if you want to fix (e.g. is it well-balanced name of method and variable?). <br>
     * (その他、気になるところがあったらリファクタリングしてみましょう (例えば、バランスの良いメソッド名や変数名になっていますか？))
     */
    public void test_class_moreFix_yourRefactoring() {
        // your confirmation code here
    }
}
