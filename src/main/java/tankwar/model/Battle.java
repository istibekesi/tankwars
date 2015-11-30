package tankwar.model;


/**
 *  Model for Battle
 */
public class Battle {
	
	private Integer bottleId;
	private String offensePlayer;
	private String defensePlayer;
	private String offenseCode;
	private String deffenseCode;
	private BattleStatus result;
	
	public Battle () {
		this.result = BattleStatus.OPEN;
	}
			
			
	public Battle (String offensePlayer, String offenseCode) {
		this.result = BattleStatus.OPEN;
		this.offensePlayer = offensePlayer;
		this.offenseCode = offenseCode;
	}
	
	public Integer getBottleId() {
		return bottleId;
	}
	public void setBottleId(Integer bottleId) {
		this.bottleId = bottleId;
	}
	public String getOffensePlayer() {
		return offensePlayer;
	}
	public void setOffensePlayer(String offensePlayer) {
		this.offensePlayer = offensePlayer;
	}
	public String getDefensePlayer() {
		return defensePlayer;
	}
	public void setDefensePlayer(String defensePlayer) {
		this.defensePlayer = defensePlayer;
	}
	public String getOffenseCode() {
		return offenseCode;
	}
	public void setOffenseCode(String offenseCode) {
		this.offenseCode = offenseCode;
	}
	public String getDeffenseCode() {
		return deffenseCode;
	}
	public void setDeffenseCode(String deffenseCode) {
		this.deffenseCode = deffenseCode;
	}
	public BattleStatus getResult() {
		return result;
	}
	public void setResult(BattleStatus result) {
		this.result = result;
	}
	
}
