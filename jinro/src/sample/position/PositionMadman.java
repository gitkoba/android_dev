package sample.position;

public class PositionMadman extends Position {
	public PositionMadman(){
		positionName = "狂人";
		positonExplanation = "りあきょうおことわり";
		setPositionStatus(Position._madman, Position._TeamWerewolf, Position._TeamCitizen);
	}
}
