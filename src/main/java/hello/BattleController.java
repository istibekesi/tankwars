package hello;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import tankwar.model.Battle;
import tankwar.model.BattleStatus;

@Controller
@RequestMapping("/tanks")
public class BattleController {

	
	/**
	 * List all battles 
	 */
    @RequestMapping(
            value = "/battles",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody public List<Battle> battles(){
    	return Application.repo.getBattles();
    }
    
    /**
     * Get battle by id 
     */
    @RequestMapping(
            value = "/battle/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody public Battle battleById(@PathVariable int id){
    	return Application.repo.getBattleById(id);
    }
    
    
    /**
     * Add new battle 
     */
    @RequestMapping(
            value = "/battle",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody public void createBattle(@RequestBody Battle battle){
    	Application.repo.addBattle(battle);
    	return;
    }
    
    
    /**
     * Accept Battle
     */
    @RequestMapping(value = "/battle/{id}/accept",
            method = RequestMethod.PUT)
    public ResponseEntity acceptBattle(@PathVariable int id , @RequestBody Battle battle) {

        Battle existingOpenBattle = Application.repo.getBattleById(id);

        if (existingOpenBattle == null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }

        existingOpenBattle.setDefensePlayer(battle.getDefensePlayer());
        existingOpenBattle.setDeffenseCode(battle.getDeffenseCode());
        existingOpenBattle.setResult(BattleStatus.BATTLE_IN_PROGRESS);

        return new ResponseEntity<String>(HttpStatus.OK);

    }
    
    /**
     * Win the Battle
     */
    @RequestMapping(value = "/battle/{id}/win",
            method = RequestMethod.PUT)
    public ResponseEntity winBattle(@PathVariable int id , @RequestBody Battle battle) {

        Battle existingOpenBattle = Application.repo.getBattleById(id);

        if (existingOpenBattle == null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }

        /*
         * TODO : handle conflicts if clients are sending conflicting results 
         * 
         * return new ResponseEntity<String>(HttpStatus.CONFLICT);
         * 
         */
        
        existingOpenBattle.setResult(battle.getResult());

        return new ResponseEntity<String>(HttpStatus.OK);

    }
    
    /**
     * Delete battle by id 
     */
    @RequestMapping(
            value = "/battle/{id}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody public ResponseEntity deleteBattle(@PathVariable int id){
    	
    	Battle existingBattle = Application.repo.getBattleById(id);
    	
        if (existingBattle == null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    	
        Application.repo.removeBattle(id);

        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    
}
