package me.lucashagen.player;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SessionManager {

    HashMap<UUID, PlayerInfo> playerInfos;

    public SessionManager() {
        playerInfos = new HashMap<UUID, PlayerInfo>();
    }

    public void createSession(Player player) {
        playerInfos.put(player.getUniqueId(), new PlayerInfo(player));
    }

    public PlayerInfo getInfo(Player player) {
        return playerInfos.getOrDefault(player.getUniqueId(), null);
    }

    public void endSession(Player player) {
        PlayerInfo info = getInfo(player);

        if (info != null) {
            info.endSession();

            System.out.println(String.format("Player '%s' was online for %d seconds",
                    info.getUsername(), info.getSession().getDuration(TimeUnit.SECONDS)));
        }
    }

    public void endAllSessions()
    {
        for(PlayerInfo info : playerInfos.values())
        {
            info.endSession();

            System.out.println(String.format("Player '%s' was online for %d seconds",
                    info.getUsername(), info.getSession().getDuration(TimeUnit.SECONDS)));
        }
    }

}
