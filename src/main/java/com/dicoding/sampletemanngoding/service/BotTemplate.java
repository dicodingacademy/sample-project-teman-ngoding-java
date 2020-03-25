package com.dicoding.sampletemanngoding.service;

import com.dicoding.sampletemanngoding.model.DicodingEvents;
import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.event.source.GroupSource;
import com.linecorp.bot.model.event.source.RoomSource;
import com.linecorp.bot.model.event.source.Source;
import com.linecorp.bot.model.event.source.UserSource;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.template.ButtonsTemplate;
import com.linecorp.bot.model.message.template.CarouselColumn;
import com.linecorp.bot.model.message.template.CarouselTemplate;
import com.linecorp.bot.model.profile.UserProfileResponse;
import org.apache.commons.text.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BotTemplate {
    public TemplateMessage createButton(String message, String actionTitle, String actionText) {
        ButtonsTemplate buttonsTemplate = new ButtonsTemplate(
                null,
                null,
                message,
                Collections.singletonList(new MessageAction(actionTitle, actionText))
        );

        return new TemplateMessage(actionTitle, buttonsTemplate);
    }

    public TemplateMessage greetingMessage(Source source, UserProfileResponse sender) {
        String message  = "Hi %s! Ayo ikut dicoding event, aku bisa cariin kamu teman.";
        String action   = "Lihat daftar event";

        if (source instanceof GroupSource) {
            message = String.format(message, "Group");
        } else if (source instanceof RoomSource) {
            message = String.format(message, "Room");
        } else if(source instanceof UserSource) {
            message = String.format(message, sender.getDisplayName());
        } else {
            message = "Unknown Message Source!";
        }

        return createButton(message, action, action);
    }

    public TemplateMessage carouselEvents(DicodingEvents dicodingEvents) {
        int i;
        String image, owner, name, id, link;
        CarouselColumn column;
        List<CarouselColumn> carouselColumn = new ArrayList<>();
        for (i = 0; i < dicodingEvents.getData().size(); i++){
            image = dicodingEvents.getData().get(i).getImagePath();
            owner = dicodingEvents.getData().get(i).getOwnerDisplayName();
            name = dicodingEvents.getData().get(i).getName();
            id = String.valueOf(dicodingEvents.getData().get(i).getId());
            link = dicodingEvents.getData().get(i).getLink();

            column = new CarouselColumn(image, name.substring(0, (name.length() < 40)?name.length():40), owner,
                    Arrays.asList(
                            new MessageAction("Summary", "["+String.valueOf(i+1)+"]"+" Summary : " + name),
                            new URIAction("View Page", link),
                            new MessageAction("Join Event", "join event #"+id)
                    )
            );

            carouselColumn.add(column);
        }

        CarouselTemplate carouselTemplate = new CarouselTemplate(carouselColumn);
        return new TemplateMessage("Your search result", carouselTemplate);
    }

    public String escape(String text) {
        return  StringEscapeUtils.escapeJson(text.trim());
    }

    public String br2nl(String html) {
        Document document = Jsoup.parse(html);
        document.select("br").append("\\n");
        document.select("p").prepend("\\n");
        String text = document.text()
                .replace("\\n\\n", "\\n")
                .replace("\\n", "\n");

        return StringEscapeUtils.escapeJson(text.trim());
    }
}
