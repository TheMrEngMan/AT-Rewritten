package io.github.niestrat99.advancedteleport.utilities;

import io.github.niestrat99.advancedteleport.api.ATTeleportEvent;
import io.github.niestrat99.advancedteleport.config.Config;
import io.github.niestrat99.advancedteleport.config.CustomMessages;
import io.github.niestrat99.advancedteleport.events.MovementManager;
import io.github.niestrat99.advancedteleport.CoreClass;
import io.papermc.lib.PaperLib;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class AcceptRequest {

    public static void acceptRequest(TPRequest request) {
        Player player = request.getResponder();
        request.getRequester().sendMessage(CustomMessages.getString("Info.requestAcceptedResponder").replaceAll("\\{player}", player.getName()));
        player.sendMessage(CustomMessages.getString("Info.requestAccepted"));
        // Check again
        if (PaymentManager.canPay(request.getType().name().toLowerCase().replaceAll("_", ""), request.getRequester())) {
            if (request.getType() == TPRequest.TeleportType.TPAHERE) {
                teleport(request.getRequester(), player, "tpahere");
            } else {
                teleport(player, request.getRequester(), "tpa");
            }
        }

        request.destroy();
    }

    private static void teleport(Player toPlayer, Player fromPlayer, String type) {
        ATTeleportEvent event = new ATTeleportEvent(fromPlayer, toPlayer.getLocation(), fromPlayer.getLocation(), "", ATTeleportEvent.TeleportType.valueOf(type.toUpperCase()));
        if (!event.isCancelled()) {
            if (Config.getTeleportTimer(type) > 0 && !fromPlayer.hasPermission("at.admin.bypass.timer")) {
                BukkitRunnable movementtimer = new BukkitRunnable() {
                    @Override
                    public void run() {
                        PaperLib.teleportAsync(fromPlayer, toPlayer.getLocation(), PlayerTeleportEvent.TeleportCause.COMMAND);
                        MovementManager.getMovement().remove(fromPlayer.getUniqueId());
                        fromPlayer.sendMessage(CustomMessages.getString("Teleport.eventTeleport"));
                        PaymentManager.withdraw(type, type.equalsIgnoreCase("tpahere") ?  toPlayer : fromPlayer);

                    }
                };
                MovementManager.getMovement().put(fromPlayer.getUniqueId(), movementtimer);
                movementtimer.runTaskLater(CoreClass.getInstance(), Config.getTeleportTimer(type)*20);
                fromPlayer.sendMessage(CustomMessages.getEventBeforeTPMessage().replaceAll("\\{countdown}" , String.valueOf(Config.getTeleportTimer(type))));
            } else {
                PaperLib.teleportAsync(fromPlayer, toPlayer.getLocation(), PlayerTeleportEvent.TeleportCause.COMMAND);
                fromPlayer.sendMessage(CustomMessages.getString("Teleport.eventTeleport"));
                PaymentManager.withdraw("tpahere", type.equalsIgnoreCase("tpahere") ?  toPlayer : fromPlayer);
            }
        }
    }
}
