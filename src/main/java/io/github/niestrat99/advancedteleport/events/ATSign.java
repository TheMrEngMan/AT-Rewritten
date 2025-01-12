package io.github.niestrat99.advancedteleport.events;

import io.github.niestrat99.advancedteleport.config.Config;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public abstract class ATSign {

    private String requiredPermission;
    private String requiredFeature;
    private String adminPermission;
    private String name;

    public ATSign(String name, String requiredFeature) {
        this.requiredPermission = ("at.member." + name + ".use-sign").toLowerCase();
        this.requiredFeature = requiredFeature;
        this.adminPermission = ("at.admin.sign." + name + ".create").toLowerCase();
        this.name = name;
    }

    public boolean isEnabled() {
        return requiredFeature.isEmpty() || Config.isFeatureEnabled(requiredFeature);
    }

    public abstract void onInteract(Sign sign, Player player);

    public abstract boolean canCreate(Sign sign, Player player);

    public String getAdminPermission() {
        return adminPermission;
    }

    public String getRequiredPermission() {
        return requiredPermission;
    }

    public String getName() {
        return name;
    }
}
