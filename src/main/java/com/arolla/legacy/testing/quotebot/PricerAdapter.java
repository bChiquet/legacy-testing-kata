package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.thirdparty.quotebot.MarketStudyVendor;

public class PricerAdapter implements Pricer {

    @Override
    public double price(String blog) {
        return new MarketStudyVendor().averagePrice(blog);
    }
}
