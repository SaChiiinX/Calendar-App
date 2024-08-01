How to test the prototype:

Inputs that can be provided:
c / calendar (case-insensitive) this will tell the prototype to switch to the calendar view, must see initial message
asking users to choose.

s / search (case-insensitive) this will tell the prototype to let the user search for clubs and events,
also needs to be in the initial screen. 

quit - will return users to the initial screen at anytime.

When in the club view,

month (CI) - this will let the user switch to a month view, if already in day view, will switch the the month that day is in
otherwise, user will need to input 1-12 (jan-dec) (numbers only) to view a specific month.

day (CI) - this will let the user switch to a day view, they will need to also input a number representing the day of the month.
If user attempts to switch while in year view, will need to input both a month and a day, while in month view will only need to
input a day.

year (CI) - automatically swap to a year view for 2023 (or whatever year the prototype is being run in).

add (CI) - this can only be used in day view but will let users add events to that current day.
remove (CI) - can only be used in day view but will let users remove events from that day. 

to input events the user just needs to type in the event name, given that the event matches the day they are in.

possible events include (exact typing) "Lunar New Year Celebration", "Early Bird Pilates" "Kpop Showcase", these all
are registered to be on 2023-03-22 (march 22nd 2023). Custom event adding will be included later

Event removal can occur once the above events are added to the corresponding day and just entering removal and the event name.


When in search mode.

To let it know to search for clubs, input "club" (CI) or "event" (CI). Then type in the string name to be searched and
it will look in the corresponding database for the event or club. the name of either will be returned or no results found
for if the database does not have that entry. To search for clubs, use "Asian Student Association"