package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.thirdparty.quotebot.QuotePublisher;

public class BlogAuctionTask {
	private final Pricer pricer;
	private final Publisher publish;
	private final Time time;

	public BlogAuctionTask() {
		pricer = new PricerAdapter();
		publish = QuotePublisher.INSTANCE::publish;
		time = new Time();
	}

	public BlogAuctionTask(Pricer marketDataRetriever, Publisher publisher, Time timer) {
		this.pricer = marketDataRetriever;
		publish = publisher;
		time = timer;
	}

	@SuppressWarnings("deprecation")
	public void PriceAndPublish(String blog, String mode) {
		double avgPrice = pricer.price(blog);
		double proposal = avgPrice + 2;
		proposal = proposal % 2 == 0 ? 3.14 * proposal : 3.15
				* Speed.getTimeFactor(mode)
				* time.getTimePassed();
		publish.publish(proposal);
	}
}
