# Calendar 

* **Level**: User goal


* **Primary actor**: User (student)


* **Stakeholders and interests**:

  -- **Student (average user)**: Wants to be able to utilize the calendar to view 
  when upcoming club meeting and events are

  -- **Club executives**: Use the calendar to effectively plan out events and meetings
  to avoid time conflicts with GB members


* **Preconditions**:

  -- User is authenticated and logged in to the application


* **Postconditions**: 

  -- Calendar is correctly rendered with user's upcoming events and meetings 

  -- Users can successfully add and remove events and meetings from the calendar

  -- Users can filter which events and meetings 

* **Non-functional requirements**
  
  --Usability: user needs to have an Android device that is compatible with the application

  --Performance: Search and filter processes should be under 1-2 seconds within 95% of the time and calendar should render and update around similar time.

  --Supportability: Date, text, number formatting should be internalized

    




Blue: User, Orange: System
```plantuml
@startuml
start
#SkyBlue:Student opens **calendar**;
#Orange:repeat: Renders **calendar** in ""day"" view;
split
split
   #SkyBlue: Changes to ""week"" view;
   #Orange: Render ""week"" view;
split again
   #SkyBlue: Changes to ""month"" view;
   #Orange: Render ""month"" view;
split again
   #SkyBlue: Changes to ""year"" view;
   #Orange: Render ""year"" view;
split again
   #SkyBlue: Returns to ""home"";
   #Orange: Renders ""home"";
   end
end split
split again
   #SkyBlue: __Add ""event""__;
split again
#SkyBlue: Student wants to remove event;
split
    #SkyBlue: Student clicks on event in timeline;
split again
    #SkyBlue: Student clicks on event in list;
endsplit
#Orange: Displays options: remove/manage;
   split
   #SkyBlue: __Remove ""event""__;
   split again
   #SkyBlue: __Manage ""event""__;
   end split
end split
repeat while ( Clicks a ""day"" )
end                                                    
@enduml
```