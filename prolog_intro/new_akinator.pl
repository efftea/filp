%main()
 main :-
    retractall(asked(_,_)),
    game(Genre),
    !,
    nl,
    write('Your game is '), write(Genre), write(.), nl.
main :-
    nl,
    write('The game cannot be recognized.'), nl.

%genre(+Object)
genre(shooter) :-
    query('Does your game have a shooter genre?').

genre(strategy) :-
    query('Does your game have a strategy genre?').

genre(rpg) :-
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
game(resident_evil_2) :-
    genre(horror),
    genre(shooter),
    genre(action),
    genre(stealth).

game(cyberpunk_2077):-
    genre(shooter),
    genre(action),
    genre(rpg).

game(metro_exodus) :-
    genre(shooter),
    genre(action),
    genre(stealth).

game(state_of_survival) :-
    genre(strategy),
    genre(action),
    genre(horror).

game(spore) :-
    genre(strategy),
    genre(rpg),
    genre(action).

game(assasin_creed_valhalla) :-
    genre(rpg),
    genre(action),
    genre(stealth).

game(resident_evil_5) :-
    genre(horror),
    genre(shooter),
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
    genre(rpg).

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
    genre(rpg).

game(red_dead_redemption_2):-
    genre(action),
    genre(shooter).

game(warcraft_3) :-
    genre(strategy),
    genre(rpg).

game(starfield) :-
    genre(rpg),
    genre(action).

game(lethal_company) :-
    genre(horror),
    genre(action).

game(assasin_creed_mirage) :-
    genre(stealth),
    genre(action).

game(valheim) :-
    genre(survival),
    genre(action).

game(dishonored) :-
    genre(stealth).

game(baldurs_gate_3) :-
    genre(rpg).

%query(+Prompt)
query(Prompt) :-
    (   asked(Prompt, Reply) -> true
    ;   nl, write(Prompt), write(' (y/n)? '),
        read(X),(X = y -> Reply = y ; Reply = n),
	assert(asked(Prompt, Reply))
    ),
    Reply = y.