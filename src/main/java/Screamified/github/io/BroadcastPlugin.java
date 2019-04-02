package Screamified.github.io;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.GenericEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.channel.MessageChannel;

@Plugin(
        id = "broadcastplugin",
        name = "BroadcastPlugin",
        description = "A simple broadcast plugin"
)
public class BroadcastPlugin {

    public static MessageChannel instance;

    @Inject
    private Logger logger;

    @Listener
    public void onGameInit(GameInitializationEvent event) {

        logger.info("GameInit for our plugin has occured");

        initCommands();

    }

    private void initCommands() {


        CommandSpec bcCommand = CommandSpec.builder()
                .permission("Broadcast.SimpleBroadcast.base")
                .description(Text.of("sends a broadcast server wide"))
                .arguments(GenericArguments.remainingJoinedStrings(Text.of("message")))
                .executor(new sendBroadcast())
                .build();

        Sponge.getCommandManager().register(instance, bcCommand, "testbc", "testbroadcast");
    }

}
