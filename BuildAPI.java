package tokimunes;

import net.minecraft.client.settings.KeyBinding;

/**
 * A class to define what an API need to run XrayMod
 */
public interface BuildAPI {
    /**
     * register keys in Minecraft
     */
    void registerKeys(KeyBinding... keys);

    /**
     * the API name (Rift, Forge, (...))
     */
    String getAPIName();
}