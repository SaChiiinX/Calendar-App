Blue: User, Orange: System
```plantuml
@startuml
start
#SkyBlue: Student wants to leave ""club"";
split
#SkyBlue: Confirms leave ""club"";
#Orange: Updates ""user"" clubs;
#Orange: Updates ""user"" calendar;
#Orange: Updates members of clubs in datatbase;
split again
#SkyBlue: Cancels leave ""club"";
end
endsplit
end
@enduml
```