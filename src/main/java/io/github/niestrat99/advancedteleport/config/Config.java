package io.github.niestrat99.advancedteleport.config;

import io.github.niestrat99.advancedteleport.CoreClass;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Config {

    public static File configFile = new File(CoreClass.getInstance().getDataFolder(),"config.yml");
    public static FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
    private static List<String> defaults;

    public static void save() throws IOException {
        config.save(configFile);
    }

    public static void setDefaults() throws IOException {
        // Features
        config.addDefault("features.teleport", true);
        config.addDefault("features.warps", true);
        config.addDefault("features.spawn", true);
        config.addDefault("features.randomTP", true);
        config.addDefault("features.homes",true);

        // Timers
        config.set("timers.commandCooldown", null);
        config.addDefault("timers.teleportTimer",3);
        config.addDefault("timers.teleportTimers.tpa", "default");
        config.addDefault("timers.teleportTimers.tpahere", "default");
        config.addDefault("timers.teleportTimers.tpr", "default");
        config.addDefault("timers.teleportTimers.warp", "default");
        config.addDefault("timers.teleportTimers.spawn", "default");
        config.addDefault("timers.teleportTimers.home", "default");
        config.addDefault("timers.teleportTimers.back", "default");
      
        config.addDefault("timers.requestLifetime",60);
        config.addDefault("timers.cancel-on-rotate", false);
        config.addDefault("timers.cancel-on-movement", true);

        // Cooldowns
        config.addDefault("cooldowns.default", 5);
        config.addDefault("cooldowns.apply-globally", false);
        config.addDefault("cooldowns.add-to-timer", true);
        config.addDefault("cooldowns.back", "default");
        config.addDefault("cooldowns.tpa", "default");
        config.addDefault("cooldowns.tpr", "default");
        config.addDefault("cooldowns.tpahere", "default");
        config.addDefault("cooldowns.home", "default");
        config.addDefault("cooldowns.warp", "default");
        config.addDefault("cooldowns.spawn", "default");
        config.addDefault("cooldowns.tpaall", "default");

        // Booleans
        config.addDefault("booleans.useVault" , false);
        config.addDefault("booleans.EXPPayment" , false);
        //Sounds
        config.addDefault("sounds.tpa.requestSent", "none");
        config.addDefault("sounds.tpa.requestReceived", "none");
        config.addDefault("sounds.tpahere.requestSent", "none");
        config.addDefault("sounds.tpahere.requestReceived", "none");

        // Payments
        config.addDefault("payments.vault.teleportPrice" , 100.00);
        config.addDefault("payments.exp.teleportPrice" , 2);

        /* What I've done here is I've made it so that admins can modify the amount/exp paid per command, although by default
        *  it will get the values from the normal options.
        *  For example, ./home <Home name> may cost $200 whereas /tpa <Player name> costs 2 EXP levels.
        */

        // TPA
        config.addDefault("payments.vault.tpa.price", "default");
        config.addDefault("payments.vault.tpa.enabled", "default");
        config.addDefault("payments.exp.tpa.price", "default");
        config.addDefault("payments.exp.tpa.enabled", "default");

        // TPAHere
        config.addDefault("payments.vault.tpahere.price", "default");
        config.addDefault("payments.vault.tpahere.enabled", "default");
        config.addDefault("payments.exp.tpahere.price", "default");
        config.addDefault("payments.exp.tpahere.enabled", "default");

        // TPR
        config.addDefault("payments.vault.tpr.price", "default");
        config.addDefault("payments.vault.tpr.enabled", "default");
        config.addDefault("payments.exp.tpr.price", "default");
        config.addDefault("payments.exp.tpr.enabled", "default");

        // Warp
        config.addDefault("payments.vault.warp.price", "default");
        config.addDefault("payments.vault.warp.enabled", "default");
        config.addDefault("payments.exp.warp.price", "default");
        config.addDefault("payments.exp.warp.enabled", "default");

        // Spawn
        config.addDefault("payments.vault.spawn.price", "default");
        config.addDefault("payments.vault.spawn.enabled", "default");
        config.addDefault("payments.exp.spawn.price", "default");
        config.addDefault("payments.exp.spawn.enabled", "default");

        // Home
        config.addDefault("payments.vault.home.price", "default");
        config.addDefault("payments.vault.home.enabled", "default");
        config.addDefault("payments.exp.home.price", "default");
        config.addDefault("payments.exp.home.enabled", "default");

        // Back
        config.addDefault("payments.vault.back.price", "default");
        config.addDefault("payments.vault.back.enabled", "default");
        config.addDefault("payments.exp.back.price", "default");
        config.addDefault("payments.exp.back.enabled", "default");

        // TPR options
        config.addDefault("tpr.maximum-x", 10000);
        config.addDefault("tpr.minimum-x", -10000);
        config.addDefault("tpr.maximum-z", 10000);
        config.addDefault("tpr.minimum-z", -10000);
        config.addDefault("tpr.useWorldBorder", true);
        config.addDefault("tpr.avoidBlocks", new ArrayList<>(Arrays.asList("WATER","LAVA", "STATIONARY_WATER", "STATIONARY_LAVA")));
        config.addDefault("tpr.blacklist-worlds", new ArrayList<>());

        config.addDefault("distance-limiter.enabled", false);
        config.addDefault("distance-limiter.distance-limit", 1000);
        config.addDefault("distance-limiter.monitor-all-teleports", false);
        config.addDefault("distance-limiter.per-command.tpa", true);
        config.addDefault("distance-limiter.per-command.tpahere", true);
        config.addDefault("distance-limiter.per-command.tpr", false);
        config.addDefault("distance-limiter.per-command.warp", true);
        config.addDefault("distance-limiter.per-command.spawn", true);
        config.addDefault("distance-limiter.per-command.back", true);
        config.addDefault("distance-limiter.per-command.home", true);

        config.addDefault("teleport-limit.blacklisted-worlds", new ArrayList<>());
        config.addDefault("teleport-limit.enabled", false);
        config.addDefault("teleport-limit.monitor-all-teleports", false);
        config.addDefault("teleport-limit.per-command.tpa", true);
        config.addDefault("teleport-limit.per-command.tpahere", true);
        config.addDefault("teleport-limit.per-command.warp", true);
        config.addDefault("teleport-limit.per-command.spawn", true);
        config.addDefault("teleport-limit.per-command.back", true);
        config.addDefault("teleport-limit.per-command.home", true);
        config.addDefault("teleport-limit.block-to-loc", true);
        config.addDefault("teleport-limit.block-from-loc", true);
        config.addDefault("teleport-limit.allow-teleport-within-world", true);
        config.addDefault("teleport-limit.allow-cross-world-teleporting", true);

        config.addDefault("back.teleport-causes", new ArrayList<>(Arrays.asList("COMMAND", "PLUGIN", "SPECTATE")));


        config.addDefault("homes.default-limit", -1);
        config.addDefault("homes.add-bed-to-homes", true);

        config.addDefault("spawn.death.teleport.default", "spawn");
        config.addDefault("spawn.death.teleport.world", "{default}");
        config.addDefault("spawn.death.teleport.special-world", "warp:Special");
        config.addDefault("spawn.death.teleport.another-world", "bed");
        config.addDefault("spawn.join.teleport-on-first-join", true);
        config.addDefault("spawn.join.teleport-on-every-join", false);

        config.addDefault("permissions.default-permissions", new ArrayList<>(Arrays.asList("at.member.*", "at.member.warp.*")));
        config.addDefault("permissions.allow-admin-perms-as-defaults", false);
        config.options().copyDefaults(true);
        save();
    }
    public static int commandCooldown(){
        return config.getInt("timers.commandCooldown");
    }

    public static int getTeleportTimer(String command) {
        if (config.get("timers.teleportTimers." + command) instanceof String) {
            return config.getInt("timers.teleportTimer");
        } else {
            return config.getInt("timers.teleportTimers." + command);
        }
    }

    public static int getCooldown(String command) {
        if (config.get("cooldowns." + command) instanceof String) {
            return config.getInt("cooldowns.default");
        } else {
            return config.getInt("cooldowns." + command);
        }
    }

    public static boolean isApplyingTimerToCooldown() {
        return config.getBoolean("cooldowns.add-to-timer");
    }

    public static boolean isCooldownGlobal() {
        return config.getBoolean("cooldowns.apply-globally");
    }

    public static int requestLifetime(){
        return config.getInt("timers.requestLifetime");
    }

    /* Used to check if a specific command is using vault for payments.
     * e.g: Config.isUsingVault("home") - returns true if the home command is using payments through Vault.
     */
    public static boolean isUsingVault(String command) {
        if (config.get("payments.vault." + command + ".enabled") instanceof String) {
            return config.getBoolean("booleans.useVault");
        } else {
            return config.getBoolean("payments.vault." + command + ".enabled");
        }
    }

    /* Used to get the sound name that will be played for specific event.
     * e.g: Config.getSound("tpa.requestSent") - returns a string (e.g none, BLOCK_ANVIL_LAND) of the sound name that will be played to a player that sent a tpa request
     */
    public static String getSound(String event){ return config.getString("sounds." + event).toUpperCase(); }

    /* Used to get the amount that is paid for the specific command.
     * e.g: Config.getTeleportPrice("home") - returns a price (e.g $10) for how much the home command costs.
     */
    public static double getTeleportPrice(String command) {
        if (config.get("payments.vault." + command + ".price") instanceof String) {
            return config.getDouble("payments.vault.teleportPrice");
        } else {
            return config.getDouble("payments.vault." + command + ".price");
        }
    }

    /* Used to check if a specific command is using EXP for payments.
     * e.g: Config.isUsingEXPPayment("home") - returns true if the home command is using payments through experience.
     */
    public static boolean isUsingEXPPayment(String command) {
        if (config.get("payments.exp." + command + ".enabled") instanceof String) {
            return config.getBoolean("booleans.EXPPayment");
        } else {
            return config.getBoolean("payments.exp." + command + ".enabled");
        }
    }

    /* Used to get the levels that are paid for the specific command.
     * e.g: Config.getEXPTeleportPrice("home") - returns the level that is required to use the home command.
     */
    public static int getEXPTeleportPrice(String command) {
        if (config.get("payments.exp." + command + ".price") instanceof String) {
            return config.getInt("payments.exp.teleportPrice");
        } else {
            return config.getInt("payments.exp." + command + ".price");
        }
    }

    public static boolean useWorldBorder() {return config.getBoolean("tpr.useWorldBorder");}
    public static int maxX() {return config.getInt("tpr.maximum-x");}
    public static int minX() {return config.getInt("tpr.minimum-x");}
    public static int maxZ() {return config.getInt("tpr.maximum-z");}
    public static int minZ() {return config.getInt("tpr.minimum-z");}
    public static List<String> avoidBlocks() {return config.getStringList("tpr.avoidBlocks");}

    /* This method is used as a replacement for featTP, featWarps, etc. to make checking if the feature is enabled easier.
     * For example:
     * Config.isFeatureEnabled("teleport") - checks if teleports are enabled.
     * Config.isFeatureEnabled("warps") - checks if warps are enabled.
     * Config.isFeatureEnabled("randomTP") - checks if RTP is enabled.
     * Config.isFeatureEnabled("homes") - checks if homes are enabled.
     * Config.isFeatureEnabled("spawn") - checks if the spawn feature is enabled.
     */
    public static boolean isFeatureEnabled(String feature) { return config.getBoolean("features." + feature); }

    public static boolean cancelOnRotate() {return config.getBoolean("timers.cancel-on-rotate");}

    public static boolean cancelOnMovement() {return config.getBoolean("timers.cancel-on-movement");}

    public static void reloadConfig() throws IOException {
        if (configFile == null) {
            configFile = new File(CoreClass.getInstance().getDataFolder(), "config.yml");
        }
        config = YamlConfiguration.loadConfiguration(configFile);
        setDefaults();
        save();
        setupDefaults();
    }

    public static boolean isDistanceLimiterEnabled() {
        return config.getBoolean("distance-limiter.enabled");
    }

    public static boolean isDistanceLimiterEnabledForCmd(String command) {
        return config.getBoolean("distance-limiter.per-command." + command);
    }

    public static double getDistanceLimit() {
        return config.getDouble("distance-limiter.distance-limit");
    }

    public static boolean isTeleportLimiterEnabled() {
        return config.getBoolean("teleport-limit.enabled");
    }

    public static boolean isTeleportLimiterEnabledForCmd(String command) {
        return config.getBoolean("teleport-limit.per-command." + command);
    }

    public static boolean hasStrictTeleportLimiter() {
        return config.getBoolean("teleport-limit.monitor-all-teleports");
    }

    public static boolean hasStrictDistanceMonitor() {
        return config.getBoolean("distance-limiter.monitor-all-teleports");
    }

    public static boolean isCauseAllowed(PlayerTeleportEvent.TeleportCause cause) {
        return config.getStringList("back.teleport-causes").contains(cause.name());
    }

    public static List<String> getBlacklistedTPRWorlds() {
        return config.getStringList("tpr.blacklist-worlds");
    }

    public static List<String> getBlacklistedWorlds() {
        return config.getStringList("teleport-limit.blacklisted-worlds");
    }

    public static boolean containsBlacklistedWorld(String worldName, String pos) {
        return getBlacklistedWorlds().contains(worldName) && config.getBoolean("teleport-limit.block-" + pos + "-loc");
    }

    public static boolean isAllowingTeleportWithinWorlds() {
        return config.getBoolean("teleport-limit.allow-teleport-within-world");
    }

    public static boolean isAllowingCrossWorldTeleport() {
        return config.getBoolean("teleport-limit.allow-cross-world-teleporting");
    }

    public static int getDefaultHomesLimit() {
        return config.getInt("homes.default-limit");
    }

    public static String getSpawnCommand(World world) {
        String command = config.getString("spawn.death.teleport." + world.getName());
        if (command == null || command.equals("{default}")) {
            command = config.getString("spawn.death.teleport.default");
        }
        return command;
    }

    public static boolean spawnTPOnFirstJoin() {
        return config.getBoolean("spawn.join.teleport-on-first-join");
    }

    public static boolean spawnTPEveryTime() {
        return config.getBoolean("spawn.join.teleport-on-every-join");
    }

    public static boolean addBedToHomes() { return config.getBoolean("homes.add-bed-to-homes"); }

    public static void setupDefaults() {
        List<String> permissions = config.getStringList("permissions.default-permissions");
        if (defaults == null) {
            defaults = new ArrayList<>();
        } else {
            for (String permission : defaults) {
                Permission permObject = Bukkit.getPluginManager().getPermission(permission);
                permObject.setDefault(PermissionDefault.OP);
            }
        }
        boolean warned = false;
        for (String permission : permissions) {
            if (!permission.startsWith("at")) continue;
            if (permission.startsWith("at.admin")) {
                if (!warned) {
                    CoreClass.getInstance().getLogger().warning("WARNING: You've given an admin permission by default to all users.");
                    if (!config.getBoolean("permissions.allow-admin-perms-as-defaults") || CoreClass.getPerms() != null) {
                        CoreClass.getInstance().getLogger().warning("This can potentially be destructive, so we're not adding it right now.");
                        CoreClass.getInstance().getLogger().warning("To allow people to use admin permissions such as the ones specified, please disable the check in the configuration.");
                        CoreClass.getInstance().getLogger().warning("If you have a permissions plugin hooked into Vault too, you cannot make admin permissions default permissions.");
                    } else {
                        CoreClass.getInstance().getLogger().warning("This can potentially be destructive, so if this is not your doing, please check your configuration.");
                        CoreClass.getInstance().getLogger().warning("To stop people to use admin permissions such as the ones specified, please enable the check in the configuration.");
                    }
                    warned = true;
                }
                if (config.getBoolean("permissions.allow-admin-perms-as-defaults") && CoreClass.getPerms() == null) {
                    CoreClass.getInstance().getLogger().info("Allowed default access to " + permission);
                } else {
                    CoreClass.getInstance().getLogger().info("Denied default access to " + permission);
                    continue;
                }
            }
            Permission permObject = Bukkit.getPluginManager().getPermission(permission);
            if (permObject == null) {
                permObject = new Permission(permission);
                Bukkit.getPluginManager().addPermission(permObject);
            }
            permObject.setDefault(PermissionDefault.TRUE);
            defaults.add(permission);
        }
    }
}
