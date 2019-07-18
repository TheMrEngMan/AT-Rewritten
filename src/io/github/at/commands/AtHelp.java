package io.github.at.commands;

import io.github.at.config.Config;
import io.github.at.config.CustomMessages;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AtHelp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("at.member.help")) {
                if (args.length == 0) {
                    for (String str : CustomMessages.Config.getStringList("Help.mainHelp")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
                    }
                    return false;
                } else if (args[0].equalsIgnoreCase("teleport")) {
                    if (Config.isFeatureEnabled("teleport")) {
                        for (String str : CustomMessages.Config.getStringList("Help.teleport")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
                        }
                        if (sender.hasPermission("at.admin.help")) {
                            for (String str : CustomMessages.Config.getStringList("Help.teleportAdmin")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
                            }
                            return false;
                        }
                    } else {
                        sender.sendMessage(CustomMessages.getString("Error.featureDisabled"));
                        return false;
                    }
                } else if (args[0].equalsIgnoreCase("warps")) {
                    if (Config.isFeatureEnabled("warps")) {
                        for (String str : CustomMessages.Config.getStringList("Help.warps")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
                        }
                        if (sender.hasPermission("at.admin.help")) {
                            for (String str : CustomMessages.Config.getStringList("Help.warpsAdmin")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
                            }
                            return false;
                        }
                    } else {
                        sender.sendMessage(CustomMessages.getString("Error.featureDisabled"));
                        return false;
                    }
                } else if (args[0].equalsIgnoreCase("Spawn")) {
                    if (Config.isFeatureEnabled("spawn")) {
                        for (String str : CustomMessages.Config.getStringList("Help.spawn")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
                        }
                        if (sender.hasPermission("at.admin.help")) {
                            for (String str : CustomMessages.Config.getStringList("Help.spawnAdmin")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
                            }
                            return false;
                        }
                    } else {
                        sender.sendMessage(CustomMessages.getString("Error.featureDisabled"));
                        return false;
                    }
                } else if (args[0].equalsIgnoreCase("RandomTP")) {
                    if (Config.isFeatureEnabled("randomTP")) {
                        for (String str : CustomMessages.Config.getStringList("Help.randomTP")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
                        }
                        return false;
                    } else {
                        sender.sendMessage(CustomMessages.getString("Error.featureDisabled"));
                        return false;
                    }
                } else if (args[0].equalsIgnoreCase("Homes")) {
                    if (Config.isFeatureEnabled("homes")) {
                        for (String str : CustomMessages.Config.getStringList("Help.homes")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
                        }
                        if (sender.hasPermission("at.admin.help")) {
                            for (String str : CustomMessages.Config.getStringList("Help.homesAdmin")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
                            }
                            return false;
                        }
                    }
                } else if (args[0].equalsIgnoreCase("Admin")) {
                    if (sender.hasPermission("at.admin.help")) {
                        for (String str : CustomMessages.Config.getStringList("Help.admin")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
                        }
                    }
                    return false;

                } else {
                    sender.sendMessage(CustomMessages.getString("Error.featureDisabled"));
                    return false;
                }

            }
        } return false;

    }
}
