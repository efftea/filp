man(voeneg).
man(ratibor).
man(boguslav).
man(velerad).
man(duhovlad).
man(svyatoslav).
man(dobrozhir).
man(bogomil).
man(zlatomir).

woman(goluba).
woman(lubomila).
woman(bratislava).
woman(veslava).
woman(zhdana).
woman(bozhedara).
woman(broneslava).
woman(veselina).
woman(zdislava).

parent(voeneg,ratibor).
parent(voeneg,bratislava).
parent(voeneg,velerad).
parent(voeneg,zhdana).

parent(goluba,ratibor).
parent(goluba,bratislava).
parent(goluba,velerad).
parent(goluba,zhdana).

parent(ratibor,svyatoslav).
parent(ratibor,dobrozhir).
parent(lubomila,svyatoslav).
parent(lubomila,dobrozhir).

parent(boguslav,bogomil).
parent(boguslav,bozhedara).
parent(bratislava,bogomil).
parent(bratislava,bozhedara).

parent(velerad,broneslava).
parent(velerad,veselina).
parent(veslava,broneslava).
parent(veslava,veselina).

parent(duhovlad,zdislava).
parent(duhovlad,zlatomir).
parent(zhdana,zdislava).
parent(zhdana,zlatomir).

men():- man(X), print(X), nl, fail.

women():- woman(X), print(X), nl, fail.

children(X):- parent(X,Y), print(Y), nl, fail.

mother(X,Y):- woman(X), parent(X,Y).
mother(X):- mother(Y,X), print(Y), nl, fail.

brother(X,Y):- man(X), mother(Z,X), mother(Z,Y), X \= Y.
brother(X):- brother(Y,X), print(Y), print(Y), nl, fail.

b_s(X,Y):- parent(Z,X), mother(Z, Y), X\=Y.
b_s(X):- b_s(Y,X), print(Y), nl, fail.

son(X,Y):- man(X), parent(Y,X).
son(X):- son(Y,X), print(Y), nl, fail.

husband(X,Y):- man(X), parent(X, Z), parent(Y, Z), X \= Y.
husband(X):- husband(Y, X), print(Y), nl, fail.

grand_pa(X,Y):- man(X), parent(Z,Y), parent(X,Z).
grand_pa(X):- grand_pa(Y,X), print(Y), nl, fail.

grand_pa_and_da(X,Y):- (woman(Y), grand_pa(X,Y));(woman(X), grand_pa(Y,X)).

aunt(X,Y):- woman(X), parent(Z,Y), parent(V,Z), parent(V,X), X \= Z.
aunt(X):- aunt(Y,X), print(Y), nl, fail.

