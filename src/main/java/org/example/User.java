package org.example;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public class User implements Subscriber<String> {
    private String name;
    private Subscription subscription;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        System.out.println("onSubscribe("+name+")");
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(String item) {
        System.out.println("onNext(" +item +")");
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete()");
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println("Error: " + throwable.getMessage());
    }
}
