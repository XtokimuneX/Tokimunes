package tokimunes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.apache.commons.lang3.ArrayUtils;
import org.dimdev.rift.listener.client.KeybindHandler;
import org.dimdev.riftloader.listener.InitializationListener;

public class TAPI implements KeybindHandler, BuildAPI, InitializationListener {

    Tmain mod;

    public TAPI() {
        if (!Tmain.isAPIRegister())
            this.mod = Tmain.registerAPI(this);
    }

    @Override
    public void processKeybinds() {
        if (mod != null)
            mod.processKeybinds();
    }

    @Override
    public void registerKeys(KeyBinding... keys) {
        Minecraft mc = Minecraft.getInstance();
        mc.gameSettings.keyBindings = ArrayUtils.addAll(mc.gameSettings.keyBindings, keys);

    }

    @Override
    public String getAPIName() {
        return "Rift";
    }

    @Override
    public void onInitialization() {
        if (mod != null)
            Tmain.getMod().keyMein();
    }

}
