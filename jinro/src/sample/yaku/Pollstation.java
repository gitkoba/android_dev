package sample.yaku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Pollstation implements Serializable{

	private static final long serialVersionUID = 1L;
	/*
	 * pollList *1 投票者 *2 投票先
	 */
	private static Map<Player, Player> pollList;
	private static Map<Player, Integer> pollBox;

	public static void playerPoll(Player polledPlayer, Player pollPlayer) {
		pollList.put(pollPlayer, polledPlayer);
		if (pollBox.containsKey(polledPlayer)) {
			pollBox.put(polledPlayer, pollBox.get(polledPlayer).intValue() + 1);
		} else {
			pollBox.put(polledPlayer, 1);
		}
	}

	public List<Player> mustPolledPlayer(){
		int w = 0;
		List<Player> players = new ArrayList<Player>();
		Set<Player> list = pollBox.keySet();
		for (Player tmp : list) {
			int pollTmp = pollBox.get(tmp).intValue();
			if(w < pollTmp)	{
				w = pollTmp;
				players.clear();
				players.add(tmp);
			}
			else if (w == pollTmp)
				players.add(tmp);
		}

		return players;
	}

	public static Player selectedPollPlayer(Player pollPlayer){
		Player polledPlayer = pollList.get(pollPlayer);

		return polledPlayer;
	}
}
