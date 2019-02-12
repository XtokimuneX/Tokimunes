package tokimunes;


import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import java.util.Objects;


public class Tmain {
    private static Tmain instance;
    private BuildAPI api;
    private KeyBinding fullbright, config;

    private Tmain(BuildAPI api) {
        if (isAPIRegister())
            throw new IllegalStateException("An API is already register for this mod!");
        this.api = Objects.requireNonNull(api, "You must provide a non-null API");
    }

    public static Tmain getMod() {
        return instance;
    }

    public static boolean isAPIRegister() {
        return instance != null;
    }

    public static Tmain registerAPI(BuildAPI api) throws IllegalStateException {
        instance = new Tmain(api);
        return instance;
    }

    public void processKeybinds() {

        if (fullbright.isPressed())
            Minecraft.getInstance().player.sendChatMessage("test");
        else if (config.isPressed())
            Minecraft.getInstance().player.sendChatMessage("test2");
    }

    public void keyMein() {
        api.registerKeys(fullbright = new KeyBinding("x13.mod.fullbright", 72, "key.categories.xray"), // H
                config = new KeyBinding("x13.mod.config", 78, "key.categories.xray")); // N
    }


}
