package org.example;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

public class YouTubeSubscription implements Subscription {

    private Subscriber<? super String> subscriber;
    private List<String> videoTitles;

    public YouTubeSubscription(final Subscriber<? super String> subscriber, final List<String> videoTitles) {
        this.subscriber = subscriber;
        this.videoTitles = videoTitles;
    }

    @Override
    public void request(long n) {
        System.out.println("request(unbounded)");
        long requestNumberItems = getRequestNumberItems(n);
        for (int i = 0; i <requestNumberItems; i++) {
            subscriber.onNext(videoTitles.get(i));
        }
        subscriber.onComplete();
    }


    @Override
    public void cancel() {
    }

    private long getRequestNumberItems(long n) {
        if(n <=videoTitles.size()){
            return n;
        }else return videoTitles.size();
    }
}