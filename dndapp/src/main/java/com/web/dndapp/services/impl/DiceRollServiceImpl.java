package com.web.dndapp.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.web.dndapp.services.DiceRollService;

@Service
public class DiceRollServiceImpl implements DiceRollService {
	
	private Random rand = new Random();

	@Override
	public int rollDice(int die, int number) {
		int total = 0;
		for (int i = 0; i < number; i++) {
			total += (1 + rand.nextInt(die));
		}
		return total;
	}

	@Override
	public Map<String, Integer> rollAllDiceOnce() {
		Map<String, Integer> rolls = new HashMap<>();
		rolls.put("20", (1 + rand.nextInt(20)));
		rolls.put("12", (1 + rand.nextInt(12)));
		rolls.put("10", (1 + rand.nextInt(10)));
		rolls.put("100", (1 + rand.nextInt(100)));
		rolls.put("8", (1 + rand.nextInt(8)));
		rolls.put("6", (1 + rand.nextInt(6)));
		rolls.put("4", (1 + rand.nextInt(4)));
		return rolls;
	}

}
