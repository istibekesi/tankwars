package tankwar.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import tankwar.model.Battle;

public class BattleRepository {
	private final Map<Integer, Battle> battles = new HashMap<Integer, Battle>();
	
	private static AtomicInteger seq = new AtomicInteger(0);
	
	public int generateBattleId() {
		return seq.incrementAndGet();
	} 
	
    public void addBattle(Battle battle) {
    	if (battle.getBottleId() == null) {
    		battle.setBottleId(generateBattleId());
    	}
    	battles.put( battle.getBottleId(), battle );
    }

    public void removeBattle(int battleId) {
    	battles.remove(battleId);
    }

    public List<Battle> getBattles() {
        return new ArrayList(battles.values());
    }

    public Battle getBattleById(int id) {
        return battles.get(id);
    }

    
}
