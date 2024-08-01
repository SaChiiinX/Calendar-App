Blue: User, Orange: System
```plantuml
start
#SkyBlue: Student wants to manage event;
#Orange: Renders prefilled required fields page;
split
#SkyBlue: Changes required fields;
#SkyBlue: Confirm changes;
#Orange: Update ""event"";
#Orange: Update user calendar;
split again
#SkyBlue: Cancel manage ""event"";
end split
end
```