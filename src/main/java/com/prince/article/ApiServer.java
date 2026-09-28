package com.prince.article;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class ApiServer {

    private static final String paragraph = "With women empowerment probably at its all time high, I am tempted to \n" +
            "                        blame my frustrations on a claim that, what began as an innocent stand \n" +
            "                        for women has become a stump on men.";
    private static final String quote = "\"I find it hard beliening that I will win or wherether I even\n" +
            "                     deserve to, sometimes it just seems logical to rather focus my\n" +
            "                     means towards securing my comfort when I fail\"";

    private static final Article article = new Article(
            quote,
            paragraph
    );

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH);
        }).start(7000);

        app.get("/article", ctx -> ctx.redirect("/article.html"));

        app.get("/api/article", ctx -> {
            ctx.json(article);
        });
    }
}
