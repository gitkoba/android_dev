package sample.yaku;
import java.util.List;
import java.util.Map;

public class GameMaster {

	private static List<Player> players;
	private Pollstation pollStation;
	private Timer timer;
	private Option option;
	private static PositionSetting positionSetting;

	public GameMaster(){
		option = new Option();
		timer = new Timer(option);
	}
	public void linkMessage(String message, Player sendPlayer){

	}
	//TODO 役職決めルーチン
	private void decisionPosition(){
		for(int i = 0; players.size() > i; i++){


		}
	}
	public static void constructionvillage(Map<Integer, Integer> positionMap){
		//positionSetting.setPosition(positionMap);
	}
	public void gameStart(){

	}
	public void poolStart(){

	}
	public void meetingStart(){

	}
	public void nightStart(){

	}
	public void punishment(Player player){
		player.death();
	}
	public void notifyTimerEnd(){
		List<Player> list = pollStation.mustPolledPlayer();
		if(list.size() == 1) punishment(list.get(0));
		else{
			//TODO
		}
	}
	public void notifyPunishment(Player player){
		punishment(players.get(players.indexOf(player)));
	}

	public static int getPlayerSize(){
		return players.size();
	}
	public Option getOption(){
		return option;
	}

}