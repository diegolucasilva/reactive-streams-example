package org.example;

public class Main {
    public static void main(String[] args)
    {
        YouTubeChannel channel = new YouTubeChannel();

        channel.addVideo("Reactive Programming with Java");
        channel.addVideo("Introduction to Machine Learning");
        channel.addVideo("Web Development Basics");

        User userSubscriber = new User("Diego");

        channel.subscribe(userSubscriber);
    }
}