Blue: User, Orange: System
```plantuml
start
#SkyBlue: Student opens ""event"" timeline page;
#Orange:repeat: Displays ""event"" timeline;
split
#SkyBlue: Clicks an ""event"";
#Orange: Renders ""event"" information;
split
#SkyBlue:__Add ""event""__;
split again
#SkyBlue: Return to ""event"" timeline;
endsplit
split again
#SkyBlue: Returns ""home"";
#Orange: Renders ""home"" page;
end
endsplit
repeat while
end
```