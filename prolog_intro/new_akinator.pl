%genre(+Object)
genre(shooter) :-
    query('Does your game have a shooter genre?').

genre(strategy) :-
    query('Does your game have a strategy genre?').

genre(RPG) :-
    query('Does your game have a RPG genre?').

genre(horror) :-
    query('Does your game have a horror genre?').

genre(stealth) :-
    query('Does your game have a stealth genre?').

genre(survival) :-
    query('Does your game have a survival genre?').

genre(battle_royale) :-
    query('Does your game have a battle royale genre?').

genre(action) :-
    query('Does your game have a action genre?').

%game(+Game)
game(cyberpunk_2077):-
    genre(shooter),
    genre(action),
    genre(RPG).

game(red_dead_redemption_2):-
    genre(action),
    genre(shooter).

game(metro_exodus) :-
    genre(shooter),
    genre(action),
    genre(stealth).

game(warcraft_3) :-
    genre(strategy),
    genre(RPG).

game(state_of_survival) :-
    genre(strategy),
    genre(action),
    genre(horror).

game(spore) :-
    genre(strategy),
    genre(RPG),
    genre(action).

game(baldurs_gate_3) :-
    genre(RPG).

game(starfield) :-
    genre(RPG),
    genre(action).

game(assasin_creed_valhalla) :-
    genre(RPG),
    genre(action),
    genre(stealth).

game(lethal_company) :-
    genre(horror),
    genre(action).

game(resident_evil_5) :-
    genre(horror),
    genre(shooter),
    genre(action).

game(resident_evil_2) :-
    genre(horror),
    genre(shooter),
    genre(action),
    genre(stealth).

game(assasin_creed_mirage) :-
    genre(stealth),
    genre(action).

game(dishonored) :-
    genre(stealth).

game(valheim) :-
    genre(survival),
    genre(action).

game(astroneer) :-
    genre(survival),
    genre(action),
    genre(strategy).

game(sons_of_the_forest) :-
    genre(survival),
    genre(action),
    genre(horror).

game(enshrouded) :-
    genre(survival),
    genre(action),
    problem(RPG).

game(rust) :-
    genre(survival),
    genre(action),
    genre(shooter).

game(fortnite) :-
    genre(battle_royale),
    genre(action),
    genre(shooter).

game(naraka_bladepoint) :-
    genre(battle_royale),
    problem(RPG).
