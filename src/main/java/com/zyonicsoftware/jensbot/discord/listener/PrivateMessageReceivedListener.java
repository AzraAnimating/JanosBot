package com.zyonicsoftware.jensbot.discord.listener;

import com.zyonicsoftware.jensbot.discord.JensDiscordBot;
import com.zyonicsoftware.jensbot.main.JensController;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PrivateMessageReceivedListener extends ListenerAdapter {

    private final JensDiscordBot jensDiscordBot;

    public PrivateMessageReceivedListener(final JensDiscordBot jensDiscordBot) {
        this.jensDiscordBot = jensDiscordBot;
    }

    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        if(event.getAuthor().getId().equals("309007975060602882") || event.getAuthor().getId().equals("580345213831086080") || event.getAuthor().getId().equals("755445139836502116")) {
        }
    }

}
