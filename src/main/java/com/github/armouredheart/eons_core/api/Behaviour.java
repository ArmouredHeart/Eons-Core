package com.github.armouredheart.eons_core.api;

/**@apiNote this enumerator works with the ai builder to determine the behaviour of species mobs */
public enum Behaviour {
    // predator mob ai
    PREDATOR,
    
    // herbivore mob ai
    HERBIVORE,
    
    // scavenger
    SCAVENGER,

    // temperments
    COWARD, // will try to run away
    AGGRESSIVE, // will attack if given opportunity
    PASSIVE, // will never attack
    DEFENSIVE, // will attack if threatened

    // not mobs
    PLANT,
    MUSHROOM;
}
