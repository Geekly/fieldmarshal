select firstName, lastName, tournaments.tournamentID 
from players, tournaments 
inner join Entrants
on players.playerid=entrants.playerid
where tournaments.tournamentID=1;

