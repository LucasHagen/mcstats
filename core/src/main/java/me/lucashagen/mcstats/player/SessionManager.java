package me.lucashagen.mcstats.player;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SessionManager {

    HashMap<UUID, PlayerInfo> playerInfos;

    public SessionManager() {
        playerInfos = new HashMap<UUID, PlayerInfo>();
    }

    public void createSession(UUID uuid, String username) {
        playerInfos.put(uuid, new PlayerInfo(uuid, username));
    }

    public PlayerInfo getInfo(UUID uuid) {
        return playerInfos.getOrDefault(uuid, null);
    }

    public void endSession(UUID uuid) {
        PlayerInfo info = getInfo(uuid);

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
