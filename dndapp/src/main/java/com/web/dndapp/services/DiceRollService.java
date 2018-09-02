package com.web.dndapp.services;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface DiceRollService {

	public int rollDice(int die, int number);

	public Map<String, Integer> rollAllDiceOnce();
}
