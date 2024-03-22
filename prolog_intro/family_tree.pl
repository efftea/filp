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


%Построить предикаты men и women, которые выводят на экран всех мужчин и всех женщин соответственно.
men():- man(X), print(X), nl, fail.
women():- woman(X), print(X), nl, fail.

%Построить предикат, который children(X), который выводит всех детей X.
%children(+X)
children(X):- parent(X,Y), print(Y), nl, fail.

%Построить предикат mother(X, Y), который проверяет, является ли X матерью Y.
%mother(+X, +Y)
mother(X,Y):- woman(X), parent(X,Y).

%Построить предикат, mother(+X), который выводит маму X.
%mother(+X)
mother(X):- mother(Y,X), print(Y), nl, fail.

%Построить предикат brother(X, Y), который проверяет, является ли X братом Y.
%brother(+X,+Y)
brother(X,Y):- man(X), mother(Z,X), mother(Z,Y), X \= Y.

%Построить предикат brother(X), который выводит всех братьев X.
%brother(+X)
brother(X):- brother(Y,X), print(Y), print(Y), nl, fail.

%Построить предикат b_s(X,Y), который проверяет, являются ли X и Y родными братом и сестрой или братьями или сестрами.
%b_s(+X,+Y)
b_s(X,Y):- parent(Z,X), mother(Z, Y), X\=Y.

%Построить предикат b_s(X), который выводит всех братьев или сестер X.
%b_s(+X)
b_s(X):- b_s(Y,X), print(Y), nl, fail.

%Построить предикат b_s(X), который выводит всех братьев или сестер X.
%b_s(+X)
son(X,Y):- man(X), parent(Y,X).
son(X):- son(Y,X), print(Y), nl, fail.

%Построить предикат husband(X,Y), который проверяет является ли X мужем Y.
%husband(+X,+Y)
husband(X,Y):- man(X), parent(X, Z), parent(Y, Z), X \= Y.
husband(X):- husband(Y, X), print(Y), nl, fail.

%Построить предикат grand_pa(X,Y), который проверяет является ли X дедушкой Y.
%grand_pa(+X,+Y)
grand_pa(X,Y):- man(X), parent(Z,Y), parent(X,Z).
grand_pa(X):- grand_pa(Y,X), print(Y), nl, fail.

%Построить предикат grand_pa_and_da(X,Y), который проверяет являются ли X и Y друг другу дедушкой и внучкой.
%grand_pa_and_da(+X,+Y)
grand_pa_and_da(X,Y):- (woman(Y), grand_pa(X,Y));(woman(X), grand_pa(Y,X)).

%Построить предикат aunt(X,Y), который проверяет является ли X тётей Y.
%aunt(+X,+Y)
aunt(X,Y):- woman(X), parent(Z,Y), parent(V,Z), parent(V,X), X \= Z.
aunt(X):- aunt(Y,X), print(Y), nl, fail.

