package sample.position;

public class PositionFortuneTeller extends Position {
	public PositionFortuneTeller() {
		positionName = "占い師";
		positonExplanation = "うらなう";
		setPositionStatus(Position._fortuneTeller, Position._TeamCitizen, Position._TeamCitizen);
	}
}
