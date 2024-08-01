# Clubs

* **Level**: User goal


* **Primary actor**: User (student)


* **Stakeholders and interests**:

  -- **Student (average user)**: Has the ability to browse clubs and add a club.

* **Preconditions**:

  -- User is authenticated and logged in to the application

* **Postconditions**:

  -- Users can view the list of all clubs

  -- Users can successfully add a club

* **Non-functional requirements**

  --Usability: User needs to have an Android device that is compatible with the application

  --Performance: Viewing and adding clubs should run below 2 second within 95% of the time

  --Supportability: Text formatting should be internalized

Blue: User, Orange: System
```plantuml
@startuml
start
#SkyBlue: Student opens ""club"" page;
#Orange:repeat: Renders list of clubs;
split
#SkyBlue: Clicks "club";
#Orange: Renders ""club"" information;
split
#SkyBlue: __Add ""club""__;
splitagain
#SkyBlue: Return to ""club"" page;
endsplit
split again
#SkyBlue: Return ""home"";
#Orange: Renders ""home"" page;
end
end split

repeat while
end
@enduml
```
