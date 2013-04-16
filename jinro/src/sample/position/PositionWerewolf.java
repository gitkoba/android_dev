package sample.position;

public class PositionWerewolf extends Position {
	public PositionWerewolf() {
		positionName = "人狼";
		positonExplanation = "たべちゃうyp";
		setPositionStatus(Position._werewolf, Position._TeamWerewolf, Position._TeamWerewolf);
	}
}
