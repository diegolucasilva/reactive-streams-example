package org.example;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;

class YouTubeChannel implements Publisher<String> {
    private List<String> videoTitles = new ArrayList<>();

    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        subscriber.onSubscribe(new YouTubeSubscription(subscriber, videoTitles));
    }

    public void addVideo(String videoTitle) {
        videoTitles.add(videoTitle);
    }

}