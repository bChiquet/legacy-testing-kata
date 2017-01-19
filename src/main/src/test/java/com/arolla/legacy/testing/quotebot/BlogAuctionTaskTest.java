package com.arolla.legacy.testing.quotebot;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BlogAuctionTaskTest {

    private double proposal;

    @org.junit.Test
    @Parameters({"2", "4", "6"})
    public void evenAvgPriceExpectation(double avgPrice) {
        BlogAuctionTask task = auctionTaskMock(avgPrice);
        task.PriceAndPublish("blog", "FAST");
        assertThat(proposal).isEqualTo(3.14 * (avgPrice + 2));
    }

    @org.junit.Test
    @Parameters({"1", "3"})
    public void oddAvgPriceExpectation(double avgPrice) {
        BlogAuctionTask task = auctionTaskMock(avgPrice);
        task.PriceAndPublish("blog", "FAST");
        assertThat(proposal).isEqualTo(3.15 * 8);
    }


    @org.junit.Test
    @Parameters({"SLOW", "MEDIUM", "FAST", "ULTRAFAST", ""})
    public void oddAvgPriceExpectation_(String mode) {
        BlogAuctionTask task = auctionTaskMock(3);
        task.PriceAndPublish("blog", mode);
        assertThat(proposal).isEqualTo(3.15 * Speed.getTimeFactor(mode));
    }

    BlogAuctionTask auctionTaskMock(final double avgPrice) {
        return new BlogAuctionTask(
                new Pricer() {
                    @Override
                    public double price(String s) {
                        return avgPrice;
                    }
                },
                proposal -> BlogAuctionTaskTest.this.proposal = proposal
        , new Time(){
            @Override
            long getTimePassed() {
                return 1;
            }
        });
    }
}